package functional

abstract case class BaseHole(population: Int, diameter: Int)

case class Hole(override val population: Int, override val diameter: Int = 1) extends BaseHole(population, diameter)

case class Rumba(override val population: Int, override val diameter: Int = 1) extends BaseHole(population, diameter)

case class Board(holes: Seq[BaseHole])
