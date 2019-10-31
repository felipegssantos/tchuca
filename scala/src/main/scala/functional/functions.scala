package functional

object functions {

  def buildBoard(numHoles: Int): Seq[BaseHole] = {
    val rumba = Rumba(0)
    val commonHoles = for (_ <- 1 until numHoles) yield Hole(2)
    Seq(rumba) ++ commonHoles
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

  def seed(board: Board, holeIndex: Int, numSeeds: Int): (Board, Int) = {
    val updatedHoles = board.holes.zipWithIndex.map {
      case (hole, i) if i != holeIndex => hole
      case (Hole(population, _), _) => Hole(population + 1)
      case (Rumba(population, _), _) => Rumba(population + 1)
    }
    (Board(updatedHoles), numSeeds - 1)
  }

  def seedAll(board: Board, holeIndex: Int, numSeeds: Int): (Board, Int) = {
    // TODO: seed cyclically until all seeds are used
    // TODO: return updated board and last index of last seeded hole
  }

  def harvestAndSeedAll(board: Board, holeIndex: Int): (Board, Int) = {
    val (harvestedBoard, seeds) = harvest(board, holeIndex)
    val nextHoleIndex = (holeIndex + 1) % board.holes.length
    seedAll(harvestedBoard, nextHoleIndex, seeds)
  }

}
