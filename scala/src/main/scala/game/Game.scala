package game

import scala.annotation.tailrec
import scala.io.StdIn

object Game {

    import GameStatus._

    def main(args: Array[String]): Unit = {
        // TODO
        implicit val board: Board = new Board(5)
        printStatus
        val firstHoleIndex = StdIn.readLine("Escolha um buraco para iniciar: ").toInt
        val gameResult = play(firstHoleIndex)
        gameResult match {
            case Won => println("Você ganhou!")
            case Lost => println("Você perdeu!")
        }
    }

    def printStatus(implicit board: Board): Unit = println(board.getStatus)

    def printStatus(currentHoleIndex: Int)(implicit board: Board): Unit = println(board.getStatus)

    @tailrec
    def play(holeIndex: Int)(implicit board: Board): GameStatus = {
        val currentHoleIndex = board.play(holeIndex)
        printStatus(currentHoleIndex)
        checkWinningCondition(currentHoleIndex) match {
            case Ongoing =>
                val nextHoleIndex =
                    if (currentHoleIndex > 0) currentHoleIndex
                    else StdIn.readLine("Escolha o próximo buraco: ").toInt
                play(nextHoleIndex)
            case default: GameStatus => default
        }
    }

    def checkWinningCondition(currentHoleIndex: Int)(implicit board: Board): GameStatus = {
        if (board.isRumbaFull) Won
        else if (currentHoleIndex > 0 && board.getHole(currentHoleIndex).getPopulation == 1) Lost
        else Ongoing
    }
}

object GameStatus extends Enumeration {
    type GameStatus = Value
    val Won, Lost, Ongoing = Value
}
