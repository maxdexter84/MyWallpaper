package ru.maxdexter.mywallpaper.ui.fragments.listcategories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.maxdexter.mywallpaper.domain.common.LoadingResponse
import ru.maxdexter.mywallpaper.domain.usecases.GetImagesUseCase
import ru.maxdexter.mywallpaper.ui.model.Image

class ListCategoriesViewModel(private val useCase: GetImagesUseCase) : ViewModel() {

    private val _imageList = MutableLiveData<List<Image>>()
    val imageList: LiveData<List<Image>>
        get() = _imageList

    private val _error = MutableLiveData<String?>(null)
    val error: LiveData<String?>
        get() = _error

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading



     fun getImagesFromCategory(category: String, pageNumber: Int, pageSize: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = useCase.getAllImages(category, pageNumber, pageSize)
            handleParseResult(response)

        }
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
}