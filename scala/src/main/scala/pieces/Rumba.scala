package pieces

class Rumba(var rumbaPopulation: Int = 0) extends Hole(rumbaPopulation) {

    override def seed(numSeeds: Int): Int = {
        population += 1
        numSeeds - 1
    }
    
}