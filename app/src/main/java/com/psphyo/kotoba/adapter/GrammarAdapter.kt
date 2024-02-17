package com.psphyo.kotoba.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.psphyo.kotoba.CoursesItemClickListener
import com.psphyo.kotoba.databinding.ItemCardBinding
import com.psphyo.kotoba.fragment.GrammarFragment
import com.psphyo.kotoba.model.CourseCard

class GrammarAdapter(
    var mContext: Context,
    mData: List<CourseCard>,
    listener: GrammarFragment
) :
    RecyclerView.Adapter<GrammarAdapter._ViewHolder>() {
    private val mData: List<CourseCard>
    private val coursesItemClickListener: CoursesItemClickListener
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): _ViewHolder {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        val itemCardBinding: ItemCardBinding =
            ItemCardBinding.inflate(layoutInflater, viewGroup, false)
        return _ViewHolder(itemCardBinding)
    }

    override fun onBindViewHolder(viewHolder: _ViewHolder, i: Int) {
        val pos = viewHolder.adapterPosition
        //Set ViewTag
        viewHolder.itemView.tag = pos
        viewHolder.setPostImage(mData[i])
        viewHolder.itemView.setOnClickListener {
            coursesItemClickListener.onDashboardCourseClick(
                mData[i],
                viewHolder.itemCardBinding.cardViewImage
            )
        }
    }

    fun getDimensionValuePixels(dimension: Int): Int {
        return mContext.resources.getDimension(dimension).toInt()
    }

    fun dpToPx(dp: Int): Int {
        val scale = mContext.resources.displayMetrics.density
        return (dp * scale + 0.5f).toInt()
    }

    override fun getItemId(position: Int): Long {
        val courseCard: CourseCard = mData[position]
        return courseCard.id.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class _ViewHolder(cardBinding: ItemCardBinding) :
        RecyclerView.ViewHolder(cardBinding.getRoot()) {
        var itemCardBinding: ItemCardBinding
        fun setPostImage(courseCard: CourseCard) {
            itemCardBinding.cardViewImage.setImageResource(courseCard.image)
            itemCardBinding.stagItemCourse.setText(courseCard.title)
            itemCardBinding.stagItemQuantityCourse.setText(courseCard.qty)
        }

        init {
            itemCardBinding = cardBinding
        }
    }

    init {
        this.mData = mData
        coursesItemClickListener = listener
    }
}