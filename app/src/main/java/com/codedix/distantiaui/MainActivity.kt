package com.codedix.distantiaui

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.codedix.distantiaui.bottombar.DistantiaBottomBar
import com.codedix.distantiaui.pages.FmInformation
import com.codedix.distantiaui.pages.FmProfile
import com.codedix.distantiaui.pages.FmScan
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {

        var toolbar: ActionBar? = null
        var activity: Activity? = null
        var fragmentManager: FragmentManager? = null
        private var fragment: Fragment? = null
        private var title: String? = null
        var context: Context? = null
        private var bottomNav: DistantiaBottomBar? = null
        private var fabButton: FloatingActionButton? = null
        private var centerItem: MenuItem? = null

        fun setFragment(f: Fragment, t: String, showFAB: Boolean = false): Boolean {
            fragment = f
            title = t
            val ft = fragmentManager!!.beginTransaction()
            ft.setCustomAnimations(0, 0)
            ft.replace(R.id.fm_content, f, "").commitAllowingStateLoss()
            toolbar!!.title = title

            if(showFAB) bottomNav!!.showFAB(fabButton!!)
            else bottomNav!!.hideFAB(fabButton!!)

            return true
        }
    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item: MenuItem ->
            centerItem!!.icon = getDrawable(R.drawable.ic_service)
            when (item.itemId) {
                R.id.n_profile ->
                    return@OnNavigationItemSelectedListener setFragment(FmProfile.newInstance(), context!!.getString(R.string.profile))
                R.id.n_scan -> {
                    centerItem!!.icon = getDrawable(android.R.color.transparent)
                    return@OnNavigationItemSelectedListener setFragment(FmScan.newInstance(), context!!.getString(R.string.service), true)
                }
                R.id.n_info ->
                    return@OnNavigationItemSelectedListener setFragment(FmInformation.newInstance(), context!!.getString(R.string.info))
            }
            false
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this
        activity = this
        MainActivity.fragmentManager = supportFragmentManager
        toolbar = supportActionBar

        bottomNav = findViewById(R.id.bottomNavigationView)
        centerItem = bottomNav!!.menu.findItem(R.id.n_scan)
        bottomNav!!.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        fabButton = findViewById(R.id.fab)

        setFragment(FmScan.newInstance(), context!!.getString(R.string.app_name), true)
    }
}
