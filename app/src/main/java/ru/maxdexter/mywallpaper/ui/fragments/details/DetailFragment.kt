package ru.maxdexter.mywallpaper.ui.fragments.details

import android.app.WallpaperManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.drawToBitmap
import androidx.fragment.app.Fragment
import ru.maxdexter.mywallpaper.databinding.DetailFragmentBinding
import ru.maxdexter.mywallpaper.ui.fragments.listcategories.ListCategoriesFragmentArgs
import ru.maxdexter.mywallpaper.utils.setImage

class DetailFragment : Fragment() {


    private lateinit var viewModel: DetailViewModel

    private var _binding: DetailFragmentBinding? = null
    private val binding get() = _binding!!
    private val args by lazy {
        arguments?.let { DetailFragmentArgs.fromBundle(it).imageUrl }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DetailFragmentBinding.inflate(layoutInflater, container, false)

        binding.ivDetail.setImage(args)
        binding.dtnSetWallpaper.setOnClickListener {
            val wallpaperManager = WallpaperManager.getInstance(requireContext())
            wallpaperManager.setBitmap(binding.ivDetail.drawToBitmap())
        }
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}