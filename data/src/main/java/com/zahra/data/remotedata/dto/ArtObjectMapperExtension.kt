package com.zahra.data.remotedata.dto

import com.zahra.domain.data.Department
import com.zahra.domain.data.Departments
import com.zahra.domain.data.ObjectsIds

internal fun ObjectsResponseDto.toObjectIds(): ObjectsIds = ObjectsIds(
    total = this.total,
    objectIDs = this.objectIDs
)

internal fun DepartmentDto.toDepartment(): Department = Department(
    departmentId = this.departmentId,
    departmentName = this.displayName,
)

internal fun DepartmentResponseDto.toDepartmentList(): Departments = Departments(
    departments = this.departments?.map { it.toDepartment() }
)


