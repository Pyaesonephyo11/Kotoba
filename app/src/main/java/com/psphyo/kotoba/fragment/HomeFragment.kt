package com.psphyo.kotoba.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.psphyo.kotoba.databinding.FragmentHomeBinding
import com.psphyo.kotoba.model.GoiData

class HomeFragment : Fragment(), View.OnClickListener {
    private lateinit var binding:FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       // return super.onCreateView(inflater, container, savedInstanceState)
        binding= FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnupload.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        uploadData()
    }

    private fun uploadData() {

        val database = Firebase.database
        val level=binding.etlevel.text.toString()
        val week=binding.etweek.text.toString()
        val day=binding.etday.text.toString()
        val jp=binding.etjp.text.toString()
        val en=binding.eten.text.toString()
        val mm=binding.etmm.text.toString()

            val goiData= GoiData(level,week,day,jp,en,mm)
            val myRef = database.getReference("/$level/$week/$day/$jp")
            myRef.setValue(goiData).addOnSuccessListener {
                Toast.makeText(context,"upload successful", Toast.LENGTH_SHORT).show()
            }
        }



}