package com.example.practicaexamen

class Persona {
    var numero : Int
    var nombre : String
    var apellido : String
    var altura : Double
    var edad : Int

    constructor() {
        numero = 0
        nombre = ""
        apellido = ""
        altura = 0.0
        edad = 0
    }

    constructor(numero: Int, nombre: String, apellido: String, altura: Double, edad: Int) {
        this.numero = numero
        this.nombre = nombre
        this.apellido = apellido
        this.altura = altura
        this.edad = edad
    }
}