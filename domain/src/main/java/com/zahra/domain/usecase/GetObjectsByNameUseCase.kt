package com.zahra.domain.usecase

import com.zahra.domain.data.ObjectsIds
import com.zahra.domain.data.common.Either
import com.zahra.domain.repository.GalleryRepository
import javax.inject.Inject

interface GetObjectsByNameUseCase {
    suspend operator fun invoke(departmentName: String): Either<ObjectsIds?, String>
}

class GetObjectsByNameUseCaseImp @Inject constructor(
    private val repository: GalleryRepository
) : GetObjectsByNameUseCase {

    override suspend fun invoke(departmentName: String): Either<ObjectsIds?, String> =
        repository.getObjectsByName(departmentName)
}