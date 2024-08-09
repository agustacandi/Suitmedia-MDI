package dev.agustacandi.learn.suitmedia_1.presenter.first_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dev.agustacandi.learn.suitmedia_1.R
import dev.agustacandi.learn.suitmedia_1.base.BaseFragment
import dev.agustacandi.learn.suitmedia_1.databinding.FragmentFirstScreenBinding
import dev.agustacandi.learn.suitmedia_1.utils.Helper
import dev.agustacandi.learn.suitmedia_1.utils.PreferenceManager
import dev.agustacandi.learn.suitmedia_1.utils.ext.isPalindrome
import org.koin.android.ext.android.inject

class FirstScreenFragment : BaseFragment<FragmentFirstScreenBinding>() {

    private val preferenceManager: PreferenceManager by inject()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentFirstScreenBinding = FragmentFirstScreenBinding.inflate(inflater, container, false)

    override fun initIntent() {
    }

    override fun initUI() {
    }

    override fun initAction() {
        binding.apply {
            btnCheck.setOnClickListener {
                val palindrome = edPalindrome.text.toString()
                if (palindrome.isNotEmpty() && palindrome.isPalindrome()) {
                    Helper.showToast("isPalindrome", requireContext())
                } else {
                    Helper.showToast("not palindrome", requireContext())
                }
            }

            btnNext.setOnClickListener {
                val name = edName.text.toString()
                if (name.isNotEmpty()) {
                    preferenceManager.setNamePrefs(name)
                    Helper.reloadKoinModules()
                    val navigateToSecondScreen = FirstScreenFragmentDirections.actionFirstScreenFragmentToSecondScreenFragment()
                    findNavController().navigate(navigateToSecondScreen)
                } else {
                    Helper.showToast(getString(R.string.please_enter_your_name), requireContext())
                }
            }
        }
    }

    override fun initProcess() {
    }

    override fun initObservers() {
    }

}