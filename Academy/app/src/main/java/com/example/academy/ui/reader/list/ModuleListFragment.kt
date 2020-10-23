package com.example.academy.ui.reader.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.academy.R

/**
 * A simple [Fragment] subclass.
 * Use the [ModuleListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ModuleListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_module_list, container, false)
    }
}