package ru.primacomp.learn.infosys.is03

class InfoSys03a() {
  val digits = List('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
  val opers = List('-', '+', '/', '*')

  def start(pStr: String): Int = {
    val stkOp = new MnogoChar(20)
    val stkDg = new MnogoChar(20)
    val stkRn = new MnogoInt(20)

    for(curr <- pStr){
      print(curr)
      if(digits.contains(curr)){
        stkDg.push(curr)
      } else if(opers.contains(curr) || curr == '('){
        stkOp.push(curr)
      } else if (curr == ')') {
        var op: Char = '_'
        while (!stkOp.isEmpty() || op != '(') {
          op = stkOp.pop()
          if(op != '('){
            stkDg.push(op)
          }
        }
      }
    }
    println()

    while(!stkOp.isEmpty()){
      stkDg.push(stkOp.pop())
    }

    stkDg.printBuff()

    while(stkDg.hasNext()){
      val curr = stkDg.head()
      if(digits.contains(curr)){
        println(s"${curr} => ${curr.toInt}")
        stkRn.push((""+curr).toInt)
      } else {
        stkRn.oper(curr)
      }
    }
    stkRn.printBuff()
    stkRn.pop()
  }
}
