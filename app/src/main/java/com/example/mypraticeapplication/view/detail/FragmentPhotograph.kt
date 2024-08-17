package com.example.mypraticeapplication.view.detail

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.FileProvider
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.databinding.FragmentPhotographBinding
import com.example.mypraticeapplication.interfaces.FragmentLifecycleInterface
import com.example.mypraticeapplication.model.getverificationDetailResponse.GetVerificationDetailData
import com.example.mypraticeapplication.uttils.ImagePickerDialog
import com.example.mypraticeapplication.uttils.Utility
import com.example.mypraticeapplication.uttils.onItemClick
import com.example.mypraticeapplication.view.base.BaseFragment
import com.example.mypraticeapplication.viewmodel.verificationDetail.PictureViewModel
import com.karumi.dexter.BuildConfig
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import java.io.File
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
        fun newInstance(selectedData: GetVerificationDetailData?): FragmentPhotograph {
            val bundle = Bundle()
            //  bundle.putSerializable(DATA, selectedData)
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
        photoVerificationViewModel.init(context)

        photoVerificationViewModel.isLoading.observe(requireActivity()) { isLoading ->
            if (isLoading && isAdded) showProgressbar()
            else if (!isLoading && isAdded) hideProgressbar()
        }

        binding.layoutCamera.setOnClickListener {
            checkImagePickerPermission()
        }
        return binding.root
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
        val destPath: String? = Objects.requireNonNull(
            Objects.requireNonNull(requireActivity()).getExternalFilesDir(null)!!
        ).absolutePath
        val imagesFolder = File(destPath, this.resources.getString(R.string.app_name))
        try {
            imagesFolder.mkdirs()
            imgFile = File(imagesFolder, Date().time.toString() + ".jpg")
            imagePath = FileProvider.getUriForFile(
                requireActivity(),
                BuildConfig.APPLICATION_ID + ".fileProvider",
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
    private fun uploadImage() {
        if (imgFile != null) {
            val filePath: String = imgFile!!.path
            val bitmap = BitmapFactory.decodeFile(filePath)
            Log.e("ImageBitmap",bitmap.toString())
            photoVerificationViewModel.saveSurveyPicture(bitmap!!, imgFile!!.absolutePath,imgFile!!)
        }

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