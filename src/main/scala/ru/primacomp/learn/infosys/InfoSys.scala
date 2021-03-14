package ru.primacomp.learn.infosys

import ru.primacomp.learn.infosys.is03.InfoSys03a
import ru.primacomp.learn.infosys.is04.InfoSys04a

object InfoSys extends App {
  val infoSys03 = new InfoSys03a()
  println(infoSys03.start("( 1 + 2 ) + 4 * 3 "))

  val infoSys04 = new InfoSys04a()
  println(infoSys04.start("( 1 + 2 ) + 4 * 3 "))

}

