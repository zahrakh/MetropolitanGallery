package com.zahra.data.remotedata.dto

import com.google.gson.annotations.SerializedName

data class ObjectsDetailsDto(
    @SerializedName("objectID"              ) val objectID              : Int?                    = null,
    @SerializedName("isHighlight"           ) val isHighlight           : Boolean?                = null,
    @SerializedName("accessionNumber"       ) val accessionNumber       : String?                 = null,
    @SerializedName("accessionYear"         ) val accessionYear         : String?                 = null,
    @SerializedName("isPublicDomain"        ) val isPublicDomain        : Boolean?                = null,
    @SerializedName("primaryImage"          ) val primaryImage          : String?                 = null,
    @SerializedName("primaryImageSmall"     ) val primaryImageSmall     : String?                 = null,
    @SerializedName("additionalImages"      ) val additionalImages      : ArrayList<String>?      = null,
    @SerializedName("constituents"          ) val constituents          : ArrayList<Constituents>?= null,
    @SerializedName("department"            ) val department            : String?                 = null,
    @SerializedName("objectName"            ) val objectName            : String?                 = null,
    @SerializedName("title"                 ) val title                 : String?                 = null,
    @SerializedName("culture"               ) val culture               : String?                 = null,
    @SerializedName("period"                ) val period                : String?                 = null,
    @SerializedName("dynasty"               ) val dynasty               : String?                 = null,
    @SerializedName("reign"                 ) val reign                 : String?                 = null,
    @SerializedName("portfolio"             ) val portfolio             : String?                 = null,
    @SerializedName("artistRole"            ) val artistRole            : String?                 = null,
    @SerializedName("artistPrefix"          ) val artistPrefix          : String?                 = null,
    @SerializedName("artistDisplayName"     ) val artistDisplayName     : String?                 = null,
    @SerializedName("artistDisplayBio"      ) val artistDisplayBio      : String?                 = null,
    @SerializedName("artistSuffix"          ) val artistSuffix          : String?                 = null,
    @SerializedName("artistAlphaSort"       ) val artistAlphaSort       : String?                 = null,
    @SerializedName("artistNationality"     ) val artistNationality     : String?                 = null,
    @SerializedName("artistBeginDate"       ) val artistBeginDate       : String?                 = null,
    @SerializedName("artistEndDate"         ) val artistEndDate         : String?                 = null,
    @SerializedName("artistGender"          ) val artistGender          : String?                 = null,
    @SerializedName("artistWikidata_URL"    ) val artistWikidataURL     : String?                 = null,
    @SerializedName("artistULAN_URL"        ) val artistULANURL         : String?                 = null,
    @SerializedName("objectDate"            ) val objectDate            : String?                 = null,
    @SerializedName("objectBeginDate"       ) val objectBeginDate       : Int?                    = null,
    @SerializedName("objectEndDate"         ) val objectEndDate         : Int?                    = null,
    @SerializedName("medium"                ) val medium                : String?                 = null,
    @SerializedName("dimensions"            ) val dimensions            : String?                 = null,
    @SerializedName("measurements"          ) val measurements          : ArrayList<Measurements>?= null,
    @SerializedName("creditLine"            ) val creditLine            : String?                 = null,
    @SerializedName("geographyType"         ) val geographyType         : String?                 = null,
    @SerializedName("city"                  ) val city                  : String?                 = null,
    @SerializedName("state"                 ) val state                 : String?                 = null,
    @SerializedName("county"                ) val county                : String?                 = null,
    @SerializedName("country"               ) val country               : String?                 = null,
    @SerializedName("region"                ) val region                : String?                 = null,
    @SerializedName("subregion"             ) val subregion             : String?                 = null,
    @SerializedName("locale"                ) val locale                : String?                 = null,
    @SerializedName("locus"                 ) val locus                 : String?                 = null,
    @SerializedName("excavation"            ) val excavation            : String?                 = null,
    @SerializedName("river"                 ) val river                 : String?                 = null,
    @SerializedName("classification"        ) val classification        : String?                 = null,
    @SerializedName("rightsAndReproduction" ) val rightsAndReproduction : String?                 = null,
    @SerializedName("linkResource"          ) val linkResource          : String?                 = null,
    @SerializedName("metadataDate"          ) val metadataDate          : String?                 = null,
    @SerializedName("repository"            ) val repository            : String?                 = null,
    @SerializedName("objectURL"             ) val objectURL             : String?                 = null,
    @SerializedName("tags"                  ) val tags                  : ArrayList<Tags>?        = null,
    @SerializedName("objectWikidata_URL"    ) val objectWikidataURL     : String?                 = null,
    @SerializedName("isTimelineWork"        ) val isTimelineWork        : Boolean?                = null,
    @SerializedName("GalleryNumber"         ) val GalleryNumber         : String?                 = null
)

data class Constituents (
    @SerializedName("constituentID"           ) val constituentID          : Int?    = null,
    @SerializedName("role"                    ) val role                   : String? = null,
    @SerializedName("name"                    ) val name                   : String? = null,
    @SerializedName("constituentULAN_URL"     ) val constituentULANURL     : String? = null,
    @SerializedName("constituentWikidata_URL" ) val constituentWikidataURL : String? = null,
    @SerializedName("gender"                  ) val gender                 : String? = null
)

data class ElementMeasurements (
    @SerializedName("Height" ) val Height : Double? = null,
    @SerializedName("Width"  ) val Width  : Int?    = null
)

data class Measurements (
    @SerializedName("elementName"         ) val elementName         : String?              = null,
    @SerializedName("elementDescription"  ) val elementDescription  : String?              = null,
    @SerializedName("elementMeasurements" ) val elementMeasurements : ElementMeasurements? = null
)

data class Tags (
    @SerializedName("term"         ) val term        : String? = null,
    @SerializedName("AAT_URL"      ) val AATURL      : String? = null,
    @SerializedName("Wikidata_URL" ) val WikidataURL : String? = null
)


