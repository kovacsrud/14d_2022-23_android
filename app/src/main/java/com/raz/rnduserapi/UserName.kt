package com.raz.rnduserapi

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserName(
    var title:String,
    var first:String,
    var last:String
):Parcelable{}
