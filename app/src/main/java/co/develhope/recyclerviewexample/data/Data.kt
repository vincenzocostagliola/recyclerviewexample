package co.develhope.recyclerviewexample.data

import co.develhope.recyclerviewexample.data.domain.Animal
import co.develhope.recyclerviewexample.data.domain.Animal.AnimalType.CAT
import co.develhope.recyclerviewexample.data.domain.Animal.AnimalType.DOG

object Data {
    fun getAnimalsList(): List<Animal> = listOf(
        Animal(name = "Marion Carter", breed = "erroribus", age = 4697, type = CAT),
        Animal(name = "Jeff Kelly", breed = "definitiones", age = 7287, type = DOG),
        Animal(name = "Winston Lynn", breed = "brute", age = 7253, type = CAT)
    )

}