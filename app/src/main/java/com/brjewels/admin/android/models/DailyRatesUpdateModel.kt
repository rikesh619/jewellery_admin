package com.brjewels.admin.android.models

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.firebase.firestore.ServerTimestamp


class DailyRatesUpdateModel {

    @JsonProperty("createdAt")
    var createdAt: com.google.firebase.Timestamp? = null

    @JsonProperty("currency")
    var currency : String? = null

    @JsonProperty("date")
    @ServerTimestamp
    var date : com.google.firebase.Timestamp? = null

    @JsonProperty("gold")
    var gold : List<GoldModel>? = listOf()

    @JsonProperty("silver")
    var silver : List<SilverModel>? = listOf()


}


