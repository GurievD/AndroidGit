package com.example.myapplication21.di.module

import android.content.Context
import com.example.myapplication21.domain.usecase.function.db.DatabaseUseCase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule(var context: Context) {
    @Provides
    fun providesDatabaseUseCase(): DatabaseUseCase {
        return DatabaseUseCase(context)
    }
}