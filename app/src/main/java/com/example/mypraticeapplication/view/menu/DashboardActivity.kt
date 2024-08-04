package com.example.mypraticeapplication.view.menu
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.example.mypraticeapplication.MainActivity
import com.example.mypraticeapplication.R
import com.example.mypraticeapplication.databinding.ActivityDashboardBinding
import com.example.mypraticeapplication.uttils.Session
import com.example.mypraticeapplication.view.SplashScreen
import com.example.mypraticeapplication.view.base.BaseActivity
import com.google.android.material.navigation.NavigationView


class DashboardActivity : BaseActivity() {
    private lateinit var binding: ActivityDashboardBinding
    lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    public var activityDashboard : DashboardActivity? = null


    var session: Session? = null;

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
            supportActionBar!!.title = getString(com.example.mypraticeapplication.R.string.dashboard)
        }

        getSessionData()

        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_nav_menup)

        navController = findNavController(R.id.navHostFragmentPickford)

        appBarConfiguration = AppBarConfiguration.Builder(
            R.id.dashboardFragment,
            //            R.id.surveyDetailsFragment,
            R.id.settingFragment,
            R.id.dashboardFragment,
            //            R.id.termsAndConditionFragment,
            //            R.id.privacyPolicyFragment
        ).setDrawerLayout(binding.drawer).build()


        setupActionBarWithNavController(
            navController,
            appBarConfiguration
        )

        setupNavControl()
        setDrawerAction()
        setupToolbarWithMenu(getString(R.string.dashboard),binding)
    }

    private fun getSessionData() {
        val navigationView = findViewById<View>(com.example.mypraticeapplication.R.id.navigationView) as NavigationView
        val headerView = navigationView.getHeaderView(0)
        val navUsername = headerView.findViewById<View>(com.example.mypraticeapplication.R.id.txt_UserName) as TextView

        val profileImage = headerView.findViewById<View>(com.example.mypraticeapplication.R.id.navHeaderLogo) as AppCompatImageView

        val options: RequestOptions = RequestOptions()
            .centerCrop()
            .placeholder(R.mipmap.ic_launcher_round)
            .circleCrop()
            .error(R.mipmap.ic_launcher_round)

        Glide.with(this).load(session!!.getUserProfileImageKey()).apply(options).into(profileImage)
        navUsername.text = session!!.getUserNameKey()
    }

    private fun setDrawerAction() {
        binding.navigationView.setNavigationItemSelectedListener { menuItem ->
            if (binding.drawer.isDrawerOpen(GravityCompat.START)) {
                binding.drawer.closeDrawer(GravityCompat.START)
            }

            when (menuItem.itemId) {
                R.id.dashboardFragment -> {
                    navController.navigate(R.id.dashboardFragment)
                    binding.toolbarDashboard.setTitle(R.string.dashboard)
                    supportActionBar?.setDisplayShowHomeEnabled(false);
                    binding.toolbarDashboard.setNavigationIcon(null);
                }
                R.id.settingFragment -> {
                    navController.navigate(R.id.settingFragment)
                    binding.toolbarDashboard.setTitle(R.string.action_settings)
                    binding.toolbarDashboard.setNavigationIcon(null);
                }
                R.id.logout -> {
                 showLogoutAlertDialoug()
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

    private fun showLogoutAlertDialoug() {
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

    public fun RedirectToDashboard(){

    }
}