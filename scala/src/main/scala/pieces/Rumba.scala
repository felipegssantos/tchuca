package tchuca.pieces

class Rumba(var population: Int = 0) extends Hole(population) {

    override def seed(numSeeds: Int): Unit = {
        population += 1
        seed - 1
    }
    
}