package dev.agustacandi.learn.suitmedia_1.presenter.third_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dev.agustacandi.learn.suitmedia_1.base.BaseFragment
import dev.agustacandi.learn.suitmedia_1.databinding.FragmentThirdScreenBinding
import org.koin.android.ext.android.inject

class ThirdScreenFragment : BaseFragment<FragmentThirdScreenBinding>() {

    private val viewModel: ThirdScreenViewModel by inject()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentThirdScreenBinding = FragmentThirdScreenBinding.inflate(inflater, container, false)

    override fun initIntent() {
    }

    override fun initUI() {
    }

    override fun initAction() {
        binding.apply {
            ibBack.setOnClickListener {
                findNavController().popBackStack()
            }

            swipeRefresh.setOnRefreshListener {
                getData()
                swipeRefresh.isRefreshing = false
            }
        }
    }

    override fun initProcess() {
    }

    override fun initObservers() {
        getData()
    }

    private fun getData() {
        val adapter = UserAdapter(navDirections = {
            ThirdScreenFragmentDirections.actionThirdScreenFragmentToSecondScreenFragment(it)
        })

        binding.apply {
            rvUsers.layoutManager = LinearLayoutManager(requireActivity())
            rvUsers.adapter = adapter.withLoadStateFooter(
                footer = LoadingStateAdapter {
                    adapter.retry()
                }
            )
        }
        viewModel.user.observe(requireActivity()) {
            adapter.submitData(lifecycle, it)
        }
    }
}
