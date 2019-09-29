package com.mona.basemvp.base

abstract class BaseRepository: BaseContract.BaseIRepository {
    val remoteDataSource = RemoteDataSource.instance
    val localDataSource = LocalDataSource.instance
}

