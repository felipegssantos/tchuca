package pieces

class Hole(private var population: Int) extends BaseHole {

    val diameter = 1

    def getPopulation: Int = population

    def isEmpty: Boolean = (population == 0)

    def harvest: Int = {
        val oldPopulation = population
        population = 0
        oldPopulation
    }

    def seed(numSeeds: Int): Int = {
        population += 1
        numSeeds - 1
    }

}

object Hole {

    def unapply(h: Hole): Option[(Int, Int)] = Some(h.population, h.diameter)

}
