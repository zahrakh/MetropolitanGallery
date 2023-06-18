package com.zahra.domain.usecase

import com.zahra.domain.data.MuseumObjectDetails
import com.zahra.domain.data.common.Either
import com.zahra.domain.repository.GalleryRepository
import javax.inject.Inject

interface GetObjectDetailsByIdUseCase {
    suspend operator fun invoke(objectID: Int?): Either<MuseumObjectDetails?, String>
}

class GetObjectDetailsByIdUseCaseImp @Inject constructor(
    private val repository: GalleryRepository
) : GetObjectDetailsByIdUseCase {

    override suspend fun invoke(objectID: Int?): Either<MuseumObjectDetails?, String> =
        repository.getObjectDetailsById(objectID)
}