package com.example.gatheringfront.di


import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
//    single{
//        val retrofit = Retrofit.Builder()
//            .baseUrl("http://127.0.0.1:8080/api/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
    single<Retrofit>{
        Retrofit.Builder()
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://127.0.0.1:8080/api/")
            .build()
    }
//    single<PostService> {
//        get<Retrofit>().create(CalendarService::class.java)
//    }
//    single<ContentService> {
//        get<Retrofit>().create(ContentService::class.java)
//    }
//    single<DiaryService> {
//        get<Retrofit>().create(DiaryService::class.java)
//    }
//    single<HomeService> {
//        get<Retrofit>().create(HomeService::class.java)
//    }
//    single<ProfileService> {
//        get<Retrofit>().create(ProfileService::class.java)
//    }
//    single<RainbowService> {
//        get<Retrofit>().create(RainbowService::class.java)
//    }
//    single<UserService> {
//        get<Retrofit>().create(UserService::class.java)
//    }
}