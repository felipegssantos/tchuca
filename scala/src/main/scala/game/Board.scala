package tchuca.game

import tchuca.pieces.{Hole, Rumba}

class Board(numHoles: Int) {

    private val holes: Seq[Hole] = setHoles(numHoles)

    private def setHoles(numHoles: Int): Seq[Hole] = {
        // TODO
    }

    private def nextHoleIndex(currentHoleIndex: Int): Int = {
        // TODO
    }

    def play(selectedHoleIndex: Int) = {
        // TODO
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
