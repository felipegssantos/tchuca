package pieces

trait BaseHole {

  val diameter: Int

  def getPopulation: Int

  def isEmpty: Boolean

  def harvest: Int

  def seed(numSeeds: Int): Int

  def toRepr: String = {
    s" ${getPopulation} "
  }

  def toRepr(isCurrent: Boolean): String = {
    if (isCurrent) s" ${getPopulation}*"
    else toRepr
  }

}
