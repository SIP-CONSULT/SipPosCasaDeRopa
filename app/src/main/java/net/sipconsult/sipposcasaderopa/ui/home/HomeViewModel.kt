package net.sipconsult.sipposcasaderopa.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import net.sipconsult.sipposcasaderopa.data.models.CartItem
import net.sipconsult.sipposcasaderopa.data.repository.salesAgent.SalesAgentRepository
import net.sipconsult.sipposcasaderopa.data.repository.shoppingCart.ShoppingCartRepository
import net.sipconsult.sipposcasaderopa.internal.lazyDeferred

class HomeViewModel(
    private val salesAgentRepository: SalesAgentRepository
) : ViewModel() {

    val cartItems: LiveData<MutableList<CartItem>> = ShoppingCartRepository.cartItems

    val totalPrice: LiveData<Double> = ShoppingCartRepository.totalPrice


    fun removeCartItem(cartItem: CartItem) {
        ShoppingCartRepository.removeCartItem(cartItem)
    }

    fun increaseCartItemQuantity(cartItem: CartItem) {
        ShoppingCartRepository.increaseCartItemQuantity(cartItem)
    }

    fun decreaseCartItemQuantity(cartItem: CartItem) {
        ShoppingCartRepository.decreaseCartItemQuantity(cartItem)
    }

    fun removeALLCartItem() {
        ShoppingCartRepository.removeALLCartItem()
    }

    val salesAgents by lazyDeferred {
        salesAgentRepository.getSalesAgents()
    }


}