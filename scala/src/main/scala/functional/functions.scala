package functional

import scala.annotation.tailrec

object functions {

  def buildBoard(numHoles: Int): Board = {
    val rumba = Rumba(0)
    val commonHoles = for (_ <- 1 until numHoles) yield Hole(2)
    Board(Seq(rumba) ++ commonHoles)
  }

  def harvest(board: Board, holeIndex: Int): (Board, Int) = {
    val seeds: Int = board.holes(holeIndex).population
    val updatedHoles = board.holes.zipWithIndex.map {
      case (hole, i) if i != holeIndex => hole
      case (_: Hole, _) => Hole(0)
      case (_: Rumba, _) => Rumba(0)
    }
    (Board(updatedHoles), seeds)
  }

  def seed(board: Board, holeIndex: Int, numSeeds: Int): Board = {
    val updatedHoles = board.holes.zipWithIndex.map {
      case (hole, i) if i != holeIndex => hole
      case (Hole(population, diameter), _) => Hole(population + 1, diameter)
      case (Rumba(population, diameter), _) => Rumba(population + 1, diameter)
    }
    Board(updatedHoles)
  }

  def getNextHoleIndex(board: Board, holeIndex: Int): Int = (holeIndex + 1) % board.holes.length

  @tailrec
  def seedAll(board: Board, holeIndex: Int, numSeeds: Int): (Board, Int) = {
    val updatedBoard = seed(board, holeIndex, numSeeds)
    if (numSeeds > 1) {
      val nextHoleIndex = getNextHoleIndex(board, holeIndex)
      seedAll(updatedBoard, nextHoleIndex, numSeeds - 1)
    } else if (numSeeds > 0) {
      (updatedBoard, holeIndex)
    } else {
      throw new RuntimeException(s"Can only seed for numSeeds > 0; found numSeeds = $numSeeds")
    }
  }

  def harvestAndSeedAll(board: Board, holeIndex: Int): (Board, Int) = {
    // TODO: try to use more explicit function composition
    val (harvestedBoard, seeds) = harvest(board, holeIndex)
    val nextHoleIndex = getNextHoleIndex(board, holeIndex)
    seedAll(harvestedBoard, nextHoleIndex, seeds)
  }

  def isRumbaFull(board: Board): Boolean = {
    board
      .holes
      .forall {
        case hole: Hole => hole.population == 0
        case rumba: Rumba => rumba.population > 0
      }
  }

}
