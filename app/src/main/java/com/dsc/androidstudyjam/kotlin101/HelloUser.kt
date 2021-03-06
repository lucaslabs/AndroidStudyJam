package com.dsc.androidstudyjam.kotlin101

fun main() {
    println("Please enter your name: ")
    val name = readLine()

    println("Please enter your lastname: ")
    val lastName = readLine()

    val user = User(name, lastName)
    println("Hello ${user.name} ${user.lastName}".toCapitalize())

    println("Your name has ${user.name?.length} letters")

    // Copy with named arguments
    val user2 = user.copy(name = "gastón",  lastName = "saillen")

    println("Hello ${user2.name}".toCapitalize())

//    // Scope function
//    user.name?.let { safeName ->
//        println("Your name has ${safeName.length} letters")
//    }
}