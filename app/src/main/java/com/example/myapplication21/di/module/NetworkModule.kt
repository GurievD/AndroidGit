package com.example.myapplication21.di.module

import com.example.myapplication21.data.api.APIImplementation
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {
    @Provides
    fun providesApi() : APIImplementation {
        return APIImplementation()
    }
}
