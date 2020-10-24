package com.example.academy.ui.bookmark

import androidx.lifecycle.ViewModel
import com.example.academy.data.CourseEntity
import com.example.academy.utils.DataDummy

class BookmarkViewModel : ViewModel() {

    fun getBookmarks(): List<CourseEntity> = DataDummy.generateDummyCourses()
}