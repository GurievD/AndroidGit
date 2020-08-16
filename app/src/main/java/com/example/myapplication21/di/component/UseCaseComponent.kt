package com.example.myapplication21.di.component

import com.example.myapplication21.di.module.UseCaseModule
import com.example.myapplication21.domain.usecase.function.sort.StudentSortUseCase
import com.example.myapplication21.presentaton.fragment.ViewPagerFragment
import dagger.Component

@Component(modules = [UseCaseModule::class])
interface UseCaseComponent {
    fun initiateReturnStudentsUseCase(): StudentSortUseCase

    fun inject(viewPagerFragment: ViewPagerFragment)
}