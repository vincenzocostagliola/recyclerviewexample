package co.develhope.recyclerviewexample.data.domain

sealed class AnimalItems(val id : Int){

    data class Cat(
        val name: String,
        val breed: String,
        val age: Int
    ) : AnimalItems(CatId)

    data class Dog(
        val name: String,
        val breed: String,
        val age: Int
    ) : AnimalItems(DogId)

    object CatTitle : AnimalItems(CatTileId)
    object DogTitle : AnimalItems(MiceId)

    data class Mice(
        val name: String,
        val breed: String,
        val age: Int
    ) : AnimalItems(5)

    companion object {
        const val CatId = 99
        const val DogId = 2
        const val CatTileId = 3
        const val DogTitleId = 4
        const val MiceId = 5
    }
}

