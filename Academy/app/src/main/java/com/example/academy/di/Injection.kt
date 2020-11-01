package com.example.academy.di

import android.content.Context
import com.example.academy.data.source.AcademyRepository
import com.example.academy.data.source.remote.RemoteDataSource
import com.example.academy.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): AcademyRepository {

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return AcademyRepository.getInstance(remoteDataSource)
    }
}