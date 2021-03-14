package ru.primacomp.learn.infosys.is04

class InfoSys04a {

  val digits = List('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
  val opers = List('-', '+', '/', '*')

  def start(pStr: String): Int = {

    for(c <- pStr if digits.contains(c) || opers.contains(c))yield{
      println(c)

    }
    42

  }


}
