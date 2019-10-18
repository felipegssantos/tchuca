package pieces

class Hole(var population: Int) {

    def getPopulation: Int = population

    def isEmpty: Boolean = (population == 0)

    def harvest: Int = {
        val oldPopulation = population
        population = 0
        oldPopulation
    }

    def seed(numSeeds: Int): Int = {
        if (numSeeds == 1 && isEmpty) {
            throw new RuntimeException("Game Over!")
        } else {
            population += 1
            seed - 1
        }
    }

}
