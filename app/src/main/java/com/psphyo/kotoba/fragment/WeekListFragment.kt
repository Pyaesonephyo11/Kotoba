package com.psphyo.kotoba.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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



        binding.tvLevel.text=args.level+"  "+args.week

        var layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.rvCourses.layoutManager = layoutManager
        binding.rvCourses.clipToPadding = false
        binding.rvCourses.setHasFixedSize(true)
        courseCards = ArrayList()

        if (args.level.equals("N5")){
            courseCards!!.add(CourseCard(1, R.drawable.course_coding, "Unit 1", "19 meanings"))
            courseCards!!.add(CourseCard(2, R.drawable.course_design_marketing, "Unit 2", "14 meanings"))
            courseCards!!.add(CourseCard(3, R.drawable.course_design_securityexpert, "Unit 3", "24 meanings"))
            courseCards!!.add(CourseCard(4, R.drawable.course_design_whatisthisshit, "Unit 4", "18 meanings"))
            courseCards!!.add(CourseCard(5, R.drawable.education_1, "Unit 5", "21 meanings"))
            courseCards!!.add(CourseCard(6, R.drawable.course_thinking, "Unit 6", "10 meanings"))
            courseCards!!.add(CourseCard(1, R.drawable.course_coding, "Unit 7", "19 meanings"))
            courseCards!!.add(CourseCard(2, R.drawable.course_design_marketing, "Unit 8", "14 meanings"))
            courseCards!!.add(CourseCard(3, R.drawable.course_design_securityexpert, "Unit 9", "24 meanings"))
            courseCards!!.add(CourseCard(4, R.drawable.course_design_whatisthisshit, "Unit 10", "18 meanings"))
            courseCards!!.add(CourseCard(5, R.drawable.education_1, "Unit 11", "21 meanings"))
            courseCards!!.add(CourseCard(6, R.drawable.course_thinking, "Unit 12", "10 meanings"))
            courseCards!!.add(CourseCard(1, R.drawable.course_coding, "Unit 13", "19 meanings"))
            courseCards!!.add(CourseCard(2, R.drawable.course_design_marketing, "Unit 14", "14 meanings"))
            courseCards!!.add(CourseCard(3, R.drawable.course_design_securityexpert, "Unit 15", "24 meanings"))
            courseCards!!.add(CourseCard(4, R.drawable.course_design_whatisthisshit, "Unit 16", "18 meanings"))
            courseCards!!.add(CourseCard(5, R.drawable.education_1, "Unit 17", "21 meanings"))
            courseCards!!.add(CourseCard(6, R.drawable.course_thinking, "Unit 18", "10 meanings"))
            courseCards!!.add(CourseCard(1, R.drawable.course_coding, "Unit 19", "19 meanings"))
            courseCards!!.add(CourseCard(2, R.drawable.course_design_marketing, "Unit 20", "14 meanings"))
            courseCards!!.add(CourseCard(3, R.drawable.course_design_securityexpert, "Unit 21", "24 meanings"))
            courseCards!!.add(CourseCard(4, R.drawable.course_design_whatisthisshit, "Unit 22", "18 meanings"))
            courseCards!!.add(CourseCard(5, R.drawable.education_1, "Unit 23", "21 meanings"))
            courseCards!!.add(CourseCard(6, R.drawable.course_thinking, "Unit 24", "10 meanings"))
            courseCards!!.add(CourseCard(1, R.drawable.course_coding, "Unit 25", "19 meanings"))

        }else if (args.level.equals("N4")){
            courseCards!!.add(CourseCard(1, R.drawable.course_coding, "Unit 26", "19 meanings"))
            courseCards!!.add(CourseCard(2, R.drawable.course_design_marketing, "Unit 27", "14 meanings"))
            courseCards!!.add(CourseCard(3, R.drawable.course_design_securityexpert, "Unit 28", "24 meanings"))
            courseCards!!.add(CourseCard(4, R.drawable.course_design_whatisthisshit, "Unit 29", "18 meanings"))
            courseCards!!.add(CourseCard(5, R.drawable.education_1, "Unit 30", "21 meanings"))
            courseCards!!.add(CourseCard(6, R.drawable.course_thinking, "Unit 31", "10 meanings"))
            courseCards!!.add(CourseCard(1, R.drawable.course_coding, "Unit 32", "19 meanings"))
            courseCards!!.add(CourseCard(2, R.drawable.course_design_marketing, "Unit 33", "14 meanings"))
            courseCards!!.add(CourseCard(3, R.drawable.course_design_securityexpert, "Unit 34", "24 meanings"))
            courseCards!!.add(CourseCard(4, R.drawable.course_design_whatisthisshit, "Unit 35", "18 meanings"))
            courseCards!!.add(CourseCard(5, R.drawable.education_1, "Unit 36", "21 meanings"))
            courseCards!!.add(CourseCard(6, R.drawable.course_thinking, "Unit 37", "10 meanings"))
            courseCards!!.add(CourseCard(1, R.drawable.course_coding, "Unit 38", "19 meanings"))
            courseCards!!.add(CourseCard(2, R.drawable.course_design_marketing, "Unit 39", "14 meanings"))
            courseCards!!.add(CourseCard(3, R.drawable.course_design_securityexpert, "Unit 40", "24 meanings"))
            courseCards!!.add(CourseCard(4, R.drawable.course_design_whatisthisshit, "Unit 41", "18 meanings"))
            courseCards!!.add(CourseCard(5, R.drawable.education_1, "Unit 42", "21 meanings"))
            courseCards!!.add(CourseCard(6, R.drawable.course_thinking, "Unit 43", "10 meanings"))
            courseCards!!.add(CourseCard(1, R.drawable.course_coding, "Unit 44", "19 meanings"))
            courseCards!!.add(CourseCard(2, R.drawable.course_design_marketing, "Unit 45", "14 meanings"))
            courseCards!!.add(CourseCard(3, R.drawable.course_design_securityexpert, "Unit 46", "24 meanings"))
            courseCards!!.add(CourseCard(4, R.drawable.course_design_whatisthisshit, "Unit 47", "18 meanings"))
            courseCards!!.add(CourseCard(5, R.drawable.education_1, "Unit 48", "21 meanings"))
            courseCards!!.add(CourseCard(6, R.drawable.course_thinking, "Unit 49", "10 meanings"))
            courseCards!!.add(CourseCard(1, R.drawable.course_coding, "Unit 50", "19 meanings"))
        }

        else{

            if (args.level.equals("N3")){
                courseCards!!.add(CourseCard(1, R.drawable.course_coding, "DayOne", "19 meanings"))
                courseCards!!.add(CourseCard(2, R.drawable.course_design_marketing, "DayTwo", "14 meanings"))
                courseCards!!.add(CourseCard(3, R.drawable.course_design_securityexpert, "DayThree", "24 meanings"))
                courseCards!!.add(CourseCard(4, R.drawable.course_design_whatisthisshit, "DayFour", "18 meanings"))
                courseCards!!.add(CourseCard(5, R.drawable.education_1, "DayFive", "21 meanings"))
                courseCards!!.add(CourseCard(6, R.drawable.course_thinking, "DaySix", "10 meanings"))
            }else if(args.level.equals("N2")){
                courseCards!!.add(CourseCard(1, R.drawable.course_coding, "DayOne", "19 meanings"))
                courseCards!!.add(CourseCard(2, R.drawable.course_design_marketing, "DayTwo", "14 meanings"))
                courseCards!!.add(CourseCard(3, R.drawable.course_design_securityexpert, "DayThree", "24 meanings"))
                courseCards!!.add(CourseCard(4, R.drawable.course_design_whatisthisshit, "DayFour", "18 meanings"))
                courseCards!!.add(CourseCard(5, R.drawable.education_1, "DayFive", "21 meanings"))
                courseCards!!.add(CourseCard(6, R.drawable.course_thinking, "DaySix", "10 meanings"))
                courseCards!!.add(CourseCard(6, R.drawable.course_design_whatisthisshit, "DaySeven", "10 meanings"))
                courseCards!!.add(CourseCard(6, R.drawable.course_coding, "DayEight", "10 meanings"))
            }


        }
        adapter = CourseRecyclerAdapter(requireContext(), courseCards!!, this)

        binding.rvCourses.adapter = adapter

    }


    override fun onDashboardCourseClick(courseCard: CourseCard?, imageView: ImageView?) {
      //  Toast.makeText(requireContext(), courseCard!!.title, Toast.LENGTH_LONG).show()
        findNavController().navigate(WeekListFragmentDirections.actionNavigationClassDayToKotoba(args.level,args.week,courseCard!!.title))

    }

}