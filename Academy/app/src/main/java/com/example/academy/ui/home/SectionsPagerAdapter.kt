package com.example.academy.ui.home

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.academy.R
import com.example.academy.ui.academy.AcademyFragment
import com.example.academy.ui.bookmark.BookmarkFragment

class SectionsPagerAdapter(private val mContext: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> AcademyFragment()
            1 -> BookmarkFragment()
            else -> Fragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? = mContext.resources.getString(
        TAB_TITLES[position]
    )

    override fun getCount(): Int = TAB_TITLES.size

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.home, R.string.bookmark)
    }
}