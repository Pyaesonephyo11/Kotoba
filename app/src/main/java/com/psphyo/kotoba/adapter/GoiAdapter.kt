package com.psphyo.kotoba.adapter

import android.content.Context
import android.speech.tts.TextToSpeech
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.google.android.gms.common.util.CollectionUtils.listOf
import com.psphyo.kotoba.R
import com.psphyo.kotoba.model.GoiData
import java.util.*


class GoiAdapter(val context: Context, val goiData:ArrayList<GoiData>):RecyclerView.Adapter<GoiAdapter.ViewHolder>(),Filterable {


    lateinit var t1:TextToSpeech

    class ViewHolder(item: View):RecyclerView.ViewHolder(item)

    private lateinit var orgGoiData:ArrayList<GoiData>
    private lateinit var goialldata:ArrayList<GoiData>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoiAdapter.ViewHolder {
     return ViewHolder(LayoutInflater.from(context).inflate(R.layout.kotoba_item,parent,false))
    }

    override fun onBindViewHolder(holder: GoiAdapter.ViewHolder, position: Int) {

        orgGoiData= goiData
        goialldata=goiData
        var jp=holder.itemView.findViewById<TextView>(R.id.jp)
        var en=holder.itemView.findViewById<TextView>(R.id.en)
        var mm=holder.itemView.findViewById<TextView>(R.id.mm)

       // var imgsound=holder.itemView.findViewById<ImageView>(R.id.img_speaker)
        var imgshow=holder.itemView.findViewById<ImageView>(R.id.img_show)
        var imghide=holder.itemView.findViewById<ImageView>(R.id.img_hide)

        jp.text=goiData[position].jp
        en.text=goiData[position].en
        mm.text=goiData[position].mm
        t1 = TextToSpeech(
            context.getApplicationContext()
        ) { status ->
            if (status != TextToSpeech.ERROR) {
                t1.language = Locale.JAPAN
            }
        }

//        imgsound.setOnClickListener {
//            val jpn=en.text
//            t1.speak(jpn.toString(),TextToSpeech.QUEUE_FLUSH,null)
//        }

        imgshow.setOnClickListener {
            en.visibility=View.VISIBLE
            imghide.visibility=View.VISIBLE
            imgshow.visibility=View.GONE
        }

        imghide.setOnClickListener {
            en.visibility= View.GONE
            imgshow.visibility= View.VISIBLE
            imghide.visibility= View.GONE
        }

    }

    override fun getItemCount(): Int {
       return goiData.size
    }

    override fun getFilter(): Filter {
       return dataFilter
    }

    private val dataFilter: Filter = object : Filter() {
        override fun performFiltering(charSequence: CharSequence): FilterResults {
            val filterGoi: MutableList<GoiData> = ArrayList<GoiData>()

            val query=charSequence.toString().lowercase()

            if (query.isEmpty()) {
                filterGoi.addAll(orgGoiData)

            } else {
                for (record in orgGoiData) {
                    if (record.mm!!.toString().lowercase().contains(query) ||record.jp!!.toString().lowercase().contains(query)||record.en!!.toString().lowercase().contains(query)) {
                        filterGoi.add(record)
                    }
                }
            }

            val results = FilterResults()
            results.values = filterGoi
            return results
        }

        override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
            goiData.clear()
            goiData.addAll(filterResults.values as List<GoiData>)
            notifyDataSetChanged()
        }
    }

}

