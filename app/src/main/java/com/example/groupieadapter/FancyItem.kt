package com.example.groupieadapter
import android.view.View
import androidx.annotation.ColorInt
import com.example.groupieadapter.R
import com.example.groupieadapter.databinding.ItemFancyBinding
import com.xwray.groupie.viewbinding.BindableItem


class FancyItem(
    @ColorInt private val color: Int,
    private val number: Int
) : BindableItem<ItemFancyBinding>() {


    override fun getLayout() = R.layout.item_fancy

    override fun getSpanSize(spanCount: Int, position: Int) = spanCount / 2

    override fun initializeViewBinding(view: View): ItemFancyBinding {
        return ItemFancyBinding.bind(view)
    }

    override fun bind(viewBinding: ItemFancyBinding, position: Int) {
        viewBinding.itemFancyNumber.text = number.toString()
        viewBinding.itemFancyCardView.setBackgroundColor(color)

    }
}