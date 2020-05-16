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


class FmInformation : Fragment() {

    companion object {


        fun newInstance(): FmInformation {
            return FmInformation()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fm_info, container, false)

        toolbar!!.setDisplayHomeAsUpEnabled(false)
        setHasOptionsMenu(true)

        return view
    }
}