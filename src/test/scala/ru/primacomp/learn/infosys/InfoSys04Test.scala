package ru.primacomp.learn.infosys

import org.scalatest._
import ru.primacomp.learn.infosys.is04.InfoSys04a

class InfoSys04Test extends FlatSpec with Matchers {

  val p1 = new InfoSys04a()

  val inList1, memList1:List[Char] = List('(','1','2')
  val expList1:List[Char] = List ('2','1')
  val actList1:List[Char] = p1.copyFromListToListWhileNotDelimiterOrError(Nil, inList1,'(')
  actList1 shouldEqual expList1
  inList1 shouldEqual memList1

  val inList2, memList2:List[Char] = List('*','1','2')
  val expList2:List[Char] = List[Char]('2','1','*')
  val actList2:List[Char] = p1.copyFromListToListWhileNotDelimiterOrError(Nil, inList2,'(')
  actList2 shouldEqual expList2
  inList2 shouldEqual  memList2

  val inList3, memList3:List[Char] = List('(','1','+','2',')')
  val expList3:List[Char] = List[Char]('1','2','+')
  val actList3:List[Char] = p1.toRPN(inList3, Nil, Nil)
  actList3 shouldEqual expList3
  inList3 shouldEqual  memList3

  val inList4, memList4:List[Char] = List('(','1','+','2',')','+','4','*','3')
  val expList4:List[Char] = List[Char]('1','2','+','4','3','*','+')
  val actList4:List[Char] = p1.toRPN(inList3, Nil, Nil)
  actList3 shouldEqual expList3
  inList3 shouldEqual  memList3

  val inList5, memList5:List[Char] = List('1','2','+','4','3','*','+')
  val expInt5:Int = 15
  val actInt5:Int = p1.calc(inList5)
  actInt5 shouldEqual expInt5
  inList5 shouldEqual memList5
}
