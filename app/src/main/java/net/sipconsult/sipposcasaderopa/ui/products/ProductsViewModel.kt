package net.sipconsult.sipposcasaderopa.ui.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import net.sipconsult.sipposcasaderopa.data.models.CartItem
import net.sipconsult.sipposcasaderopa.data.models.ProductItem
import net.sipconsult.sipposcasaderopa.data.repository.location.LocationRepository
import net.sipconsult.sipposcasaderopa.data.repository.product.ProductRepository
import net.sipconsult.sipposcasaderopa.data.repository.shoppingCart.ShoppingCartRepository
import net.sipconsult.sipposcasaderopa.internal.lazyDeferred

class ProductsViewModel(
    private val productRepository: ProductRepository,
    private val locationRepository: LocationRepository
) : ViewModel() {

    var categoryId: Int = 0

    var productItems: List<ProductItem> = arrayListOf()
    var localproducts: LiveData<List<ProductItem>> = productRepository.getProductsLocal()

    fun addCartItem(product: ProductItem) {
        val cartItem = CartItem(product)
        cartItem.let { ShoppingCartRepository.addCartItem(it) }
    }

    fun addScannedCartItem(barcode: String) {
        val pdt = productItems.find { p -> p.barcode == barcode }
        val cartItem = pdt?.let { CartItem(it) }
        cartItem.let { it?.let { it1 -> ShoppingCartRepository.addCartItem(it1) } }
    }

    val products by lazyDeferred {
        productRepository.getProducts()
    }

    val productCategory by lazyDeferred {
        productRepository.getProductsCategory(categoryId)
    }

    val locations by lazyDeferred {
        locationRepository.getLocations()
    }

}
