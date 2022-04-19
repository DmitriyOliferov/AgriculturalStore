package com.oliferov.agriculturalstore.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.oliferov.agriculturalstore.R
import com.oliferov.agriculturalstore.data.repository.GoodsRepositoryImpl
import com.oliferov.agriculturalstore.databinding.FragmentGoodsListBinding
import com.oliferov.agriculturalstore.domain.Goods
import com.oliferov.agriculturalstore.presentation.viewmodel.GoodsViewModel
import com.oliferov.agriculturalstore.presentation.adapter.GoodsAdapter

class GoodsListFragment: Fragment() {

    private val repository by lazy {
        GoodsRepositoryImpl()
    }

    private lateinit var viewModel: GoodsViewModel

    private var _binding: FragmentGoodsListBinding? = null
    private val binding: FragmentGoodsListBinding
        get() = _binding ?: throw RuntimeException("FragmentGoodsListBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGoodsListBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = GoodsViewModel(repository)
        val adapter = GoodsAdapter(requireContext())
        adapter.onGoodsClickListener = object : GoodsAdapter.OnGoodsClickListener {
            override fun onGoodsClick(goods: Goods) {
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, DetailFragment.newInstance(goods))
                    .addToBackStack(null)
                    .commit()
            }
        }
        binding.rvGoodsList.adapter = adapter
        viewModel.goodsList.observe(requireActivity()) {
            adapter.submitList(it)
        }
    }
    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    companion object {
        fun newInstance(): Fragment {
            return GoodsListFragment()
        }
    }
}