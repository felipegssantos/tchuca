package game

import pieces.{Hole, Rumba}

class Board(holes: Seq[Hole]) {

    private def numHoles = holes.length

    private def nextHoleIndex(currentHoleIndex: Int): Int = (currentHoleIndex + 1) % numHoles

    def play(selectedHoleIndex: Int): Int = {
        var seeds: Int = holes(selectedHoleIndex).harvest
        // TODO: use recursion instead
        var index = selectedHoleIndex
        while (seeds > 0) {
            index = nextHoleIndex(index)
            seeds = holes(index).seed(seeds)
        }
        index
    }

    def getHole(index: Int): Hole = holes(index)

    def getStatus: String = {
        holes.zipWithIndex.map{ case (hole, i) => hole.toRepr(i) }.mkString("|")
    }

    def getStatus(currentHoleIndex: Int): String = {
        holes.zipWithIndex.map{ case (hole, i) => hole.toRepr(i, currentHoleIndex == i) }.mkString("|")
    }

    def isRumbaFull: Boolean = (holes.head.getPopulation == 2 * (numHoles - 1))

}

object Board {
    private def setHoles(numHoles: Int): Seq[Hole] = {
        // TODO: move to a companion object
        val rumba = new Rumba(0)
        val commonHoles = for (_ <- 1 until numHoles) yield new Hole(2)
        Seq(rumba) ++ commonHoles
    }

    def apply(numHoles: Int): Board = {
        val holes = setHoles(numHoles)
        new Board(holes)
    }
}