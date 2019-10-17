package tchuca.pieces

class Rumba(var population: Int = 0) extends Hole(population) {

    override def seed(numSeeds: Int) = {
        population += 1
        seed - 1
    }
    
}