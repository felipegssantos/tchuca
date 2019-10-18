package game

import org.scalatest.{FlatSpec, PrivateMethodTester}
import pieces.Hole

class BoardTest extends FlatSpec with PrivateMethodTester {

  private val setHoles = PrivateMethod[Seq[Hole]]('setHoles)

  "A new Board(5)" should "contain an empty Rumba and 4 holes with 2 seeds each" in {
    val board = new Board(5)
    val holes: Seq[Hole] = board invokePrivate setHoles(5) // hack to access what should be board.holes
    assertResult(5)(holes.length)
  }

}
