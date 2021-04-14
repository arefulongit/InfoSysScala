package ru.primacomp.learn.infosys

import org.scalatest._
import ru.primacomp.learn.infosys.is00.InfoSys00a

class InfoSys00Test extends FlatSpec with Matchers {
  val p1 = new InfoSys00a()

  val actList1 = p1.createLevelOneEntityList("abc, def,  gfh")
  val expList1 = List[String]("abc", "def", "gfh")
  actList1 shouldEqual expList1

  val actList2 = p1.createLevelTwoEntityList(List[String]("aa","bb"))
  val expList2 = List[String]("aaaa","aabb","bbaa","bbbb")
  actList2 shouldEqual expList2

}
