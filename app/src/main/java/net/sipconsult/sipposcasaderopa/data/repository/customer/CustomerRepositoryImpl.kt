package net.sipconsult.sipposcasaderopa.data.repository.customer

import androidx.lifecycle.LiveData
import net.sipconsult.sipposcasaderopa.data.models.CustomerItem

class CustomerRepositoryImpl : CustomerRepository {
    override suspend fun getCustomer(): LiveData<List<CustomerItem>> {
        TODO("Not yet implemented")
    }

    override fun getCustomer(customerCode: String): CustomerItem {
        TODO("Not yet implemented")
    }

    override fun getCustomerLocal(): LiveData<List<CustomerItem>> {
        TODO("Not yet implemented")
    }
}