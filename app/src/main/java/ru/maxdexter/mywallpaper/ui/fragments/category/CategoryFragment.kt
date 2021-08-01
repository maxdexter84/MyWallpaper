package ru.maxdexter.mywallpaper.ui.fragments.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.maxdexter.mywallpaper.databinding.CategoryFragmentBinding
import ru.maxdexter.mywallpaper.ui.adapters.category.CategoryAdapter

class CategoryFragment : Fragment() {


    private lateinit var viewModel: CategoryViewModel
    private var binding: CategoryFragmentBinding? = null
    private val categoryAdapter by lazy {
        CategoryAdapter({
            Toast.makeText(requireContext(),it,Toast.LENGTH_SHORT).show()
        })
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CategoryFragmentBinding.inflate(layoutInflater)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)
        viewModel.categoryList.observe(viewLifecycleOwner,{
            categoryAdapter.submitList(it)
            binding?.rvCategoryList?.adapter = categoryAdapter
        })


    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}