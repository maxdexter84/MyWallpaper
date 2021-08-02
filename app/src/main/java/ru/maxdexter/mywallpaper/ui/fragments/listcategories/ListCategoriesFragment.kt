package ru.maxdexter.mywallpaper.ui.fragments.listcategories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import ru.maxdexter.mywallpaper.ui.adapters.loadstate.ImageLoadStateAdapter
import ru.maxdexter.mywallpaper.ui.adapters.image.ImageAdapter
import ru.maxdexter.mywallpaper.databinding.ListCategoriesFragmentBinding
import ru.maxdexter.mywallpaper.utils.NetworkCheck
import ru.maxdexter.mywallpaper.utils.loadStateListener

class ListCategoriesFragment : Fragment() {

    private val viewModel: ListCategoriesViewModel by inject()
    private var _binding: ListCategoriesFragmentBinding? = null
    private val binding get() = _binding!!
    private val args by lazy {
        arguments?.let { ListCategoriesFragmentArgs.fromBundle(it).categoryName }
    }
    private val imageAdapter: ImageAdapter by lazy { ImageAdapter {
        findNavController().navigate(
            ListCategoriesFragmentDirections.actionListCategoriesFragmentToDetailFragment(
                it
            )
        )
    }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ListCategoriesFragmentBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        val networkCheck = NetworkCheck(requireActivity().application)
        networkCheck.observe(viewLifecycleOwner, {
            when(it){
                false -> showSnackBar(requireView(),"Отсутствует интернет соединение")
                true -> args?.let { initObserveData(it) }
            }
        })


    }

    private fun showSnackBar(view: View, text: String){
        Snackbar.make(view,text, Snackbar.LENGTH_INDEFINITE).show()
    }

    private fun initObserveData(category: String) {
        lifecycleScope.launch {
            viewModel.getImagesFromCategory(category).collect {
                imageAdapter.submitData(it)
            }
        }

    }

    private fun initRecyclerView() {
        binding.rvImageList.apply {
            adapter = imageAdapter.withLoadStateHeaderAndFooter(
                header = ImageLoadStateAdapter { imageAdapter.retry() },
                footer = ImageLoadStateAdapter { imageAdapter.retry() }
            )
        }
        imageAdapter.loadStateListener(binding, requireContext())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}