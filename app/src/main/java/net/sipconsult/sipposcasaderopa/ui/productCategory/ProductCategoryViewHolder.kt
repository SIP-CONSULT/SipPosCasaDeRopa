package net.sipconsult.sipposcasaderopa.ui.productCategory

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_product_category.view.*
import net.sipconsult.sipposcasaderopa.R
import net.sipconsult.sipposcasaderopa.data.models.ProductCategoryItem
import net.sipconsult.sipposcasaderopa.internal.glide.GlideApp

class ProductCategoryViewHolder(
    itemView: View,
    onCategoryClick: (ProductCategoryItem) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    private lateinit var category: ProductCategoryItem
    private var pos: Int = 0
    fun bind(category: ProductCategoryItem, position: Int) {
        pos = position
        this.category = category
        itemView.textCategoryName.text = category.name

        GlideApp.with(itemView.context).load(category.image)
            .placeholder(R.drawable.company_logo).into(itemView.imageCategory)
    }

    init {
        itemView.setOnClickListener {
            onCategoryClick(category)
        }
    }
}