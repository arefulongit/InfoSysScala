package ru.primacomp.learn.infosys.is03

class MnogoChar(pLen:Int) extends Mnogable [Char, OshibkaProstaya]{
  override val buff: Array[Char] = new Array[Char](pLen)
  override val error: OshibkaProstaya = new OshibkaProstaya()
}
