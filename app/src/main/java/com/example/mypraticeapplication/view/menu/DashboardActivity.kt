package com.example.mypraticeapplication.view.menu
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mypraticeapplication.MainActivity
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.databinding.ActivityDashboardBinding
import com.example.mypraticeapplication.interfaces.OnItemSelected
import com.example.mypraticeapplication.model.getMenuListResponse.GetMenuListData
import com.example.mypraticeapplication.model.getMenuListResponse.GetMenuListResponse
import com.example.mypraticeapplication.network.CallbackObserver
import com.example.mypraticeapplication.network.Networking
import com.example.mypraticeapplication.uttils.AppConstants
import com.example.mypraticeapplication.uttils.Session
import com.example.mypraticeapplication.uttils.Utility
import com.example.mypraticeapplication.uttils.Utils
import com.example.mypraticeapplication.view.adapter.MenuItemAdapter
import com.example.mypraticeapplication.view.base.BaseActivity
import com.example.mypraticeapplication.view.dialougs.ChangePasswordDialoug
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


@Suppress("DEPRECATION")
class DashboardActivity : BaseActivity() {
    private lateinit var binding: ActivityDashboardBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private var activityDashboard : DashboardActivity? = null

    // Session
    var session: Session? = null;

    val isLoading = MutableLiveData<Boolean>()
    var menuList: ArrayList<GetMenuListData> = ArrayList()

    @SuppressLint("DiscouragedPrivateApi", "SimpleDateFormat", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDashboard = this
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard)
        session = Session(this);


        // Set up ActionBar
        setSupportActionBar(binding.toolbarDashboard)
        val actionBar = supportActionBar
        if (actionBar != null) {
            supportActionBar!!.setDisplayShowTitleEnabled(false)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
            supportActionBar!!.title ="Test"
        }

        getSessionData()


        supportActionBar!!.title = "Test"
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_nav_menup)

        navController = findNavController(R.id.navHostFragmentPickford)

        appBarConfiguration = AppBarConfiguration.Builder(
            R.id.dashboardFragment,
            R.id.settingFragment,
            R.id.dashboardFragment,
        ).setDrawerLayout(binding.drawer).build()


        setupActionBarWithNavController(
            navController,
            appBarConfiguration
        )

        setupNavControl()
        setDrawerAction()
        setupToolbarWithMenu(getString(R.string.dashboard),binding)
        getMenuListResponse()
    }

    private fun getSessionData() {
        val viewMenu = findViewById<View>(R.id.layoutMenu)
        val userName = viewMenu.findViewById<View>(R.id.txt_UserName) as TextView
        val profileImage = viewMenu.findViewById<View>(R.id.navHeaderLogo) as AppCompatImageView
        val options: RequestOptions = RequestOptions()
            .centerCrop()
            .placeholder(R.mipmap.ic_launcher_round)
            .circleCrop()
            .error(R.mipmap.ic_launcher_round)

        Glide.with(this).load(session!!.getUserProfileImageKey()).apply(options).into(profileImage)
        userName.text = session!!.getUserNameKey()
    }

    private fun setDrawerAction() {
        binding.navigationView.setNavigationItemSelectedListener { menuItem ->
            if (binding.drawer.isDrawerOpen(GravityCompat.START)) {
                binding.drawer.closeDrawer(GravityCompat.START)
            }

            when (menuItem.itemId) {
                R.id.dashboardFragment -> {
                    navController.navigate(R.id.dashboardFragment)
                    binding.toolbarDashboard.setTitle("Test")
                    supportActionBar!!.title = "test"
                    supportActionBar?.setDisplayShowHomeEnabled(false);
                    binding.toolbarDashboard.setNavigationIcon(null);

                }
                R.id.settingFragment -> {
                    navController.navigate(R.id.settingFragment)
                    binding.toolbarDashboard.setTitle(R.string.action_settings)
                    binding.toolbarDashboard.setNavigationIcon(null);

                }
                R.id.logout -> {
                    Utils().showAlertDialog(this,resources.getString(R.string.logoutAlert))
                }
            }
            true
        }
        binding.ivMenu.setOnClickListener {
            Log.e("Menu","MenuClicked")
            if (binding.drawer.isDrawerOpen(GravityCompat.START)) {
                binding.drawer.closeDrawer(GravityCompat.START)
            }else{
                binding.drawer.openDrawer(GravityCompat.START)
            }
        }
    }

    private fun showLogoutAlertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Are You Sure Want To Logout?")

        builder.setPositiveButton(android.R.string.yes) { _, _ ->
            session!!.clearSession()
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        builder.setNegativeButton(android.R.string.no) { _, _ ->
            Toast.makeText(applicationContext,
                android.R.string.no, Toast.LENGTH_SHORT).show()
        }
        builder.show()
    }

    private fun setupNavControl() {
        binding.navigationView.setupWithNavController(navController) //Setup Drawer navigation with navController
    }

    private fun getMenuListResponse() {
        if (Utility.isNetworkConnected(this)){
            isLoading.postValue(true)
            Networking.with(this)
                .getServices()
                .getMenuListResponse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : CallbackObserver<GetMenuListResponse>() {
                    override fun onSuccess(response: GetMenuListResponse) {
                        isLoading.postValue(false)
                    }

                    override fun onFailed(code: Int, message: String) {
                        isLoading.postValue(false)
                    }

                    @SuppressLint("NotifyDataSetChanged")
                    override fun onNext(t: GetMenuListResponse) {
                        Log.e("Status",t.getStatusCode().toString())
                        isLoading.postValue(false)
                        if(t.getStatusCode() == 200){
                            if(t.getData() != null){
                                menuList  =  t.getData()!!
                                menuList.sortBy { it.getOrderNo() }
                                setMenuAdapter()
                            }
                        }else{
                            Utils().showToast(this@DashboardActivity ,t.getMessage().toString())
                        }
                    }
                })
        }else{

        }
    }

    @SuppressLint("NotifyDataSetChanged")
    public fun setMenuAdapter() {
        binding.rvMenu.layoutManager = LinearLayoutManager(this)
        binding.rvMenu.adapter = MenuItemAdapter(this, menuList,object : OnItemSelected<GetMenuListData>{

            override fun onItemSelected(t: GetMenuListData?, position: Int) {
                clickMenuEvent(t)
            }

        })

        binding.rvMenu.addItemDecoration(
            DividerItemDecoration(
                binding.rvMenu.context,
                (binding.rvMenu.layoutManager as LinearLayoutManager).orientation
            )
        )
    }

    private fun clickMenuEvent(menuData: GetMenuListData?) {
        if (binding.drawer.isDrawerOpen(GravityCompat.START)) {
            binding.drawer.closeDrawer(GravityCompat.START)
        }
        if (menuData!!.getIsWebView() == true){

            val bundle = Bundle()
            bundle.putString("webURL", menuData.getMenuId().toString())

            if (title != null) binding.tvTitle.text = menuData.getName()

            binding.toolbarDashboard.setTitle(menuData.getName())
            navController.navigate(R.id.webViewFragment,bundle)
            supportActionBar?.setDisplayShowHomeEnabled(false);
            binding.toolbarDashboard.setNavigationIcon(null);
        }else{

            if (menuData.getMenuId() == AppConstants.home){
                navController.navigate(R.id.dashboardFragment)
                supportActionBar?.setDisplayShowHomeEnabled(false);
                binding.toolbarDashboard.setNavigationIcon(null);
                if (title != null) binding.tvTitle.text = "Dashboard"
            }
            if (menuData.getMenuId() == AppConstants.changePassword){
              /*  navController.navigate(R.id.changePasswordFragment)
                binding.toolbarDashboard.setTitle(R.string.changePassword_Txt)
                binding.toolbarDashboard.setNavigationIcon(null);*/
                //showChangePasswordDialoug()
                Utils().showChangePasswordDialog(this,binding)
            }
            if (menuData.getMenuId() == AppConstants.logout){
                Utils().showAlertDialog(this,resources.getString(R.string.logoutAlert))
            }
        }
    }

    private fun showChangePasswordDialoug() {
        ChangePasswordDialoug(this)
            .setListener(object : ChangePasswordDialoug.OkButtonListener {
                override fun onOkPressed(
                    acceptRejectFIDialog: ChangePasswordDialoug
                ) {

                }

            })
            .show()
    }
}