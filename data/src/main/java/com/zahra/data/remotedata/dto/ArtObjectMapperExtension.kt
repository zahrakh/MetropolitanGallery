package com.zahra.data.remotedata.dto

import com.zahra.domain.data.Department
import com.zahra.domain.data.Departments
import com.zahra.domain.data.MuseumObjectDetails
import com.zahra.domain.data.ObjectsIds

internal fun ObjectsDto.toObjectIds(): ObjectsIds = ObjectsIds(
    total = this.total,
    objectIDs = this.objectIDs
)

internal fun DepartmentDto.toDepartment(): Department = Department(
    departmentId = this.departmentId,
    departmentName = this.displayName,
)

internal fun DepartmentsDto.toDepartmentList(): Departments = Departments(
    departments = this.departments?.map { it.toDepartment() }
)


internal fun ObjectsDetailsDto.toObjectDetails(): MuseumObjectDetails = MuseumObjectDetails(
    objectID = this.objectID
)

