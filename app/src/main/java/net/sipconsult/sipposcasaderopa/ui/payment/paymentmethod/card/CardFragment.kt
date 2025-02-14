package net.sipconsult.sipposcasaderopa.ui.payment.paymentmethod.card

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.card_fragment.*
import net.sipconsult.sipposcasaderopa.R
import net.sipconsult.sipposcasaderopa.SharedViewModel
import net.sipconsult.sipposcasaderopa.databinding.CardFragmentBinding
import net.sipconsult.sipposcasaderopa.ui.base.ScopedFragment

class CardFragment : ScopedFragment() {

    private var _binding: CardFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        sharedViewModel = activity?.run {
            ViewModelProvider(this)[SharedViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        _binding = CardFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = sharedViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        sharedViewModel.editTextCardNumber.observe(viewLifecycleOwner, Observer { cardNumber ->

            if (!cardNumber.isNullOrEmpty()) {
                sharedViewModel.cardNumber = cardNumber.trim()
            } else {
                sharedViewModel.cardNumber = ""
            }

        })

        sharedViewModel.editTextCardAmount.observe(viewLifecycleOwner, Observer { amount ->
            if (!amount.isNullOrEmpty()) {
                sharedViewModel.cardAmount = amount.trim().toDouble()
                sharedViewModel.deduct()
            } else {
                sharedViewModel.cardAmount = 0.0
                sharedViewModel.deduct()
            }
        })

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        buildUI()
    }

    private fun buildUI() {
        sharedViewModel.selectedPaymentMethod.observe(
            viewLifecycleOwner,
            Observer { paymentMethod ->
                if (paymentMethod != null) {

                    when (paymentMethod.id) {
                        1 -> {
                            findNavController().navigate(R.id.cashFragment)
                        }
                        2 -> {
                            findNavController().navigate(R.id.mobileMoneyFragment)
                        }
                        5 -> {
                            findNavController().navigate(R.id.loyaltyFragment)
                        }
                        4 -> {
                            findNavController().navigate(R.id.chequeFragment)
                        }
                        6 -> {
                            findNavController().navigate(R.id.complimentaryFragment)
                        }
                        7 -> {
                            findNavController().navigate(R.id.cashDollarFragment)
                        }
                    }
                }
            })

        keyboardVisa.visibility = View.GONE
//        editTextVisaCardNumber.visibility = View.GONE
//        textVisa.visibility = View.GONE

        disableEditText(editTextCardDue)
        disableEditText(editTextCardChange)
    }

    private fun disableEditText(editText: EditText) {
        editText.isFocusable = false
//        editText.isEnabled = false
        editText.isCursorVisible = false
        editText.keyListener = null
//        editText.setBackgroundColor(Color.TRANSPARENT)
    }

    private fun Context.hideKeyboard(view: View) {
        val inputMethodManager =
            getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun Fragment.hideKeyboard() {
        view?.let {
            activity?.hideKeyboard(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}