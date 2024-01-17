package com.brjewels.admin.android.models

import com.fasterxml.jackson.annotation.JsonProperty

class SilverModel {

    var id : Int? = null

    @JsonProperty("price")
    var price : Double? = null

    @JsonProperty("quality")
    var quality : String? = null

    @JsonProperty("unit")
    var unit : String? = null
}