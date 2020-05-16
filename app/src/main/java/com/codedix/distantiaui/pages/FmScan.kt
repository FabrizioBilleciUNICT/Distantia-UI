package com.codedix.distantiaui.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import com.codedix.distantiaui.MainActivity
import com.codedix.distantiaui.MainActivity.Companion.toolbar
import com.codedix.distantiaui.R
import com.codedix.filterbar.FilterBar


class FmScan : Fragment() {

    companion object {


        fun newInstance(): FmScan {
            return FmScan()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fm_scan, container, false)

        toolbar!!.setDisplayHomeAsUpEnabled(false)
        setHasOptionsMenu(true)

        val rl = view.findViewById<RelativeLayout>(R.id.rl_filters)
        val fb = FilterBar(MainActivity.context!!, true, listOf("Tutti i dispositivi", "Solo App"), arrayListOf("Tutti i dispositivi"), "Filtro")
        rl.addView(fb)

        fb.filterUpdated = {
            System.err.println(it)
        }

        return view
    }
}