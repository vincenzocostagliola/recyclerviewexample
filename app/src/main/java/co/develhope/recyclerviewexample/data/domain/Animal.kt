package co.develhope.recyclerviewexample.data.domain

data class Animal(
    val name: String,
    val breed: String,
    val age : Int,
    val type: AnimalType
) {
    enum class AnimalType {
        DOG, CAT
    }
}