package com.brjewels.admin.android.models

import com.fasterxml.jackson.annotation.JsonProperty

class Users {

    @JsonProperty("first_name")
    var first_name : String? = null

    @JsonProperty("last_name")
    var last_name : String?= null

    @JsonProperty("role")
    var role : String? = null

    @JsonProperty("user_id")
    var user_id : String? = null


}