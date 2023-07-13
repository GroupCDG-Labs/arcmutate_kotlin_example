package com.example.app;

data class ChainedConstructorDataClass(val name: String, val age: Int) {
    constructor(name: String): this(name, -1) {
        System.out.println("Boo");
    }
}