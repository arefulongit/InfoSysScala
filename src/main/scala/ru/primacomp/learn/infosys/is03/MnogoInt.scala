package ru.primacomp.learn.infosys.is03

class MnogoInt(pLen:Int) extends Mnogable[Int, OshibkaProstaya]{
  override val buff: Array[Int] = new Array[Int](pLen)
  override val error  = new OshibkaProstaya()

  def  oper(pOp:Char): Unit ={
    pOp match{
      case '-' => push(pop()-pop())
      case '+' => push(pop()+pop())
      case '/' => push(pop()/pop())
      case '*' => push(pop()*pop())
    }
  }
}
