package ru.primacomp.learn.infosys

import ru.primacomp.learn.infosys.is00.InfoSys00a
import ru.primacomp.learn.infosys.is03.InfoSys03a
import ru.primacomp.learn.infosys.is04.InfoSys04a

object InfoSys extends App {
  val infoSys00 = new InfoSys00a()
  infoSys00.start("User, Account, Role, Organization")

  //val infoSys03 = new InfoSys03a()
  //println(infoSys03.start("( 1 + 2 ) + 4 * 3 "))

  //val infoSys04 = new InfoSys04a()
  //infoSys04.start()
}

