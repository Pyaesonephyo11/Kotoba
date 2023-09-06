package com.psphyo.kotoba

import android.widget.ImageView
import com.psphyo.kotoba.model.CourseCard

interface CoursesItemClickListener {
    fun onDashboardCourseClick(
        courseCard: CourseCard?,
        imageView: ImageView?
    ) // Shoud use imageview to make the shared animation between the two activity
}