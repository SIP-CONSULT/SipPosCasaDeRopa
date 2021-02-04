package net.sipconsult.sipposcasaderopa.ui.productCategory

import androidx.lifecycle.ViewModel
import net.sipconsult.sipposcasaderopa.data.repository.productCategory.ProductCategoryRepository
import net.sipconsult.sipposcasaderopa.internal.lazyDeferred

class ProductCategoryViewModel(
    private val productCategoryRepository: ProductCategoryRepository
) : ViewModel() {

    val categories by lazyDeferred {
        productCategoryRepository.getCategories()
    }
}
