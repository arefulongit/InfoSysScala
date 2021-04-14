package ru.primacomp.learn.infosys.is00

class InfoSys00a {
  def start(pStr: String): Unit = {
    createLevelOneEntityList(pStr)
  }

  def createLevelOneEntityList(pStr: String): List[String] = {
    pStr.filter(ch => ch.toInt > 32).split(',').toList
  }

  def createLevelTwoEntityList(pLevelOne: List[String]): List[String] = {
    pLevelOne+pLevelOne
    pLevelOne.map {
      str1 =>
        pLevelOne.map {
          str2 =>
            str1 + str2
        }
    }
  }
}