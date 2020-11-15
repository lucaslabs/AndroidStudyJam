package com.dsc.androidstudyjam.kotlin101

class Calculator {
    // Default values
    fun sum(a: Int, b: Int, c: Int = 0): Int {
        return a + b + c
    }

    fun minus(a: Int, b: Int) = a.minus(b)
}