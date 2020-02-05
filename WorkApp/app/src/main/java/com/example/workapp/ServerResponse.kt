package com.example.workapp

import com.google.gson.annotations.SerializedName

class ServerResponse {
    @SerializedName("model")
    var model: String? = null
    @SerializedName("video1")
    var picture: String? = null
    @SerializedName("machinelocation")
    var location: String? = null
    @SerializedName("tablerectangleload")
    var tableSize: String? = null
    @SerializedName("axiscount")
    var axiscount: String? = null
    @SerializedName("x")
    var x: String? = null
    @SerializedName("y")
    var y: String? = null
    @SerializedName("z")
    var z: String? = null
}