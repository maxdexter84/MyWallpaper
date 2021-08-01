package ru.maxdexter.mywallpaper.ui.fragments.listcategories

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.maxdexter.mywallpaper.R

class ListCategoriesFragment : Fragment() {

    companion object {
        fun newInstance() = ListCategoriesFragment()
    }

    private lateinit var viewModel: ListCategoriesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_categories_fragment, container, false)
    }



}