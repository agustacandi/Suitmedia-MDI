package dev.agustacandi.learn.suitmedia_1.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dev.agustacandi.learn.suitmedia_1.BuildConfig
import dev.agustacandi.learn.suitmedia_1.data.user.remote.UserService
import dev.agustacandi.learn.suitmedia_1.utils.ConstVal
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

// Logging Interceptor for debugging purposes (only run in debug mode)
private val loggingInterceptor = if (BuildConfig.DEBUG) {
    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
} else {
    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
}

// Moshi for JSON parsing
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

// Koin module for network dependencies
val networkModule = module {
    // Single instance of OkHttpClient
    single {
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    // Single instance of Retrofit
    single {
        Retrofit.Builder()
            .baseUrl(ConstVal.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(get())
            .build()
    }

    // Single instance of UserService
    single {
        provideUserServices(get())
    }
}

// Function to provide UserService instance
fun provideUserServices(retrofit: Retrofit): UserService = retrofit.create(UserService::class.java)