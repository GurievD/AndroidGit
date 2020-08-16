package com.example.myapplication21.di.module

import com.example.myapplication21.domain.usecase.function.sort.StudentSortUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun providesStudentsSortUseCase(): StudentSortUseCase {
        return StudentSortUseCase()
    }
}