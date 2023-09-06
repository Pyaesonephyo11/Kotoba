package com.psphyo.kotoba.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.psphyo.kotoba.CoursesItemClickListener
import com.psphyo.kotoba.databinding.ItemCardBinding
import com.psphyo.kotoba.fragment.WeekListFragment
import com.psphyo.kotoba.model.CourseCard

class CourseRecyclerAdapter(
    var mContext: Context,
    mData: List<CourseCard>,
    listener: WeekListFragment
) :
    RecyclerView.Adapter<CourseRecyclerAdapter._ViewHolder>() {
    private val mData: List<CourseCard>
    private val coursesItemClickListener: CoursesItemClickListener
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): _ViewHolder {
//        View view = LayoutInflater.from(mContext).inflate(R.layout.item_card,viewGroup,false);
//        return new _ViewHolder(view);
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        val itemCardBinding: ItemCardBinding =
            ItemCardBinding.inflate(layoutInflater, viewGroup, false)
        return _ViewHolder(itemCardBinding)
    }

    override fun onBindViewHolder(viewHolder: _ViewHolder, i: Int) {
//        viewHolder.mItem = mData.get(i);
        val pos = viewHolder.adapterPosition
        //Set ViewTag
        viewHolder.itemView.tag = pos
        viewHolder.setPostImage(mData[i])

//        viewHolder.itemCardBinding.stagItemCourse.setText(mData.get(i).getCourseTitle());
//        viewHolder.itemCardBinding.stagItemQuantityCourse.setText(mData.get(i).getQuantityCourses());

        //1st intent 2 methods
//        if (i%2==1){
//            ViewGroup.MarginLayoutParams cardViewMarginParams = (ViewGroup.MarginLayoutParams) viewHolder.card_item.getLayoutParams();
//            cardViewMarginParams.setMargins(dpToPx(8), dpToPx(16), 0, 0);
//            viewHolder.card_item.requestLayout();
//        }
//        if (i==1){
//            ViewGroup.MarginLayoutParams cardViewMarginParams = (ViewGroup.MarginLayoutParams) viewHolder.card_item.getLayoutParams();
//            cardViewMarginParams.setMargins(dpToPx(8), dpToPx(32), 0, 0);
//            viewHolder.card_item.requestLayout();
//        }

        //2nd intent card only bottom margin in xml  and only top margin in adapter- it works

//        if (i%2==1){
//
//            int dimenTopPixeles = getDimensionValuePixels(R.dimen.staggedmarginbottom);
//            int dimenleftPixeles = getDimensionValuePixels(R.dimen.horizontal_card);
//            ViewGroup.MarginLayoutParams cardViewMarginParams = (ViewGroup.MarginLayoutParams) viewHolder.itemCardBinding.cardItem.getLayoutParams();
//            cardViewMarginParams.setMargins(dimenleftPixeles, dimenTopPixeles, 0, 0);
//            viewHolder.itemCardBinding.cardItem.requestLayout();
//        }

//      viewHolder.card_item.setBackgroundColor(mContext.getResources().getColor(R.color.color1));
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
        //        ImageView imageView;
        //        TextView course;
        //        TextView quantity_courses;
        //        CardView card_item;
        //        public CourseCard mItem;
        //        public _ViewHolder(@NonNull View itemView) {
        //            super(itemView);
        //            card_item = itemView.findViewById(R.id.card_item);
        //            imageView = itemView.findViewById(R.id.card_view_image);
        //            course = itemView.findViewById(R.id.stag_item_course);
        //            quantity_courses = itemView.findViewById(R.id.stag_item_quantity_course);
        //        }
        var itemCardBinding: ItemCardBinding
        fun setPostImage(courseCard: CourseCard) {
            itemCardBinding.cardViewImage.setImageResource(courseCard.image)
            itemCardBinding.stagItemCourse.setText(courseCard.title)
            itemCardBinding.stagItemQuantityCourse.setText(courseCard.qty)
        }

        init {
            itemCardBinding = cardBinding

            //this.itemRecyclerMealBinding.
        }
    }

    init {
        this.mData = mData
        coursesItemClickListener = listener
    }
}