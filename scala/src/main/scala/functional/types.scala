package functional

abstract class BaseHole(val population: Int, val diameter: Int) {

  def toRepr(index: Int): String = {
    s" $index:${population} "
  }

  def toRepr(index: Int, isCurrent: Boolean): String = {
    if (isCurrent) s" $index:${population}*"
    else toRepr(index)
  }

}

case class Hole(override val population: Int, override val diameter: Int = 1) extends BaseHole(population, diameter)

case class Rumba(override val population: Int, override val diameter: Int = 4) extends BaseHole(population, diameter)

case class Board(holes: Seq[BaseHole]) {

  def getStatus: String = {
    holes
      .zipWithIndex
      .map{ case (hole, i) => hole.toRepr(i) }
      .mkString("|")
  }

  def getStatus(currentHoleIndex: Int): String = {
    holes
      .zipWithIndex
      .map{ case (hole, i) => hole.toRepr(i, currentHoleIndex == i) }
      .mkString("|")
  }

}
