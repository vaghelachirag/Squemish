package com.example.mypraticeapplication.view.detail

import android.Manifest
import android.R.attr
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Matrix
import android.graphics.Paint
import android.media.ExifInterface
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.FileProvider
import androidx.core.view.forEach
import com.example.mypraticeapplication.BuildConfig
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.databinding.FragmentPhotographBinding
import com.example.mypraticeapplication.interfaces.FragmentLifecycleInterface
import com.example.mypraticeapplication.uttils.AppConstants
import com.example.mypraticeapplication.uttils.ImagePickerDialog
import com.example.mypraticeapplication.uttils.Utility
import com.example.mypraticeapplication.uttils.Utility.Companion.setAllEnabled
import com.example.mypraticeapplication.uttils.onItemClick
import com.example.mypraticeapplication.view.base.BaseFragment
import com.example.mypraticeapplication.viewmodel.verificationDetail.PictureViewModel
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import java.io.File
import java.io.FileOutputStream
import java.util.Date
import java.util.Objects


class FragmentPhotograph: BaseFragment(), FragmentLifecycleInterface {


    private var _binding: FragmentPhotographBinding? = null
    // This property is only valid between onCreateView and
    private val binding get() = _binding!!
    var data : String = ""
    private val photoVerificationViewModel by lazy { PictureViewModel( context as Activity,binding) }

    private var imgFile: File? = null
    private var imagePath: Uri? = null
    private val cameraCode: Int = 0x50
    val galleryCode: Int = 0x51

    companion object {
        fun newInstance(): FragmentPhotograph {
            val bundle = Bundle()
            val fragmentPhotograph = FragmentPhotograph()
            fragmentPhotograph.arguments = bundle
            return fragmentPhotograph
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentPhotographBinding.inflate(inflater, container, false)
        binding.viewModel = photoVerificationViewModel
        binding.lifecycleOwner = this
        photoVerificationViewModel.init(context as Activity)

        setView()

        photoVerificationViewModel.isLoading.observe(requireActivity()) { isLoading ->
            if (isLoading && isAdded) showProgressbar()
            else if (!isLoading && isAdded) hideProgressbar()
        }

        binding.layoutCamera.setOnClickListener {
            checkImagePickerPermission()
        }

        return binding.root
    }

    private fun setView() {
        if(ActivityDetail.selectedData!!.getStatus() != null){
            if(ActivityDetail.selectedData!!.getStatus() == AppConstants.statusPending){
                binding.constraintLayout.forEach { child -> child.setAllEnabled(false) }
            }
            else{
                binding.constraintLayout.forEach { child -> child.setAllEnabled(true) }
            }
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == cameraCode && resultCode == Activity.RESULT_OK) {
            uploadImage()
        }
        if (requestCode == galleryCode && resultCode == Activity.RESULT_OK) {
            imagePath = Objects.requireNonNull(data!!).data
            imgFile = File(Objects.requireNonNull(imagePath?.let {
                Utility.getPath(requireActivity(), it)
            }))
            uploadImage()
        }
    }


    // For Check Image permission
    private fun checkImagePickerPermission() {
        Dexter.withActivity(requireActivity())
            .withPermissions(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE)
            .withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport?) {
                    openImagePickerDialog()

                   /* if (report!!.areAllPermissionsGranted()) {
                        openImagePickerDialog()
                    } else {
                        Utility.showSettingsDialog(requireActivity())
                    }
                    if (report.isAnyPermissionPermanentlyDenied) {
                        Utility.showSettingsDialog(requireActivity())
                    }*/
                }

                override fun onPermissionRationaleShouldBeShown(
                    permissions: MutableList<com.karumi.dexter.listener.PermissionRequest>?,
                    token: PermissionToken?
                ) {
                    token!!.continuePermissionRequest()
                }
            }).withErrorListener { }.onSameThread().check()
    }

    // For Check Image permission
    private fun openImagePickerDialog() {
        ImagePickerDialog(requireActivity(), object : onItemClick {
            override fun onCameraClicked() {
                displayCamera()
            }

            override fun onGalleryClicked() {
                val pickPhoto =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(pickPhoto, galleryCode)
            }
        }).show()
    }

    // Display Camera Pic
    fun displayCamera() {
        val destPath: String? = Objects.requireNonNull(Objects.requireNonNull(requireActivity()).getExternalFilesDir(null)!!).absolutePath
        val imagesFolder = File(destPath, this.resources.getString(R.string.app_name))
        try {
            imagesFolder.mkdirs()
            imgFile = File(imagesFolder, Date().time.toString() + ".jpg")
            imagePath = FileProvider.getUriForFile(
                requireActivity(),
                BuildConfig.APPLICATION_ID  + ".fileProvider",
                imgFile!!
            )
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imagePath)
            startActivityForResult(intent, cameraCode)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    // For Upload Image
    @SuppressLint("DefaultLocale")
    private fun uploadImage() {
        if (imgFile != null) {
            val filePath: String = imgFile!!.absolutePath
            var bitmap = BitmapFactory.decodeFile(filePath)

            val ei = ExifInterface(filePath)
            val orientation: Int = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_UNDEFINED)
            Log.e("Rotation",orientation.toString())


            var angle  =  Utility.rotateImageAngle(orientation)

            bitmap = Utility.rotateImage(bitmap,angle)
            binding.ivImage.setImageBitmap(bitmap)

            val workingBitmap: Bitmap = Bitmap.createBitmap(bitmap)
            val mutableBitmap = workingBitmap.copy(Bitmap.Config.ARGB_8888, true)

            val builder = StringBuilder()
            builder.append(Utility.getCurrentDate()).append("\n")
            builder.append("Latitude: ").append(String.format("%.6f", ActivityDetail.currentLat)).append("\n")
            builder.append("Longitude: ").append(String.format("%.6f", ActivityDetail.currentLong)).append("\n")
            builder.append(ActivityDetail.useraddress)

            val scale = resources.displayMetrics.density

        //   saveToInternalStorage(mutableBitmap)

            val canvas1 = Canvas(mutableBitmap)
            // new antialiased Paint
            val paint1 = TextPaint(Paint.ANTI_ALIAS_FLAG)

            // text color - #3D3D3D
            paint1.color = Color.WHITE

            // text size in pixels
            paint1.textSize = 100F

            // text shadow
            paint1.setShadowLayer(1f, 0f, 0f, Color.WHITE)


            // set text width to canvas width minus 16dp padding
            val textWidth = canvas1.width - (16 * scale).toInt()


            // init StaticLayout for text
            val textLayout = StaticLayout(
                builder.toString(), paint1, textWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false
            )


            // get height of multiline text
            val textHeight = textLayout.height


            // get position of text's top left corner
            val x = ((mutableBitmap.width - textWidth) - 10).toFloat()
            val y = ((mutableBitmap.height - textHeight) - 40).toFloat()


            // draw text to the Canvas center
            canvas1.save()
            canvas1.translate(x, y)
            textLayout.draw(canvas1)
          //  binding.ivImage.setImageBitmap(mutableBitmap)
            saveImage(mutableBitmap)
        }

    }

    private fun saveImage(mutableBitmap: Bitmap?) {
        val destPath: String? = Objects.requireNonNull(Objects.requireNonNull(requireActivity()).getExternalFilesDir(null)!!).absolutePath
        val imagesFolder = File(destPath, this.resources.getString(R.string.app_name))
        try {
            imagesFolder.mkdirs()
            imgFile = File(imagesFolder, "LocationImage" + ".jpg")
            imagePath = FileProvider.getUriForFile(requireActivity(), com.example.mypraticeapplication.BuildConfig.APPLICATION_ID  + ".fileProvider", imgFile!!)

            val fOut: FileOutputStream = FileOutputStream(imgFile)
            val mutableBitmap = getResizedBitmap(mutableBitmap!!, 500);
            mutableBitmap.compress(Bitmap.CompressFormat.PNG, 50, fOut)
            fOut.flush()
            fOut.close()

            photoVerificationViewModel.saveSurveyPicture(imgFile!!)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }



    fun getResizedBitmap(image: Bitmap, maxSize: Int): Bitmap {
        var width = image.getWidth()
        var height = image.getHeight()
        val bitmapRatio = width.toFloat() / height.toFloat()
        if (bitmapRatio > 1) {
            width = maxSize
            height = (width / bitmapRatio).toInt()
        } else {
            height = maxSize
            width = (height * bitmapRatio).toInt()
        }
        return Bitmap.createScaledBitmap(image, width, height, true)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onPauseFragment() {
    }

    override fun onResumeFragment(s: String?) {

    }

}