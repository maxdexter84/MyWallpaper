package ru.maxdexter.mywallpaper.ui.fragments.category

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.maxdexter.mywallpaper.R
import ru.maxdexter.mywallpaper.databinding.CategoryFragmentBinding

class CategoryFragment : Fragment() {


    private lateinit var viewModel: CategoryViewModel
    private var binding: CategoryFragmentBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CategoryFragmentBinding.inflate(layoutInflater)

        return binding?.root
    }


    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }



}