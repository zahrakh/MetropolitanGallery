package com.zahra.domain.usecase

import com.zahra.domain.data.ObjectsIds
import com.zahra.domain.data.common.Either
import com.zahra.domain.repository.GalleryRepository
import javax.inject.Inject

interface GetObjectsByIdUseCase {
    suspend operator fun invoke(departmentId: Int): Either<ObjectsIds?, String>
}

class GetObjectsByIdUseCaseImp @Inject constructor(
    private val repository: GalleryRepository
) : GetObjectsByIdUseCase {

    override suspend fun invoke(departmentId: Int): Either<ObjectsIds?, String> =
        repository.getObjectsById(departmentId)

}