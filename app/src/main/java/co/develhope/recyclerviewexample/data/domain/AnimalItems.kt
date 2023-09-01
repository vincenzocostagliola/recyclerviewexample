package co.develhope.recyclerviewexample.data.domain

sealed class AnimalItems(val id : Int){

    data class Cat(
        val name: String,
        val breed: String,
        val age : Int
    ) : AnimalItems(1)
    
    data class Dog(
        val name: String,
        val breed: String,
        val age : Int
    ) : AnimalItems(2)

    object CatTitle :  AnimalItems(3)
    object DogTitle : AnimalItems(4)

    data class Mice(
        val name: String,
        val breed: String,
        val age : Int
    ) : AnimalItems(5)
}