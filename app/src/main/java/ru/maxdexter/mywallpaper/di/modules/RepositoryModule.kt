package ru.maxdexter.mywallpaper.di.modules

import org.koin.dsl.module
import ru.maxdexter.mywallpaper.data.repository.RepositoryImpl
import ru.maxdexter.mywallpaper.domain.interfaces.Repository

val repositoryModule = module {
    factory <Repository>{ RepositoryImpl( api = get() ) }
}