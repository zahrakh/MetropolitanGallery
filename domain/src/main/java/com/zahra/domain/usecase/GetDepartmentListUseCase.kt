package com.zahra.domain.usecase

import com.zahra.domain.data.Departments
import com.zahra.domain.data.common.Either
import com.zahra.domain.repository.GalleryRepository
import javax.inject.Inject

interface GetDepartmentListUseCase {
    suspend operator fun invoke(): Either<Departments?, String>
}

class GetDepartmentListUseCaseImp @Inject constructor(
    private val repository: GalleryRepository
) : GetDepartmentListUseCase {


    override suspend fun invoke(): Either<Departments?, String> = repository.getDepartmentList()

}