package com.example.myapplication21.di.module

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.myapplication21.domain.usecase.function.context.MyContext
import dagger.Module
import dagger.Provides

@Module
class ContextModule(var fragment: Fragment) {
    @Provides
    fun providesContext(): Context {
        return fragment.context!!
    }

    @Provides
    fun providesMyContext(): MyContext {
        return MyContext()
    }
}