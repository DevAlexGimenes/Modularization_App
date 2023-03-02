package com.alex.gimenes.apps.domain.features.character_details.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    @SerializedName("id") val id: Int? = 0,
    @SerializedName("name") val name: String? = "None",
    @SerializedName("status") val status: String? = "None",
    @SerializedName("species") val species: String? = "None",
    @SerializedName("image") val image: String? = "None"
) : Parcelable
