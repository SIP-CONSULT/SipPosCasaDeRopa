package net.sipconsult.sipposcasaderopa.ui.productCategory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.sipconsult.sipposcasaderopa.data.repository.productCategory.ProductCategoryRepository

class ProductCategoryViewModelFactory(
    private val productCategoryRepository: ProductCategoryRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductCategoryViewModel(productCategoryRepository) as T
    }
}