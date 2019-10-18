package game

import pieces.{Hole, Rumba}

class Board(numHoles: Int) {

    private val holes: Seq[Hole] = setHoles(numHoles)

    private def setHoles(numHoles: Int): Seq[Hole] = {
        // TODO
    }

    private def nextHoleIndex(currentHoleIndex: Int): Int = {
        // TODO
    }

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

    def getHole(index: Int) = holes(index)

    def printStatus: Unit = {
        // TODO
    }

    def printStatus(currentHoleIndex: Int): Unit = {
        // TODO
    }

    def checkWinCondition(currentHoleIndex: Int): String = {
        // TODO: implement it
        // TODO: change return type to something like C++ enum class
    }

}
