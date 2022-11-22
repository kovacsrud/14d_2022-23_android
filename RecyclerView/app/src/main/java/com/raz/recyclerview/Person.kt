package com.raz.recyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    var vezeteknev:String,
    var keresztnev:String,
    var szuletesiev:Int
):Parcelable{}
