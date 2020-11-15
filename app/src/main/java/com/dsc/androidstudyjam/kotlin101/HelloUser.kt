package com.dsc.androidstudyjam.kotlin101

fun main() {
    println("Please enter your name: ")
    val name = readLine()

    println("Please enter your lastname: ")
    val lastName = readLine()

    val user = User(name, lastName)
    println("Hello ${user.name}")

    println("Your name has ${user.name?.length} letters")
//    // Or
//    user.name?.let { safeName ->
//        println("Your name has ${safeName.length} letters")
//    }
}