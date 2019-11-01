package functional

  import scala.annotation.tailrec
  import scala.io.StdIn

object game {

  import functions._
  import GameStatus._

  def main(args: Array[String]): Unit = {

    implicit val board: Board = buildBoard(5)
    printStatus
    val firstHoleIndex = StdIn.readLine("Escolha um buraco para iniciar: ").toInt
    val gameResult = play(firstHoleIndex)
    gameResult match {
      case Won => println("Você ganhou!")
      case Lost => println("Você perdeu!")
    }
  }

  def printStatus(implicit board: Board): Unit = println(board.getStatus)

  def printStatus(currentHoleIndex: Int)(implicit board: Board): Unit = println(board.getStatus(currentHoleIndex))

  @tailrec
  def play(holeIndex: Int)(implicit board: Board): GameStatus = {
    val (updatedBoard, finalHoleIndex) = harvestAndSeedAll(board, holeIndex)
    printStatus(finalHoleIndex)(updatedBoard)
    checkWinningCondition(finalHoleIndex)(updatedBoard) match {
      case Ongoing =>
        val nextHoleIndex = updatedBoard.holes(finalHoleIndex) match {
          case _: Hole => finalHoleIndex
          case _: Rumba => StdIn.readLine("Escolha o próximo buraco: ").toInt
        }
        play(nextHoleIndex)(updatedBoard)
      case default => default
    }
  }

  def checkWinningCondition(currentHoleIndex: Int)(implicit board: Board): GameStatus = {
    if (isRumbaFull(board)) Won
    else if (currentHoleIndex > 0 && board.holes(currentHoleIndex).population == 1) Lost
    else Ongoing
  }

}

object GameStatus extends Enumeration {
  type GameStatus = Value
  val Won, Lost, Ongoing = Value
}