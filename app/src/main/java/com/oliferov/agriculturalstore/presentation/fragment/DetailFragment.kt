package com.oliferov.agriculturalstore.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.oliferov.agriculturalstore.data.repository.GoodsRepositoryImpl
import com.oliferov.agriculturalstore.databinding.FragmentDetailsBinding
import com.oliferov.agriculturalstore.domain.Goods
import com.oliferov.agriculturalstore.presentation.viewmodel.GoodsViewModel

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding: FragmentDetailsBinding
        get() = _binding ?: throw RuntimeException("FragmentDetailsBinding is null")

    private val repository by lazy {
        GoodsRepositoryImpl()
    }

    private lateinit var viewModel: GoodsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = GoodsViewModel(repository)
        val goods = getGoodsInArgs()
        with(binding) {
            with(goods) {
                tvName.text = name
                tvPrice.text = "$price"
                tvArticle.text = "$article"
                Glide.with(requireActivity()).load(image).into(ivGoods)
            }
        }


    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    private fun getGoodsInArgs(): Goods = requireArguments().getSerializable(EXTRA_GOODS) as Goods

    companion object {

        private const val EXTRA_GOODS = "goods"

        fun newInstance(goods: Goods): Fragment {
            return DetailFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(EXTRA_GOODS, goods)
                }
            }
        }
    }
}