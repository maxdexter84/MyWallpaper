package ru.maxdexter.mywallpaper.ui.fragments.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.maxdexter.mywallpaper.ui.model.Category

class CategoryViewModel : ViewModel() {


    private val _categoryList = MutableLiveData<List<Category>>(emptyList())
    val categoryList: LiveData<List<Category>>
        get() = _categoryList

    init {
        _categoryList.value = listOf(
            Category("backgrounds"),
            Category("fashion"),
            Category("nature"),
            Category("science"),
            Category("education"),
            Category("feelings"),
            Category("health"),
            Category("people"),
            Category("religion"),
            Category("places"),
            Category("animals"),
            Category("industry"),
            Category("computer"),
            Category("food"),
            Category("sports"),
            Category("transportation"),
            Category("travel"),
            Category("buildings"),
            Category("business"),
            Category("music")
            )
    }
}