package com.dsc.androidstudyjam.kotlin101

fun main() {
    println("Hello World")

    println("Immutability: var vs val")
    var name: String = "Android"
    name += " Study Jam"
    val version = "101"
//    version = "2" // compilation error
    println("String template $name $version")

    println("Null Safety")
    var a: String = "a"
//    a = null // compilation error
    println(a)

    var b: String? = "b"
    b = null
    println(b)

    // Safe call operator
    println(b?.length)

    // Elvis operator
    val c = b?.length ?: -1
    println(c)

    println("Collections")
    // Immutable list
    val list = listOf(1, 2, 3)
//    val list = listOf<Int>(1, 2, "3") // compilation error
//    list.add(4) // compilation error
    println(list)

    val first = list[0] // or list.first()
    println(first)

    // Mutable list
    val list2 = mutableListOf(1, 2, 3)
    list2.add(4)
    println(list2)

    // Iteration
    for (item in list2) {
        println(item)
    }
    list2.forEach { println(it) }

    val pares = list2.filter { num ->
        num % 2 == 0
    }
    println("Pares $pares")

    // Immutable map
    mapOf(
        1 to "1",
        2 to "2"
    )

    // Mutable map
    val map = mutableMapOf(
        "1" to 1,
        "2" to 2
    )
    map["3"] = 2 // or map.put("3", 2)

    println("Classes and Functions")
    val calculator = Calculator()

    // Named params
    println(calculator.sum(1, 2, c = 3))
    println(calculator.minus(1, 2))
}