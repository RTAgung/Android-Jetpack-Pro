package com.example.academy.di

import android.content.Context
import com.example.academy.data.source.AcademyRepository
import com.example.academy.data.source.local.LocalDataSource
import com.example.academy.data.source.local.room.AcademyDatabase
import com.example.academy.data.source.remote.RemoteDataSource
import com.example.academy.utils.AppExecutors
import com.example.academy.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): AcademyRepository {

        val database = AcademyDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.academyDao())
        val appExecutors = AppExecutors()

        return AcademyRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}