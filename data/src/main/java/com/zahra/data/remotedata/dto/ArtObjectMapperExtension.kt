package com.zahra.data.remotedata.dto


import com.zahra.domain.data.MuseumObjectDetails
import com.zahra.domain.data.ObjectsIds
import com.zahra.domain.data.Tags

internal fun ObjectsDto.toObjectIds(): ObjectsIds = ObjectsIds(
    total = this.total,
    objectIDs = this.objectIDs
)

internal fun ObjectsDetailsDto.toObjectDetails(): MuseumObjectDetails = MuseumObjectDetails(
    objectID = this.objectID,
    primaryImage = this.primaryImage,
    primaryImageSmall = this.primaryImageSmall,
    additionalImages = this.additionalImages,
    department = this.department,
    objectName = this.objectName,
    accessionYear = this.accessionYear,
    title = this.title,
    culture = this.culture,
    artistDisplayName = this.artistDisplayName,
    artistDisplayBio = this.artistDisplayBio,
    artistSuffix = this.artistSuffix,
    artistAlphaSort = this.artistAlphaSort,
    artistNationality = this.artistNationality,
    artistBeginDate = this.artistBeginDate,
    artistEndDate = this.artistEndDate,
    artistGender = this.artistGender,
    artistWikidataURL = this.artistWikidataURL,
    artistULANURL = this.artistULANURL,
    objectDate = this.objectDate,
    objectBeginDate = this.objectBeginDate,
    objectEndDate = this.objectEndDate,
    city = this.city,
    state = this.state,
    county = this.county,
    country = this.country,
    repository=this.repository,
    objectURL = this.objectURL,
    tags = this.tags?.map { it.toTags() },
    GalleryNumber = this.GalleryNumber,
)

internal fun TagsDto.toTags(): Tags = Tags(
    term = this.term,
    AATURL = this.AATURL,
    WikidataURL = this.WikidataURL,
)