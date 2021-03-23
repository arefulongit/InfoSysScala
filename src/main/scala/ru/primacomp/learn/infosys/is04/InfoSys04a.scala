package ru.primacomp.learn.infosys.is04

import scala.::
import scala.collection.immutable._
import scala.io.StdIn._

class InfoSys04a {

  final val digits = List('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
  final val opers = List('-', '+', '/', '*')
  final val funcIn = inputString("")
  final val funcOutStr = outputString("")
  final val funcOutInt = outputString(0)

  def start(): Unit = {
    funcOutInt(
      calc(
        toRPN(
          funcIn("Введите выражение")
            .filter(ch => ch != ' ')
            .toList
        )
      )
    )
  }

  def inputString(pPrompt: String): (String => String) = {
    pPrompt => readLine(pPrompt)
  }

  def outputString[A](pMsg: A): (A => Unit) = {
    pMsg => println(pMsg)
  }

  def toRPN(pUserInputStack: List[Char], pRpnStack: List[Char] = Nil, pOperationStack: List[Char] = Nil): List[Char] = {
    funcOutStr(s"toRPN() pUserInputStack:${pUserInputStack} pRpnStack: ${pRpnStack} pOperationStack: ${pOperationStack}")
    //println(s"toRPN() pUserInputStack:${pUserInputStack} pRpnStack: ${pRpnStack} pOperationStack: ${pOperationStack}")
    if (pUserInputStack.isEmpty) {
      return copyFromListToListWhileNotDelimiterOrError(pRpnStack, pOperationStack, '_')
    }
    val head: Char = pUserInputStack.head
    val tail: List[Char] = pUserInputStack.tail
    head match {
      case '(' =>
        toRPN(tail, pRpnStack, pOperationStack :+ head)
      case ')' =>
        toRPN(tail, copyFromListToListWhileNotDelimiterOrError(pRpnStack, pOperationStack, '('), pOperationStack.dropRight(1))
      case x if digits.contains(x) =>
        toRPN(tail, pRpnStack :+ head, pOperationStack)
      case x if opers.contains(x) =>
        toRPN(tail, pRpnStack, pOperationStack :+ head)
    }
  }


  def copyFromListToListWhileNotDelimiterOrError(pList1: List[Char], pList2: List[Char], pDelimiter: Char): List[Char] = {
    funcOutStr(s"listToList() pList1=${pList1} pList2=${pList2}")
    if (pList2.isEmpty) {
      return pList1
    }
    val ch = pList2.last
    ch match {
      case `pDelimiter` => pList1
      case x if digits.contains(x) || opers.contains(x) =>
        copyFromListToListWhileNotDelimiterOrError(pList1.:+(ch), pList2.dropRight(1), pDelimiter)
      case _ => pList1
    }
  }

  def calc(pRpnStack: List[Char], pCalcStack: List[Int] = Nil): Int = {
    funcOutStr(s"calc() pRpnStack=${pRpnStack} pCalcStack=${pCalcStack}")
    if (pRpnStack.isEmpty) {
      return pCalcStack.head
    }
    val head = pRpnStack.head
    val tail = pRpnStack.tail
    head match {
      case x if digits.contains(x) =>
        calc(tail, pCalcStack :+ ("" + x).toInt)
      case x if opers.contains(x) =>
        `x` match {
          case '-' => calc(tail, pCalcStack.dropRight(2) :+ (pCalcStack.head - pCalcStack.tail.head))
          case '+' => calc(tail, pCalcStack.dropRight(2) :+ (pCalcStack.head + pCalcStack.tail.head))
          case '/' => calc(tail, pCalcStack.dropRight(2) :+ (pCalcStack.head / pCalcStack.tail.head))
          case '*' => calc(tail, pCalcStack.dropRight(2) :+ (pCalcStack.head * pCalcStack.tail.head))
        }
    }
  }
}

