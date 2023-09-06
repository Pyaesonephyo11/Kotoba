package com.psphyo.kotoba.fragment

import android.os.Binder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.psphyo.kotoba.R
import com.psphyo.kotoba.databinding.FragmentClasslistBinding

class CLassListFragment :Fragment(), View.OnClickListener {

    private lateinit var binding:FragmentClasslistBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //
    // return super.onCreateView(inflater, container, savedInstanceState)
        binding= FragmentClasslistBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         binding.n2Week1.setOnClickListener {
             findNavController().navigate(CLassListFragmentDirections.actionNavigationClassDataToWeeklist("N2","WeekOne"))
         }
        binding.n2Week2.setOnClickListener(this)
        binding.n2Week3.setOnClickListener(this)
        binding.n2Week4.setOnClickListener(this)
        binding.n2Week5.setOnClickListener(this)
        binding.n2Week6.setOnClickListener(this)
        binding.n2Week7.setOnClickListener(this)
        binding.n2Week8.setOnClickListener(this)

        binding.n3Week1.setOnClickListener(this)
        binding.n3Week2.setOnClickListener(this)
        binding.n3Week3.setOnClickListener(this)
        binding.n3Week4.setOnClickListener(this)
        binding.n3Week5.setOnClickListener(this)
        binding.n3Week6.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.n2_week2->  findNavController().navigate(CLassListFragmentDirections.actionNavigationClassDataToWeeklist("N2","WeekTwo"))
            R.id.n2_week3->  findNavController().navigate(CLassListFragmentDirections.actionNavigationClassDataToWeeklist("N2","WeekThree"))
            R.id.n2_week4->  findNavController().navigate(CLassListFragmentDirections.actionNavigationClassDataToWeeklist("N2","WeekFour"))
            R.id.n2_week5->  findNavController().navigate(CLassListFragmentDirections.actionNavigationClassDataToWeeklist("N2","WeekFive"))
            R.id.n2_week6->  findNavController().navigate(CLassListFragmentDirections.actionNavigationClassDataToWeeklist("N2","WeekSix"))
            R.id.n2_week7->  findNavController().navigate(CLassListFragmentDirections.actionNavigationClassDataToWeeklist("N2","WeekSeven"))
            R.id.n2_week8->  findNavController().navigate(CLassListFragmentDirections.actionNavigationClassDataToWeeklist("N2","WeekEight"))

            R.id.n3_week1->  findNavController().navigate(CLassListFragmentDirections.actionNavigationClassDataToWeeklist("N3","WeekOne"))
            R.id.n3_week2->  findNavController().navigate(CLassListFragmentDirections.actionNavigationClassDataToWeeklist("N3","WeekTwo"))
            R.id.n3_week3->  findNavController().navigate(CLassListFragmentDirections.actionNavigationClassDataToWeeklist("N3","WeekThree"))
            R.id.n3_week4->  findNavController().navigate(CLassListFragmentDirections.actionNavigationClassDataToWeeklist("N3","WeekFour"))
            R.id.n3_week5->  findNavController().navigate(CLassListFragmentDirections.actionNavigationClassDataToWeeklist("N3","WeekFive"))
            R.id.n3_week6->  findNavController().navigate(CLassListFragmentDirections.actionNavigationClassDataToWeeklist("N3","WeekSix"))
        }
    }
}