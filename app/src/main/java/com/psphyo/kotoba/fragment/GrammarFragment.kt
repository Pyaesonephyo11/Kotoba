package com.psphyo.kotoba.fragment

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.psphyo.kotoba.CoursesItemClickListener
import com.psphyo.kotoba.R
import com.psphyo.kotoba.adapter.GrammarAdapter
import com.psphyo.kotoba.databinding.FragmentGrammarBinding
import com.psphyo.kotoba.model.CourseCard


class GrammarFragment:Fragment(), CoursesItemClickListener {

    lateinit var binding:FragmentGrammarBinding

    private var courseCards: ArrayList<CourseCard>? = null
    private var adapter: GrammarAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentGrammarBinding.inflate(inflater,container,false)
        return binding.root
    }

    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.rvGrammar.layoutManager = layoutManager
        binding.rvGrammar.clipToPadding = false
        binding.rvGrammar.setHasFixedSize(true)
        courseCards = ArrayList()


        courseCards!!.add(CourseCard(1, R.drawable.course_coding, "N5", ""))
        courseCards!!.add(CourseCard(2, R.drawable.course_design_marketing, "N4", ""))
        courseCards!!.add(CourseCard(2, R.drawable.course_thinking, "N3", ""))
        courseCards!!.add(CourseCard(2, R.drawable.course_design_securityexpert, "N2", ""))


        adapter = GrammarAdapter(requireContext(), courseCards!!, this)
        binding.rvGrammar.adapter = adapter
    }

    override fun onDashboardCourseClick(courseCard: CourseCard?, imageView: ImageView?) {
        findNavController().navigate(GrammarFragmentDirections.actionNavGrammarToGrammardetail())
    }

}