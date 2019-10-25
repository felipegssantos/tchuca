package game

import pieces.{Hole, Rumba}

class Board(numHoles: Int) {

    private val holes: Seq[Hole] = setHoles(numHoles)

    private def setHoles(numHoles: Int): Seq[Hole] = {
        // TODO: move to a companion object
        val rumba = new Rumba(0)
        val commonHoles = for (_ <- 1 until numHoles) yield new Hole(2)
        Seq(rumba) ++ commonHoles
    }

    private def nextHoleIndex(currentHoleIndex: Int): Int = (currentHoleIndex + 1) % numHoles

    def play(selectedHoleIndex: Int): Int = {
        var seeds: Int = holes(selectedHoleIndex).harvest
        // TODO: use recursion instead
        var index = selectedHoleIndex
        while (seeds > 0) {
            index = nextHoleIndex(index)
            seeds = holes(index).seed(seeds)
        }
        selectedHoleIndex
    }

    def getHole(index: Int): Hole = holes(index)

    def getStatus: String = {
        holes.map(_.toRepr).mkString("|")
    }

    def getStatus(currentHoleIndex: Int): String = {
        val isCurrent = (0 to numHoles).map(_ == currentHoleIndex)
        holes.zip(isCurrent).map {
            case (hole, current) => hole.toRepr(current)
        }.mkString("|")
    }

    def isRumbaFull: Boolean = (holes.head.getPopulation == 2 * (numHoles - 1))

}
