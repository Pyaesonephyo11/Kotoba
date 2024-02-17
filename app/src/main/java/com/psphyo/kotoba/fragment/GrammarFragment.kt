package com.psphyo.kotoba.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.psphyo.kotoba.databinding.FragmentGrammarBinding

class GrammarFragment:Fragment() {

    lateinit var binding:FragmentGrammarBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentGrammarBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(context,"Welcome Grammar Fragment",Toast.LENGTH_SHORT).show()
    }
}