package com.codedix.distantiaui.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import com.codedix.distantiaui.MainActivity
import com.codedix.distantiaui.R
import com.codedix.filterbar.FilterBar


class FmProfile : Fragment() {

    companion object {


        fun newInstance(): FmProfile {
            return FmProfile()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fm_profile, container, false)

        setHasOptionsMenu(true)

        return view
    }
}