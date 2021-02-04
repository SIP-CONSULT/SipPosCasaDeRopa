package net.sipconsult.sipposcasaderopa.data.repository.order

import net.sipconsult.sipposcasaderopa.data.models.OrderPostBody
import net.sipconsult.sipposcasaderopa.data.models.SalesTransactionsItem
import net.sipconsult.sipposcasaderopa.data.network.response.TransactionResponse
import net.sipconsult.sipposcasaderopa.internal.Result

interface OrderRepository {

    suspend fun postOrder(body: OrderPostBody): Result<TransactionResponse>

    suspend fun fetchOrders(): Result<SalesTransactionsItem>

    suspend fun fetchOrder(orderId: Int): Result<SalesTransactionsItem>
}