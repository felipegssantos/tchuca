package pieces

import org.scalatest.FlatSpec

class HoleTest extends FlatSpec {

  "A Hole(2)" should "return the integer 2 and end up with zero population when harvested" in {
    val hole = new Hole(2)
    val seeds = hole.harvest
    assert(hole.getPopulation == 0)
    assertResult(2)(seeds)
  }

  it should "return false when isEmpty is invoked" in {
    val hole = new Hole(2)
    assert(!hole.isEmpty)
  }

  "A Hole(0)" should "throw a RuntimeException when 1 seed is put into it" in {
    val hole = new Hole(0)
    assertThrows[RuntimeException](hole.seed(1))
  }

  it should "return true when isEmpty is invoked" in {
    val hole = new Hole(0)
    assert(hole.isEmpty)
  }

}
