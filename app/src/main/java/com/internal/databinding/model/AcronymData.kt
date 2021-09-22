package com.internal.databinding.model

import com.squareup.moshi.Json

data class AcronymData(@field:Json(name = "lfs") val acronymDetails: List<AcronymDetails?>)

data class AcronymDetails(@field:Json(name = "lf") val acronym: String?)