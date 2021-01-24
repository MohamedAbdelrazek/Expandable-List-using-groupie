package com.example.groupieadapter

import android.view.View
import com.example.groupieadapter.databinding.ItemExpandableHeaderBinding
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.ExpandableItem
import com.xwray.groupie.viewbinding.BindableItem


class ExpandableHeaderItem(private val title: String) : BindableItem<ItemExpandableHeaderBinding>(),
    ExpandableItem {

    private lateinit var expandableGroup: ExpandableGroup

    override fun getLayout() = R.layout.item_expandable_header

    override fun setExpandableGroup(onToggleListener: ExpandableGroup) {
        expandableGroup = onToggleListener
    }

    private fun getRotatedIconResId() =
        if (expandableGroup.isExpanded)
            R.drawable.ic_keyboard_arrow_up_black_24dp
        else
            R.drawable.ic_keyboard_arrow_down_black_24dp

    override fun initializeViewBinding(view: View): ItemExpandableHeaderBinding {
        return ItemExpandableHeaderBinding.bind(view)
    }

    override fun bind(viewBinding: ItemExpandableHeaderBinding, position: Int) {
        viewBinding.itemExpandableHeaderTitle.text = title
        viewBinding.itemExpandableHeaderIcon.setImageResource(getRotatedIconResId())
        viewBinding.itemExpandableHeaderRoot.setOnClickListener {
            expandableGroup.onToggleExpanded()
            viewBinding.itemExpandableHeaderIcon.setImageResource(getRotatedIconResId())
        }
    }


}