package net.sipconsult.sipposcasaderopa.ui.productCategory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.category_fragment.*
import kotlinx.android.synthetic.main.products_fragment.*
import kotlinx.coroutines.launch
import net.sipconsult.sipposcasaderopa.R
import net.sipconsult.sipposcasaderopa.data.models.ProductCategoryItem
import net.sipconsult.sipposcasaderopa.ui.base.ScopedFragment
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance
import java.util.*

class ProductCategoryFragment : ScopedFragment(), KodeinAware {

    override val kodein by closestKodein()
    private val viewModelFactoryProduct: ProductCategoryViewModelFactory by instance()

    private lateinit var viewModel: ProductCategoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.category_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            viewModelFactoryProduct
        ).get(ProductCategoryViewModel::class.java)

        buildUI()

    }

    private fun buildUI() = launch {
        val categories = viewModel.categories.await()
        if (view != null) {
            categories.observe(viewLifecycleOwner, Observer { categories ->
                if (categories == null) return@Observer
                setupProductRecyclerView(categories as ArrayList<ProductCategoryItem>)
            })
        }
    }

    private fun setupProductRecyclerView(categories: ArrayList<ProductCategoryItem>) {
        val productRecyclerAdapter =
            ProductCategoryListAdapter(::onCategoryClick)
        listProductCategory.adapter = productRecyclerAdapter
        productRecyclerAdapter.setCategories(categories)
    }

    private fun onCategoryClick(category: ProductCategoryItem) {
        val action =
            ProductCategoryFragmentDirections.actionCategoryFragmentToProductsFragment(categoryId = category.id)
        findNavController().navigate(action)
    }


}
