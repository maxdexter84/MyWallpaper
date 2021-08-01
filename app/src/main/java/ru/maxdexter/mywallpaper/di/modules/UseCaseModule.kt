package ru.maxdexter.mywallpaper.di.modules

import org.koin.dsl.module
import ru.maxdexter.mywallpaper.domain.usecases.GetImagesUseCase
import ru.maxdexter.mywallpaper.domain.usecases.GetImagesUseCaseImpl

val useCaseModule = module {
    factory<GetImagesUseCase> { GetImagesUseCaseImpl(repository = get()) }
}