package com.codedix.distantiaui

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.codedix.distantiaui.pages.FmScan

class MainActivity : AppCompatActivity() {

    companion object {

        var toolbar: ActionBar? = null
        var activity: Activity? = null
        var fragmentManager: FragmentManager? = null
        private var fragment: Fragment? = null
        private var title: String? = null
        var context: Context? = null

        fun setFragment(f: Fragment, t: String): Boolean {
            fragment = f
            title = t
            val ft = fragmentManager!!.beginTransaction()
            ft.setCustomAnimations(0, 0)
            ft.replace(R.id.fm_content, f, "").commitAllowingStateLoss()
            toolbar!!.title = title

            return true
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this
        activity = this
        MainActivity.fragmentManager = supportFragmentManager
        toolbar = supportActionBar

        setFragment(FmScan.newInstance(), context!!.getString(R.string.app_name))
    }
}
