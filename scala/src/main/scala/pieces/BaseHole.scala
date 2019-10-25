package pieces

trait BaseHole {

  val diameter: Int

  def getPopulation: Int

  def isEmpty: Boolean

  def harvest: Int

  def seed(numSeeds: Int): Int

  def toRepr(index: Int): String = {
    s" $index:${getPopulation} "
  }

  def toRepr(index: Int, isCurrent: Boolean): String = {
    if (isCurrent) s" $index:${getPopulation}*"
    else toRepr(index)
  }

}
