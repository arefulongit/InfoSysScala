package ru.primacomp.learn.infosys.is03

class OshibkaProstaya() extends Oshibkable {
  def alert(pMsg:String):Unit = {
    throw new Exception(pMsg)
  }
}
