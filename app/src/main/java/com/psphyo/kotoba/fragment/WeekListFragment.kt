package com.psphyo.kotoba.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.TextView.OnEditorActionListener
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.psphyo.kotoba.CoursesItemClickListener
import com.psphyo.kotoba.R
import com.psphyo.kotoba.adapter.CourseRecyclerAdapter
import com.psphyo.kotoba.databinding.FragmentWeeklistBinding
import com.psphyo.kotoba.model.CourseCard
import java.util.*

class WeekListFragment : Fragment(), CoursesItemClickListener {

    lateinit var binding:FragmentWeeklistBinding

    private var courseCards: ArrayList<CourseCard>? = null
    private var adapter: CourseRecyclerAdapter? = null

    private val args: WeekListFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       //
    // return super.onCreateView(inflater, container, savedInstanceState)
        binding= FragmentWeeklistBinding.inflate(inflater,container,false)
        return binding.root
    }

    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.edtSearch.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
//            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
//                performSearch()
//                Toast.makeText(requireContext(), binding.edtSearch.text.toString(), Toast.LENGTH_SHORT).show()
//                return@OnEditorActionListener true
//            }
//            false
//        })

        binding.tvLevel.text=args.level+"  "+args.week

        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.rvCourses.layoutManager = layoutManager
        binding.rvCourses.clipToPadding = false
        binding.rvCourses.setHasFixedSize(true)
        courseCards = ArrayList()

        courseCards!!.add(CourseCard(1, R.drawable.course_coding, "DayOne", "19 meanings"))
        courseCards!!.add(CourseCard(2, R.drawable.course_design_marketing, "DayTwo", "14 meanings"))
        courseCards!!.add(CourseCard(3, R.drawable.course_design_securityexpert, "DayThree", "24 meanings"))
        courseCards!!.add(CourseCard(4, R.drawable.course_design_whatisthisshit, "DayFour", "18 meanings"))
        courseCards!!.add(CourseCard(5, R.drawable.education_1, "DayFive", "21 meanings"))
        courseCards!!.add(CourseCard(6, R.drawable.course_thinking, "DaySix", "10 meanings"))

        adapter = CourseRecyclerAdapter(requireContext(), courseCards!!, this)

        binding.rvCourses.adapter = adapter
    }
//    private fun performSearch() {
//        binding.edtSearch.clearFocus()
//        val i = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        i.hideSoftInputFromWindow(binding.edtSearch.windowToken, 0)
//    }

    override fun onDashboardCourseClick(courseCard: CourseCard?, imageView: ImageView?) {
      //  Toast.makeText(requireContext(), courseCard!!.title, Toast.LENGTH_LONG).show()
        findNavController().navigate(WeekListFragmentDirections.actionNavigationClassDayToKotoba(args.level,args.week,courseCard!!.title))

    }
}