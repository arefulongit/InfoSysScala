package ru.primacomp.learn.infosys.is02

class InfoSys02a {

  def start():Int={
    0
  }

  /*
  def start(def pStr){

    def stkOp = createStack(100)
    def stkDg = createStack(100)
    def stkRn = createStack(100)

    //println pStr

    for(def i=0; i < pStr.length(); i++){
      def curr = pStr[i]
      //println "-= ${curr} =-"

      if (digits.contains(curr)){
        push(stkDg, curr)
      } else if (opers.contains(curr)){
        push(stkOp, curr)
      } else if (curr == '('){
        push(stkOp, curr)
      } else if (curr == ')'){
          while( sp(stkOp) > -1){
            def op = pop(stkOp)
            if(op == '('){
              break
            }
            push(stkDg,op)
          }
        }
    }
    while( sp(stkOp) > -1){
      def op = pop(stkOp)
      push(stkDg,op)
    }
    printStack(stkDg,"stkDg")

    while( hp(stkDg) <= sp(stkDg)){
      def curr = head(stkDg)
      if(digits.contains(curr)){
        println curr
        push(stkRn, 0+curr)
      } else {
        oper(stkRn,curr)
      }
      //printStack(stkRn,"stkRn")
    }

    //printStack(stkRn,"stkRn")
    println(pop(stkRn) as int)
  }

  def createStack(def pLen){
    def r = new Stack()
    r.hp = -1
    r.sp = r.hp
    r.stack = new char[pLen]
    return r
  }

  def push(def pSt, def pVal){
    pSt.sp = pSt.sp + 1
    pSt.stack[pSt.sp] = pVal as char
    switch(pSt.sp){
      case -1: pSt.hp = -1
      case 0: pSt.hp = 0
    }
  }

  def pop(def pSt){
    def r = pSt.stack[pSt.sp]
    pSt.sp = pSt.sp - 1
    if(pSt.sp < -1) {
      throw new Exception("Error: stack is empty")
    }
    return r as char
  }

  def head(def pSt){
    def r = pSt.stack[pSt.hp]
    pSt.hp = pSt.hp + 1
    if(pSt.hp > pSt.sp + 1){
      throw new Exception("Error: head after tail");
    }
    return r
  }

  def sp(def pSt){
    return pSt.sp
  }

  def hp(def pSt){
    return pSt.hp
  }

  def oper(def pSt,  def pOp){
    def r=0
    def a=pop(pSt) as short
    def b=pop(pSt) as short
    switch(pOp){
      case '-': r=a-b
      break
      case '+': r=a+b
      break
      case '/': r=a/b
      break
      case '*': r=a*b
      break
    }
    print "r=${r}"
    push(pSt,r)
  }

  /* Печатаем стэк по преданным параметрам х*/
  def printStack(def pSt,def pName){
    println "${pName}"
    println "------< ${pSt.sp} >-------"
    for(def i=0; i <= pSt.sp; i++){
      println "[${i}]=${pSt.stack[i]}"
    }
    println "----------------------"
  }

   */

}
