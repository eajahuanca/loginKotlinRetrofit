package com.miramicodigo.restful_2.model

import com.google.gson.annotations.SerializedName

class LoginBody(
        @field:SerializedName("id")
        var userId: String?,
        var password: String?
)
