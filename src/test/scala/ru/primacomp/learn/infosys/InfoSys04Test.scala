package ru.primacomp.learn.infosys

import org.scalatest._
import ru.primacomp.learn.infosys.is04.InfoSys04a

class InfoSys04Test extends FlatSpec with Matchers {

  val p1 = new InfoSys04a()

  p1.toRPN("( 1 + 2 ) + 4 * 3 ") shouldEqual("12+43*+")
  p1.calc(List[Char]('1','2','+','4','3','*','+')) shouldEqual 15
  new InfoSys04a().start("( 1 + 2 ) + 4 * 3 ") shouldEqual 15
}
