package com.raz.rnduserapi

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserPicture(
    var large:String,
    var medium:String,
    var thumbnail:String
):Parcelable{}
