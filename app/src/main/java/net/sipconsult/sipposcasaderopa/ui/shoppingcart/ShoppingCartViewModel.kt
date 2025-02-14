package net.sipconsult.sipposcasaderopa.ui.shoppingcart

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import net.sipconsult.sipposcasaderopa.data.models.CartItem
import net.sipconsult.sipposcasaderopa.data.repository.shoppingCart.ShoppingCartRepository

class ShoppingCartViewModel : ViewModel() {

    val cartItems: LiveData<MutableList<CartItem>> = ShoppingCartRepository.cartItems

    val totalPrice: LiveData<Double> = ShoppingCartRepository.totalPrice

    fun isCartEmpty(): Boolean {
         return cartItems.value.isNullOrEmpty()
    }

    fun removeCartItem(cartItemPos: CartItem) {
        ShoppingCartRepository.removeCartItem(cartItemPos)
    }

    fun increaseCartItemQuantity(itemPosition: CartItem) {
        ShoppingCartRepository.increaseCartItemQuantity(itemPosition)
    }

    fun decreaseCartItemQuantity(itemPosition: CartItem) {
        ShoppingCartRepository.decreaseCartItemQuantity(itemPosition)
    }

    fun removeALLCartItem() {
        ShoppingCartRepository.removeALLCartItem()
    }
}