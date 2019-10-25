package pieces

import org.scalatest.FlatSpec

class RumbaTest extends FlatSpec {

  "A Rumba(2)" should "return the integer 2 and end up with zero population when harvested" in {
    val rumba = new Rumba(2)
    val seeds = rumba.harvest
    assert(rumba.getPopulation == 0)
    assertResult(2)(seeds)
  }

  it should "return false when isEmpty is invoked" in {
    val rumba = new Rumba(2)
    assert(!rumba.isEmpty)
  }

  it should "return true when isEmpty is invoked" in {
    val rumba = new Rumba(0)
    assert(rumba.isEmpty)
  }

}
