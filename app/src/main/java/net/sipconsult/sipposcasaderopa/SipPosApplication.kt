package net.sipconsult.sipposcasaderopa

import android.app.Application
import android.widget.Toast
import com.jakewharton.threetenabp.AndroidThreeTen
import net.sipconsult.sipposcasaderopa.data.datasource.discountTypes.local.DiscountTypesLocalDataSource
import net.sipconsult.sipposcasaderopa.data.datasource.discountTypes.local.DiscountTypesLocalDataSourceImpl
import net.sipconsult.sipposcasaderopa.data.datasource.discountTypes.network.DiscountTypesNetworkDataSource
import net.sipconsult.sipposcasaderopa.data.datasource.discountTypes.network.DiscountTypesNetworkDataSourceImpl
import net.sipconsult.sipposcasaderopa.data.datasource.location.local.LocationLocalDataSource
import net.sipconsult.sipposcasaderopa.data.datasource.location.local.LocationLocalDataSourceImpl
import net.sipconsult.sipposcasaderopa.data.datasource.location.network.LocationNetworkDataSource
import net.sipconsult.sipposcasaderopa.data.datasource.location.network.LocationNetworkDataSourceImpl
import net.sipconsult.sipposcasaderopa.data.datasource.paymentMethod.local.PaymentMethodLocalDataSource
import net.sipconsult.sipposcasaderopa.data.datasource.paymentMethod.local.PaymentMethodLocalDataSourceImpl
import net.sipconsult.sipposcasaderopa.data.datasource.paymentMethod.network.PaymentMethodNetworkDataSource
import net.sipconsult.sipposcasaderopa.data.datasource.paymentMethod.network.PaymentMethodNetworkDataSourceImpl
import net.sipconsult.sipposcasaderopa.data.datasource.product.local.ProductLocalDataSource
import net.sipconsult.sipposcasaderopa.data.datasource.product.local.ProductLocalDataSourceImpl
import net.sipconsult.sipposcasaderopa.data.datasource.product.network.ProductNetworkDataSource
import net.sipconsult.sipposcasaderopa.data.datasource.product.network.ProductNetworkDataSourceImpl
import net.sipconsult.sipposcasaderopa.data.datasource.productCategory.local.ProductCategoryLocalDataSource
import net.sipconsult.sipposcasaderopa.data.datasource.productCategory.local.ProductCategoryLocalDataSourceImpl
import net.sipconsult.sipposcasaderopa.data.datasource.productCategory.network.ProductCategoryNetworkDataSource
import net.sipconsult.sipposcasaderopa.data.datasource.productCategory.network.ProductCategoryNetworkDataSourceImpl
import net.sipconsult.sipposcasaderopa.data.datasource.salesAgent.local.SalesAgentLocalDataSource
import net.sipconsult.sipposcasaderopa.data.datasource.salesAgent.local.SalesAgentLocalDataSourceImpl
import net.sipconsult.sipposcasaderopa.data.datasource.salesAgent.network.SalesAgentNetworkDataSource
import net.sipconsult.sipposcasaderopa.data.datasource.salesAgent.network.SalesAgentNetworkDataSourceImpl
import net.sipconsult.sipposcasaderopa.data.datasource.transaction.local.TransactionLocalDataSource
import net.sipconsult.sipposcasaderopa.data.datasource.transaction.local.TransactionLocalDataSourceImpl
import net.sipconsult.sipposcasaderopa.data.datasource.transaction.network.TransactionNetworkDataSource
import net.sipconsult.sipposcasaderopa.data.datasource.transaction.network.TransactionNetworkDataSourceImpl
import net.sipconsult.sipposcasaderopa.data.datasource.user.UserDataSource
import net.sipconsult.sipposcasaderopa.data.datasource.user.UserDataSourceImpl
import net.sipconsult.sipposcasaderopa.data.db.ApplicationDatabase
import net.sipconsult.sipposcasaderopa.data.network.ConnectivityInterceptor
import net.sipconsult.sipposcasaderopa.data.network.ConnectivityInterceptorImpl
import net.sipconsult.sipposcasaderopa.data.network.SipShopApiService
import net.sipconsult.sipposcasaderopa.data.provider.LocationProvider
import net.sipconsult.sipposcasaderopa.data.provider.LocationProviderImpl
import net.sipconsult.sipposcasaderopa.data.provider.PosNumberProvider
import net.sipconsult.sipposcasaderopa.data.provider.PosNumberProviderImpl
import net.sipconsult.sipposcasaderopa.data.repository.discountType.DiscountTypeRepository
import net.sipconsult.sipposcasaderopa.data.repository.discountType.DiscountTypeRepositoryImpl
import net.sipconsult.sipposcasaderopa.data.repository.location.LocationRepository
import net.sipconsult.sipposcasaderopa.data.repository.location.LocationRepositoryImpl
import net.sipconsult.sipposcasaderopa.data.repository.paymentMethod.PaymentMethodRepository
import net.sipconsult.sipposcasaderopa.data.repository.paymentMethod.PaymentMethodRepositoryImpl
import net.sipconsult.sipposcasaderopa.data.repository.product.ProductRepository
import net.sipconsult.sipposcasaderopa.data.repository.product.ProductRepositoryImpl
import net.sipconsult.sipposcasaderopa.data.repository.productCategory.ProductCategoryRepository
import net.sipconsult.sipposcasaderopa.data.repository.productCategory.ProductCategoryRepositoryImpl
import net.sipconsult.sipposcasaderopa.data.repository.salesAgent.SalesAgentRepository
import net.sipconsult.sipposcasaderopa.data.repository.salesAgent.SalesAgentRepositoryImpl
import net.sipconsult.sipposcasaderopa.data.repository.transaction.TransactionRepository
import net.sipconsult.sipposcasaderopa.data.repository.transaction.TransactionRepositoryImpl
import net.sipconsult.sipposcasaderopa.data.repository.user.UserRepository
import net.sipconsult.sipposcasaderopa.data.repository.user.UserRepositoryImpl
import net.sipconsult.sipposcasaderopa.ui.home.HomeViewModelFactory
import net.sipconsult.sipposcasaderopa.ui.login.LoginViewModelFactory
import net.sipconsult.sipposcasaderopa.ui.payment.PaymentViewModelFactory
import net.sipconsult.sipposcasaderopa.ui.payment.paymentmethod.loyalty.LoyaltyViewModelFactory
import net.sipconsult.sipposcasaderopa.ui.productCategory.ProductCategoryViewModelFactory
import net.sipconsult.sipposcasaderopa.ui.products.ProductViewModelFactory
import net.sipconsult.sipposcasaderopa.ui.receipt.ReceiptViewModelFactory
import net.sipconsult.sipposcasaderopa.ui.settings.SettingsViewModelFactory
import net.sipconsult.sipposcasaderopa.ui.transactions.SalesTransactionViewModelFactory
import net.sipconsult.sipposcasaderopa.ui.transactions.refund.RefundViewModelFactory
import net.sipconsult.sipposcasaderopa.util.FileUtils
import net.sipconsult.sipposcasaderopa.util.SunmiPrintHelper
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import sunmi.sunmiui.utils.LogUtil
import java.io.FileNotFoundException
import java.io.PrintStream

class SipPosApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@SipPosApplication))

        bind() from singleton { ApplicationDatabase(instance()) }
        bind() from singleton { instance<ApplicationDatabase>().userDao() }
        bind() from singleton { instance<ApplicationDatabase>().productsDao() }
        bind() from singleton { instance<ApplicationDatabase>().productCategoriesDao() }
        bind() from singleton { instance<ApplicationDatabase>().clientsDao() }
        bind() from singleton { instance<ApplicationDatabase>().discountTypeDao() }
        bind() from singleton { instance<ApplicationDatabase>().paymentMethodDao() }
        bind() from singleton { instance<ApplicationDatabase>().locationDao() }
        bind() from singleton { instance<ApplicationDatabase>().salesAgentDao() }

        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { SipShopApiService(instance()) }

        bind<ProductNetworkDataSource>() with singleton {
            ProductNetworkDataSourceImpl(
                instance()
            )
        }
        bind<ProductLocalDataSource>() with singleton {
            ProductLocalDataSourceImpl(
                instance()
            )
        }

        bind<ProductCategoryNetworkDataSource>() with singleton {
            ProductCategoryNetworkDataSourceImpl(
                instance()
            )
        }
        bind<ProductCategoryLocalDataSource>() with singleton {
            ProductCategoryLocalDataSourceImpl(
                instance()
            )
        }

        bind<PaymentMethodNetworkDataSource>() with singleton {
            PaymentMethodNetworkDataSourceImpl(
                instance()
            )
        }
        bind<PaymentMethodLocalDataSource>() with singleton {
            PaymentMethodLocalDataSourceImpl(
                instance()
            )
        }


        bind<TransactionLocalDataSource>() with singleton {
            TransactionLocalDataSourceImpl()
        }
        bind<TransactionNetworkDataSource>() with singleton {
            TransactionNetworkDataSourceImpl(
                instance()
            )
        }

        bind<DiscountTypesLocalDataSource>() with singleton {
            DiscountTypesLocalDataSourceImpl(
                instance()
            )
        }
        bind<DiscountTypesNetworkDataSource>() with singleton {
            DiscountTypesNetworkDataSourceImpl(
                instance()
            )
        }

        bind<LocationLocalDataSource>() with singleton {
            LocationLocalDataSourceImpl(
                instance()
            )
        }
        bind<LocationNetworkDataSource>() with singleton {
            LocationNetworkDataSourceImpl(
                instance()
            )
        }

        bind<SalesAgentLocalDataSource>() with singleton {
            SalesAgentLocalDataSourceImpl(
                instance()
            )
        }
        bind<SalesAgentNetworkDataSource>() with singleton {
            SalesAgentNetworkDataSourceImpl(
                instance()
            )
        }

        bind<UserDataSource>() with singleton {
            UserDataSourceImpl(
                instance(),
                instance()
            )
        }



        bind<ProductRepository>() with singleton {
            ProductRepositoryImpl(
                instance(),
                instance()
            )
        }

        bind<ProductCategoryRepository>() with singleton {
            ProductCategoryRepositoryImpl(
                instance(),
                instance()
            )
        }

        bind<TransactionRepository>() with singleton {
            TransactionRepositoryImpl(
                instance(),
                instance()
            )
        }

        bind<DiscountTypeRepository>() with singleton {
            DiscountTypeRepositoryImpl(
                instance(),
                instance()
            )
        }

        bind<PaymentMethodRepository>() with singleton {
            PaymentMethodRepositoryImpl(
                instance(),
                instance()
            )
        }

        bind<LocationRepository>() with singleton {
            LocationRepositoryImpl(
                instance(),
                instance()
            )
        }

        bind<SalesAgentRepository>() with singleton {
            SalesAgentRepositoryImpl(
                instance(),
                instance()
            )
        }

        bind<UserRepository>() with singleton {
            UserRepositoryImpl(
                instance(),
                this@SipPosApplication
            )
        }

        bind<LocationProvider>() with singleton {
            LocationProviderImpl(this@SipPosApplication)
        }
        bind<PosNumberProvider>() with singleton {
            PosNumberProviderImpl(this@SipPosApplication)
        }

        bind() from provider { HomeViewModelFactory(instance()) }
        bind() from provider { ProductCategoryViewModelFactory(instance()) }
        bind() from provider { ProductViewModelFactory(instance(), instance()) }
        bind() from provider { LoginViewModelFactory(instance()) }

        bind() from provider {
            SharedViewModelFactory(
                instance(),
                instance(),
                instance(),
                instance(),
                instance(),
                instance(),
                instance(),
                this@SipPosApplication
            )
        }
        bind() from provider { ReceiptViewModelFactory(instance()) }

        bind() from provider { PaymentViewModelFactory(instance()) }

        bind() from provider { SettingsViewModelFactory(instance()) }

        bind() from provider { LoyaltyViewModelFactory(instance()) }

        bind() from provider { SalesTransactionViewModelFactory(instance(), instance()) }

        bind() from provider { RefundViewModelFactory(instance()) }
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        init()
    }


    /**
     * Connect print service through interface library
     */
    fun init() {
        SunmiPrintHelper.instance.initSunmiPrinterService(this)
//        configUncaughtExceptionHandler()
    }

    /**
     * 捕获异常
     */
    private fun configUncaughtExceptionHandler() {
        Thread.setDefaultUncaughtExceptionHandler { thread, ex ->
            LogUtil.e(TAG, "uncaughtException crash")
            Toast.makeText(this@SipPosApplication, "crash", Toast.LENGTH_LONG).show()
            try {
                ex.printStackTrace(PrintStream(FileUtils.createErrorFile()))
            } catch (e: FileNotFoundException) {
                LogUtil.e(TAG, "创建异常文件失败")
                e.printStackTrace()
            }
        }
    }

    companion object {
        private const val TAG = "SipPOSApplication"
    }
}