package com.example.academy.ui.reader.list

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.academy.R
import com.example.academy.data.ModuleEntity
import com.example.academy.ui.reader.CourseReaderActivity
import com.example.academy.ui.reader.CourseReaderCallback
import com.example.academy.utils.DataDummy
import kotlinx.android.synthetic.main.fragment_module_list.*


class ModuleListFragment : Fragment(), MyAdapterClickListener {
    private lateinit var adapter: ModuleListAdapter
    private lateinit var courseReaderCallback: CourseReaderCallback

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_module_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = ModuleListAdapter(this)
        populateRecyclerView(DataDummy.generateDummyModules("a14"))
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        courseReaderCallback = context as CourseReaderActivity
    }

    override fun onItemClicked(position: Int, moduleId: String) {
        courseReaderCallback.moveTo(position, moduleId)
    }

    private fun populateRecyclerView(modules: List<ModuleEntity>) {
        progress_bar.visibility = View.GONE
        adapter.setModules(modules)
        with(rv_module) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            this.adapter = this@ModuleListFragment.adapter
        }
        val dividerItemDecoration = DividerItemDecoration(rv_module.context, DividerItemDecoration.VERTICAL)
        rv_module.addItemDecoration(dividerItemDecoration)
    }

    companion object {
        val TAG = ModuleListFragment::class.java.simpleName

        fun newInstance(): ModuleListFragment = ModuleListFragment()
    }
}