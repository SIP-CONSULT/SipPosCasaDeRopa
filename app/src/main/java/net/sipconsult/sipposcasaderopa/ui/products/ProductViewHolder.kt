package net.sipconsult.sipposcasaderopa.ui.products

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_product.view.*
import net.sipconsult.sipposcasaderopa.R
import net.sipconsult.sipposcasaderopa.data.models.ProductItem
import net.sipconsult.sipposcasaderopa.internal.glide.GlideApp

class ProductViewHolder(itemView: View, onProductClick: (ProductItem) -> Unit) :
    RecyclerView.ViewHolder(itemView) {

    private var productPosition: Int = 0
    private lateinit var _product: ProductItem

    fun bind(product: ProductItem, position: Int) {
        productPosition = position
        _product = product
        itemView.textProductName.text = product.name

        itemView.textProductSalesPrice.text = product.displaySalesPrice()


//        GlideApp.with(itemView.context).load(R.drawable.juben_logo).into(itemView.imageProductName)
        GlideApp.with(itemView.context).load(product.image)
            .placeholder(R.drawable.company_logo).into(itemView.imageProductName)
    }

    init {
        itemView.setOnClickListener {
            onProductClick(_product)
        }
    }
}