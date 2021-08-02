package ru.maxdexter.mywallpaper.ui.fragments.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import org.koin.android.ext.android.inject
import ru.maxdexter.mywallpaper.databinding.CategoryFragmentBinding
import ru.maxdexter.mywallpaper.ui.adapters.category.CategoryAdapter
import ru.maxdexter.mywallpaper.utils.NetworkCheck

class CategoryFragment : Fragment() {


    private val viewModel: CategoryViewModel by inject()
    private var binding: CategoryFragmentBinding? = null
    private val categoryAdapter by lazy {
        CategoryAdapter {
            findNavController()
                .navigate(
                    CategoryFragmentDirections.actionCategoryFragmentToListCategoriesFragment(
                        it
                    )
                )
        }
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
        val networkCheck = NetworkCheck(requireActivity().application)
        networkCheck.observe(viewLifecycleOwner, {
            when(it){
                false -> showSnackBar(requireView(),"Отсутствует интернет соединение")
            }
        })
        viewModel.categoryList.observe(viewLifecycleOwner, {
            categoryAdapter.submitList(it)
            binding?.rvCategoryList?.adapter = categoryAdapter
        })


    }
    private fun showSnackBar(view: View, text: String){
        Snackbar.make(view,text, Snackbar.LENGTH_INDEFINITE).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}