package ru.primacomp.learn.infosys.is04

class InfoSys04a {

  val digits = List('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
  val opers = List('-', '+', '/', '*')

  def start(pStr: String): Int = {
    calc(
      toRPN(
        getUserInput()))
  }

  def getUserInput():String={
    "( 1 + 2 ) + 4 * 3 "
  }

  def toRPN(pStr:String):List[Char]={
    var r = List[Char]('1','2','3','4')
    r
  }

  def calc(pStr:List[Char])={
    0
  }

}
