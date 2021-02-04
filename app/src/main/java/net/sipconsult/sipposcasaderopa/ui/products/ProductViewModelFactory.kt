package net.sipconsult.sipposcasaderopa.ui.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.sipconsult.sipposcasaderopa.data.repository.location.LocationRepository
import net.sipconsult.sipposcasaderopa.data.repository.product.ProductRepository

class ProductViewModelFactory(
    private val productRepository: ProductRepository,
    private val locationRepository: LocationRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductsViewModel(productRepository, locationRepository) as T
    }
}