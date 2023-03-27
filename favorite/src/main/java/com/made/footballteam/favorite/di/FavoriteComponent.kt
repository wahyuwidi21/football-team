package com.made.footballteam.favorite.di

import android.content.Context
import com.made.footballteam.FavoriteModuleDependencies
import com.made.footballteam.favorite.FavoriteFragment
import dagger.BindsInstance
import dagger.Component
@Component(dependencies = [FavoriteModuleDependencies::class])
interface FavoriteComponent {

    fun inject(fragment: FavoriteFragment)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(mapsModuleDependencies: FavoriteModuleDependencies): Builder
        fun build(): FavoriteComponent
    }

}