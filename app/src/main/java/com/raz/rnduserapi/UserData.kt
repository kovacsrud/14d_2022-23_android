package com.raz.rnduserapi

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserData(
    var gender:String,
    var email:String,
    var name:UserName,
    var phone:String,
    var cell:String,
    var picture:UserPicture
):Parcelable{}
