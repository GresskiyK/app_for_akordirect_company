package com.example.workapp

import com.google.gson.annotations.SerializedName

class ServerResponse {
    @SerializedName("model")
    var model: String? = null
    @SerializedName("video1")
    var picture: String? = null
}