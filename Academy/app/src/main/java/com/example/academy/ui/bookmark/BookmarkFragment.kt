package com.example.academy.ui.bookmark

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.academy.R
import com.example.academy.data.CourseEntity
import com.example.academy.utils.DataDummy
import kotlinx.android.synthetic.main.fragment_bookmark.*

class BookmarkFragment : Fragment(), BookmarkFragmentCallback {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bookmark, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null){
            val courses = DataDummy.generateDummyCourses()
            val adapter = BookmarkAdapter(this)
            adapter.setCourses(courses)

            with(rv_bookmark) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = adapter
            }

        }
    }

    override fun onShareClick(course: CourseEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            activity?.let {
                ShareCompat.IntentBuilder.from(it).apply {
                    setType(mimeType)
                    setChooserTitle("Bagikan aplikasi ini sekaran.")
                    setText(resources.getString(R.string.share_text, course.title))
                    startChooser()
                }
            }
        }
    }
}