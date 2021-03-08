package ru.primacomp.learn.infosys

import org.scalatest._
import ru.primacomp.learn.infosys.is03.{InfoSys03a, MnogoInt}

class InfoSys03Test extends FlatSpec with Matchers {

  val p1 = new MnogoInt(3)
  p1.push(10)
  p1.push(20)
  p1.push(30)
  p1.pop() shouldEqual 30
  p1.pop() shouldEqual 20
  p1.pop() shouldEqual 10

  p1.push(10)
  p1.push(20)
  p1.push(30)
  p1.head() shouldEqual 10
  p1.head() shouldEqual 20
  p1.head() shouldEqual 30

  val p2 = new MnogoInt(3)
  p2.push(2)
  p2.push(3)
  p2.oper('-')
  p2.pop() shouldEqual(1)

  p2.push(3)
  p2.push(2)
  p2.oper('+')
  p2.pop() shouldEqual(5)

  p2.push(5)
  p2.push(10)
  p2.oper('/')
  p2.pop() shouldEqual(2)

  p2.push(3)
  p2.push(2)
  p2.oper('*')
  p2.pop() shouldEqual(6)

  val p3 = new MnogoInt(3)
  p3.isEmpty() shouldEqual true
  p3.hasNext() shouldEqual false
  p3.push(1)
  p3.isEmpty() shouldEqual false
  p3.hasNext() shouldEqual true
  p3.head() shouldEqual 1
  p3.hasNext() shouldEqual false
  p3.pop() shouldEqual 1
  p3.isEmpty() shouldEqual true

  new InfoSys03a().start("( 1 + 2 ) + 4 * 3 ") shouldEqual 15
}
