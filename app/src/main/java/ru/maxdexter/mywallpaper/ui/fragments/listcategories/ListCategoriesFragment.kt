package ru.maxdexter.mywallpaper.ui.fragments.listcategories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import org.koin.android.ext.android.inject
import ru.maxdexter.mywallpaper.databinding.ListCategoriesFragmentBinding
import ru.maxdexter.mywallpaper.utils.hide
import ru.maxdexter.mywallpaper.utils.show

class ListCategoriesFragment : Fragment() {

    private val viewModel: ListCategoriesViewModel by inject()
    private var _binding: ListCategoriesFragmentBinding? = null
    private val binding get() = _binding!!
    private var category: String =
        arguments?.let { ListCategoriesFragmentArgs.fromBundle(it) }?.categoryName ?: ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ListCategoriesFragmentBinding.inflate(layoutInflater)
        viewModel.getImagesFromCategory(category,1,200)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadingListener()
        dataListener()
        errorListener()
    }


    private fun loadingListener() {
        viewModel.isLoading.observe(viewLifecycleOwner, {
            when (it) {
                true -> binding.paginationProgressBar.show()
                else -> binding.paginationProgressBar.hide()
            }
        })
    }

    private fun dataListener() {
        viewModel.imageList.observe(viewLifecycleOwner, {
            when (it.isNotEmpty()) {
                true -> {
                    binding.rvImageList.show()
                }
                else -> binding.rvImageList.hide()
            }
        })
    }

    private fun errorListener() {
        viewModel.error.observe(viewLifecycleOwner, {
            when (!it.isNullOrEmpty()) {
                true -> {
                    showSnackBar(it)
                }
            }
        })
    }


    private fun showSnackBar(text: String) {
        Snackbar.make(binding.root, text, Snackbar.LENGTH_INDEFINITE).setAction("Повторить") {
            viewModel.getImagesFromCategory(category, 1, 200)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}