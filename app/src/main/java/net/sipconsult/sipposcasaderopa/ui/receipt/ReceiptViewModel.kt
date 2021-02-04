package net.sipconsult.sipposcasaderopa.ui.receipt

import androidx.lifecycle.ViewModel
import net.sipconsult.sipposcasaderopa.data.repository.transaction.TransactionRepository
import net.sipconsult.sipposcasaderopa.util.BluetoothUtil
import net.sipconsult.sipposcasaderopa.util.Receipt
import net.sipconsult.sipposcasaderopa.util.SunmiPrintHelper

class ReceiptViewModel(private val transactionRepository: TransactionRepository) : ViewModel() {
    lateinit var receipt: Receipt

    private val isBold = true
    private val isUnderLine: Boolean = false

    fun printReceipt() {
        if (!BluetoothUtil.isBlueToothPrinter) {
//            SunmiPrintHelper.instance.printBitmap()
            SunmiPrintHelper.instance.printText(receipt.receiptPreview, 24.0F, isBold, isUnderLine)
//            SunmiPrintHelper.instance.feedPaper()
            SunmiPrintHelper.instance.cutpaper()
        }
    }


}