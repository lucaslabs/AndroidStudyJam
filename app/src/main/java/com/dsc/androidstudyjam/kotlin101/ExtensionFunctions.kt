package com.dsc.androidstudyjam.kotlin101

fun emptyString() = ""

fun String.toCapitalize(): String {
    val words = this.split(" ").toMutableList()
    var output = emptyString()
    words.forEach { output += "${it.capitalize()} ${emptyString()}" }
    return output
}