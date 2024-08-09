package dev.agustacandi.learn.suitmedia_1.presenter.second_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dev.agustacandi.learn.suitmedia_1.base.BaseFragment
import dev.agustacandi.learn.suitmedia_1.databinding.FragmentSecondScreenBinding
import dev.agustacandi.learn.suitmedia_1.utils.PreferenceManager
import org.koin.android.ext.android.inject

class SecondScreenFragment : BaseFragment<FragmentSecondScreenBinding>() {

    private var userName: String? = null
    private val preferenceManager: PreferenceManager by inject()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentSecondScreenBinding = FragmentSecondScreenBinding.inflate(inflater, container, false)

    override fun initIntent() {
        userName = arguments?.getString("userName")
    }

    override fun initUI() {
        binding.apply {
            tvUserName.text = preferenceManager.getName
            tvSelectedUserName.text = userName
        }
    }

    override fun initAction() {
        binding.apply {
            ibBack.setOnClickListener {
                findNavController().popBackStack()
            }

            btnChooseUser.setOnClickListener {
                val navigateToThirdScreen = SecondScreenFragmentDirections.actionSecondScreenFragmentToThirdScreenFragment()
                findNavController().navigate(navigateToThirdScreen)
            }
        }
    }

    override fun initProcess() {
    }

    override fun initObservers() {
    }

}