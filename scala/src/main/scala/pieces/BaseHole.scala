package pieces

trait BaseHole {

  val diameter: Int

  def getPopulation: Int

  def isEmpty: Boolean

  def harvest: Int

  def seed(numSeeds: Int): Int

}
