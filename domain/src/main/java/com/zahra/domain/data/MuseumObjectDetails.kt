package com.zahra.domain.data


data class MuseumObjectDetails(
    val objectID: Int? = null,
    val isHighlight: Boolean? = null,
    val accessionNumber: String? = null,
    val accessionYear: String? = null,
    val isPublicDomain: Boolean? = null,
    val primaryImage: String? = null,
    val primaryImageSmall: String? = null,
    val additionalImages: List<String>? = null,
    val constituents: List<Constituents>? = null,
    val department: String? = null,
    val objectName: String? = null,
    val title: String? = null,
    val culture: String? = null,
    val period: String? = null,
    val dynasty: String? = null,
    val reign: String? = null,
    val portfolio: String? = null,
    val artistRole: String? = null,
    val artistPrefix: String? = null,
    val artistDisplayName: String? = null,
    val artistDisplayBio: String? = null,
    val artistSuffix: String? = null,
    val artistAlphaSort: String? = null,
    val artistNationality: String? = null,
    val artistBeginDate: String? = null,
    val artistEndDate: String? = null,
    val artistGender: String? = null,
    val artistWikidataURL: String? = null,
    val artistULANURL: String? = null,
    val objectDate: String? = null,
    val objectBeginDate: String? = null,
    val objectEndDate: String? = null,
    val medium: String? = null,
    val dimensions: String? = null,
    val measurements: List<Measurements>? = null,
    val creditLine: String? = null,
    val geographyType: String? = null,
    val city: String? = null,
    val state: String? = null,
    val county: String? = null,
    val country: String? = null,
    val region: String? = null,
    val subregion: String? = null,
    val locale: String? = null,
    val locus: String? = null,
    val excavation: String? = null,
    val river: String? = null,
    val classification: String? = null,
    val rightsAndReproduction: String? = null,
    val linkResource: String? = null,
    val metadataDate: String? = null,
    val repository: String? = null,
    val objectURL: String? = null,
    val tags: List<Tags>? = null,
    val objectWikidataURL: String? = null,
    val isTimelineWork: Boolean? = null,
    val GalleryNumber: String? = null
)

data class Constituents(
    val constituentID: String? = null,
    val role: String? = null,
    val name: String? = null,
    val constituentULANURL: String? = null,
    val constituentWikidataURL: String? = null,
    val gender: String? = null
)

data class ElementMeasurements(
    val Height: String? = null,
    val Width: String? = null
)

data class Measurements(
    val elementName: String? = null,
    val elementDescription: String? = null,
    val elementMeasurements: ElementMeasurements? = null
)

data class Tags(
    val term: String? = null,
    val AATURL: String? = null,
    val WikidataURL: String? = null
)


