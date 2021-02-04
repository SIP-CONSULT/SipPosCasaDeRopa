package net.sipconsult.sipposcasaderopa.ui.productCategory

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.sipconsult.sipposcasaderopa.R
import net.sipconsult.sipposcasaderopa.data.models.ProductCategoryItem

class ProductCategoryListAdapter(private val onCategoryClick: (ProductCategoryItem) -> Unit) :
    RecyclerView.Adapter<ProductCategoryViewHolder>() {

    private var _categories: List<ProductCategoryItem> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
//        val binding =
//            CategoryListItemBinding.inflate(
//                layoutInflater,
//                parent,
//                false,
//                R.layout.list_item_product_category
//            )
        val itemView = layoutInflater.inflate(R.layout.list_item_product_category, parent, false)

        return ProductCategoryViewHolder(itemView, onCategoryClick)
    }

    override fun getItemCount(): Int = _categories.size

    override fun onBindViewHolder(holderProduct: ProductCategoryViewHolder, position: Int) {
        val category = _categories[position]

        holderProduct.bind(category, position)
    }

    fun setCategories(categories: List<ProductCategoryItem>) {
        _categories = categories
        notifyDataSetChanged()
    }
}