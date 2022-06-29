package com.segared.krea.di

import com.segared.krea.network.KreaApi
import com.segared.krea.repository.KreaRepository
import com.segared.krea.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesKreaApi(): KreaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.KREA_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(KreaApi::class.java)
    }

    @Singleton
    @Provides
    fun provideKreaRepository(api: KreaApi) = KreaRepository(api)

}