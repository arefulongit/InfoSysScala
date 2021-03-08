package ru.primacomp.learn.infosys.is03

trait Mnogable[T, E <: Oshibkable] {
  protected val buff: Array[T]
  protected val error: E

  private var hp: Int = -1;
  private var sp: Int = -1;
  private var buffInit = false

  def isEmpty():Boolean = {
    if(sp < 0){
      true
    } else {
      false
    }
  }

  def hasNext():Boolean = {
    if(hp < sp){
      true
    } else {
      false
    }
  }

  def push(pVal: T): Unit = {
    sp = sp + 1
    buff(sp) = pVal
  }

  def pop(): T = {
    val r = buff(sp)
    sp = sp - 1
    r
  }

  def head(): T = {
    hp = hp + 1
    buff(hp)
  }

  def printBuff():Unit = {
    println(s"-----${this.hashCode()}-----")
    for(x <- buff){
      print(x+",")
    }
    println("-----------")
  }
}
