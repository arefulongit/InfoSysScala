package ru.primacomp.learn.infosys

import org.scalatest._
import ru.primacomp.learn.infosys.is02.InfoSys02a

class InfoSys02Test extends FlatSpec with Matchers {
  val p1 = new InfoSys02a()

  p1.start() shouldEqual 15
}
