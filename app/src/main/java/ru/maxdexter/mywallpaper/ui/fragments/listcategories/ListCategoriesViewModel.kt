package ru.maxdexter.mywallpaper.ui.fragments.listcategories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.maxdexter.mywallpaper.domain.common.LoadingResponse
import ru.maxdexter.mywallpaper.domain.usecases.GetImagesUseCase
import ru.maxdexter.mywallpaper.ui.model.Image
import ru.maxdexter.mywallpaper.ui.paging.ImagePaging
import ru.maxdexter.mywallpaper.ui.paging.ImagePaging.Companion.PAGE_SIZE

class ListCategoriesViewModel(private val useCase: GetImagesUseCase) : ViewModel() {
    private var currentCategory: String? = null
    private var currentSearchResult: Flow<PagingData<Image>>? = null

    private val _imageList = MutableLiveData<List<Image>>()
    val imageList: LiveData<List<Image>>
        get() = _imageList

    private val _error = MutableLiveData<String?>(null)
    val error: LiveData<String?>
        get() = _error

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading



     fun getImagesFromCategory(category: String):Flow<PagingData<Image>> {
         val lastResult = currentSearchResult
         if (lastResult != null && currentCategory == category){
             return lastResult
         }
         currentCategory = category

         val newResult = pagingImages(category).cachedIn(viewModelScope) //cachedIn кеширует данные из результатов запроса
         currentSearchResult = newResult
         return newResult
//        viewModelScope.launch(Dispatchers.IO) {
//            val response = useCase.getAllImages(category, pageNumber, pageSize)
//            handleParseResult(response)
//
//        }
    }

    private suspend fun handleParseResult(response: LoadingResponse){

        withContext(Dispatchers.Main){
            when (response) {
                is LoadingResponse.Loading -> {
                    _isLoading.value = true
                }
                is LoadingResponse.Error -> {
                    Log.e("NETWORK_ERROR", response.message)
                    _isLoading.value = false
                    _error.value = "Ошибка загрузки данных"
                }
                is LoadingResponse.Success -> {
                    _isLoading.value = false
                    _imageList.value = response.data
                }
            }
        }
    }

    private fun pagingImages(category: String): Flow<PagingData<Image>> {
        return Pager(config = PagingConfig(pageSize = PAGE_SIZE, enablePlaceholders = false),
            pagingSourceFactory = { ImagePaging(useCase,category) }).flow
    }
}