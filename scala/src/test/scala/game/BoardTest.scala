package game

import org.scalatest.{FlatSpec, PrivateMethodTester}
import pieces.Hole

class BoardTest extends FlatSpec with PrivateMethodTester {

  private val setHoles = PrivateMethod[Seq[Hole]]('setHoles)
  private val next = PrivateMethod[Int]('nextHoleIndex)

  private val board = Board(5)

  "A new Board(5)" should "contain an empty Rumba and 4 holes with 2 seeds each" in {
    val holes: Seq[Hole] = board invokePrivate setHoles(5) // hack to access what should be board.holes
    assertResult(5)(holes.length)
  }

  it should "cycle through all holes" in {
    val result = (0 to 4).map(board invokePrivate next(_))
    assertResult(Vector(1, 2, 3, 4, 0))(result)
  }

  it should "be able to display the board state" in {
    assertResult(" 0:0 | 1:2 | 2:2 | 3:2 | 4:2 ")(board.getStatus)
  }

  it should "be able to display the board state highlighting the current hole" in {
    assertResult(" 0:0 | 1:2 | 2:2*| 3:2 | 4:2 ")(board.getStatus(2))
  }


}
