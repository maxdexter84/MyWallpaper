package ru.maxdexter.mywallpaper.ui.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import retrofit2.HttpException
import ru.maxdexter.mywallpaper.domain.usecases.GetImagesUseCase
import ru.maxdexter.mywallpaper.ui.model.Image

class ImagePaging(
    private val useCase: GetImagesUseCase,
    private val category: String,
) : PagingSource<Int, Image>() {
    override fun getRefreshKey(state: PagingState<Int, Image>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Image> {
        val position = params.key ?: START_PAGE
        return try {
            val res = useCase.getAllImages(
                pageNumber = position,
                category = category,
                pageSize = params.loadSize,
            )
            val nextKey =
                if (res.isEmpty()) null else position + (params.loadSize / PAGE_SIZE)
            return LoadResult.Page(
                data = res,
                prevKey = if (position == START_PAGE) null else position - 1,
                nextKey = nextKey
            )
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }


    companion object {
        const val PAGE_SIZE = 60
        const val START_PAGE = 1
    }
}