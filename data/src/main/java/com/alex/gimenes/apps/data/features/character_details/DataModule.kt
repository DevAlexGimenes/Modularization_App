package com.alex.gimenes.apps.data.features.character_details

import com.alex.gimenes.apps.data.features.character_details.remote.MyApi
import com.alex.gimenes.apps.data.features.character_details.repository.CharacterDetailsRepositoryImpl
import com.alex.gimenes.apps.domain.features.character_details.repository.CharacterDetailsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    private const val BASE_URL = "https://rickandmortyapi.com/api/"

    @Provides
    @Singleton
    fun providesCharacterDetailsRepository(myApi: MyApi) : CharacterDetailsRepository {
        return CharacterDetailsRepositoryImpl(myApi)
    }

    @Provides
    @Singleton
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Provides
    @Singleton
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient) : Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit): MyApi = retrofit.create(MyApi::class.java)
}