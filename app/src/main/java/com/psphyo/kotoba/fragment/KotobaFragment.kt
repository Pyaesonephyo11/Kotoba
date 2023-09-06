package com.psphyo.kotoba.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.AbsListView
import android.widget.SearchView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.psphyo.kotoba.adapter.GoiAdapter
import com.psphyo.kotoba.databinding.FragmentKotobaBinding
import com.psphyo.kotoba.model.GoiData
import java.util.*

class KotobaFragment : Fragment() {


    private lateinit var binding: FragmentKotobaBinding
    private val args: KotobaFragmentArgs by navArgs()

    private lateinit var goiAdapter: GoiAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    var listData:ArrayList<GoiData> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


    // return super.onCreateView(inflater, container, savedInstanceState)
        binding= FragmentKotobaBinding.inflate(inflater,container,false)

        linearLayoutManager=LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerKotoba.layoutManager=linearLayoutManager
        binding.recyclerKotoba.setHasFixedSize(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
       // getSelectData()

        binding.edtSearch.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                performSearch()
               // Toast.makeText(requireContext(), binding.etSearch.text.toString(), Toast.LENGTH_SHORT).show()
                goiAdapter.filter.filter(binding.edtSearch.text.toString())
                return@OnEditorActionListener true
            }
            false
        })

//        binding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
//            androidx.appcompat.widget.SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(p0: String?): Boolean {
//                goiAdapter.filter.filter(p0)
//                return true
//
//            }
//
//            override fun onQueryTextChange(p0: String?): Boolean {
//                goiAdapter.filter.filter(p0)
//                return true
//            }
//
//        })

    }

    private fun getSelectData() {
        binding.progressBar.visibility=View.VISIBLE
        val database=Firebase.database
        val ref=database.getReference("/${args.level}/${args.week}/${args.day}")
        val query=ref.orderByChild("datetime")
        query.addValueEventListener(object :ValueEventListener{
            @SuppressLint("NewApi")
            override fun onDataChange(snapshot: DataSnapshot) {

                try {
                    snapshot.children.forEach {
                        val data=it.getValue<GoiData>()

                    }
                }catch (e:Exception){
                    Log.d("msg","not success$e")
                }

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })

    }

    private fun getData() {
        binding.progressBar.visibility=View.VISIBLE
        val database=Firebase.database
        val ref=database.getReference("/${args.level}/${args.week}/${args.day}")
        val query=ref.orderByChild("mm")
        query.addListenerForSingleValueEvent(object :ValueEventListener{
            @SuppressLint("NewApi")
            override fun onDataChange(snapshot: DataSnapshot) {

                try {
                    snapshot.children.forEach {
                        val data=it.getValue<GoiData>()
                        listData.add(data!!)
                        goiAdapter=GoiAdapter(requireContext(),listData)
                        binding.recyclerKotoba.adapter=goiAdapter

                        binding.progressBar.visibility=View.GONE

                    }
                }catch (e:Exception){
                    Log.d("msg","not success$e")
                }

                }

            override fun onCancelled(error: DatabaseError) {
                
            }

        })

    }
    private fun performSearch() {
        binding.edtSearch.clearFocus()
        val i = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        i.hideSoftInputFromWindow(binding.edtSearch.windowToken, 0)
    }
}