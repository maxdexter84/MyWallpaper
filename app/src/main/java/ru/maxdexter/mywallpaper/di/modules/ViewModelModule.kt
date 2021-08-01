package ru.maxdexter.mywallpaper.di.modules

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.maxdexter.mywallpaper.ui.fragments.category.CategoryViewModel
import ru.maxdexter.mywallpaper.ui.fragments.listcategories.ListCategoriesViewModel

val viewModelModule = module{

    viewModel {
        CategoryViewModel()
    }

    viewModel {
        ListCategoriesViewModel(useCase = get())
    }
}