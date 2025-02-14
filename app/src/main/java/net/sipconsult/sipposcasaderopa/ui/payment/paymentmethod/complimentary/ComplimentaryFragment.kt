package net.sipconsult.sipposcasaderopa.ui.payment.paymentmethod.complimentary

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
import kotlinx.android.synthetic.main.complimentry_fragment.*
import net.sipconsult.sipposcasaderopa.R
import net.sipconsult.sipposcasaderopa.SharedViewModel
import net.sipconsult.sipposcasaderopa.databinding.ComplimentryFragmentBinding
import net.sipconsult.sipposcasaderopa.ui.base.ScopedFragment

class ComplimentaryFragment : ScopedFragment() {

    private var _binding: ComplimentryFragmentBinding? = null

    private val binding get() = _binding!!

    private lateinit var sharedViewModel: SharedViewModel

    private lateinit var viewModel: ComplimentaryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sharedViewModel = activity?.run {
            ViewModelProvider(this)[SharedViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        _binding = ComplimentryFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = sharedViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        sharedViewModel.editTextComplimentaryNumber.observe(
            viewLifecycleOwner,
            Observer { phoneNumber ->

                if (!phoneNumber.isNullOrEmpty()) {
                    sharedViewModel.mobileMoneyPhoneNumber = phoneNumber.trim()
                } else {
                    sharedViewModel.mobileMoneyPhoneNumber = ""
                }

            })

        sharedViewModel.editTextComplimentaryAmount.observe(viewLifecycleOwner, Observer { amount ->
            if (!amount.isNullOrEmpty()) {
                sharedViewModel.mobileMoneyAmount = amount.trim().toDouble()
                sharedViewModel.deduct()
            } else {
                sharedViewModel.mobileMoneyAmount = 0.0
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
                        4 -> {
                            findNavController().navigate(R.id.chequeFragment)
                        }
                        5 -> {
                            findNavController().navigate(R.id.loyaltyFragment)
                        }
                        3 -> {
                            findNavController().navigate(R.id.cardFragment)
                        }
                        7 -> {
                            findNavController().navigate(R.id.cashDollarFragment)
                        }
                    }
                }
            })

//        textComplimentary.visibility = View.GONE
//        editTextComplimentaryPhoneNumber.visibility = View.GONE

        disableEditText(editTextComplimentaryDue)
        disableEditText(editTextComplimentaryChange)

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