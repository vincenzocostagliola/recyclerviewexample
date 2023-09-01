package co.develhope.recyclerviewexample.data.domain

sealed class AnimalItems(){

    data class Cat(
        val name: String,
        val breed: String,
        val age : Int
    ) : AnimalItems()
    
    data class Dog(
        val name: String,
        val breed: String,
        val age : Int
    ) : AnimalItems()

    object CatTitle :  AnimalItems()
    object DogTitle : AnimalItems()
}