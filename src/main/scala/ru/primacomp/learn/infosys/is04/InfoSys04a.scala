package ru.primacomp.learn.infosys.is04

import scala.::
import scala.collection.immutable._
import scala.io.StdIn._

class InfoSys04a {

  final val digits = List('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
  final val opers = List('-', '+', '/', '*')

  def start(): Int = {

    val getUserInput = () => {
      readLine("Введите выражение:")
    }

    calc(
      toRPN(
        getUserInput()
          .filter(ch => ch != ' ')
          .toList
      )
    )
  }

  def toRPN(pUserInputStack: List[Char], pRpnStack: List[Char] = Nil, pOperationStack: List[Char] = Nil): List[Char] = {
    val head: Char = pUserInputStack.head
    val tail: List[Char] = pUserInputStack.tail
    println(s"n4() ch(pStr[0]):${head} pStr:${pUserInputStack} pStkDg: ${pRpnStack} pStkOp: ${pOperationStack}")
    if (pUserInputStack.length > 1) {
      head match {
        case '(' =>
          toRPN(tail, pRpnStack, pOperationStack :+ head)
        case ')' =>
          toRPN(tail, copyFromListToListWhileNotDelimiterOrError(pRpnStack, pOperationStack, '('), pOperationStack)
        case x if digits.contains(x) =>
          toRPN(tail, pRpnStack :+ head, pOperationStack)
        case x if opers.contains(x) =>
          toRPN(tail, pRpnStack, pOperationStack :+ head)
      }
    } else {
      copyFromListToListWhileNotDelimiterOrError(pRpnStack, pOperationStack, '_')
    }
  }


  def copyFromListToListWhileNotDelimiterOrError(pList1: List[Char], pList2: List[Char], pDelimiter: Char): List[Char] = {
    println(s"listToList() 1 pList1=${pList1} pList2=${pList2}")
    if (pList2.length > 0) {
      val ch = pList2.last
      println(s"listToList() 2 ch=${ch} pList1=${pList1} pList2=${pList2}")
      ch match {
        //case `pDelimiter` => pList1
        case x if digits.contains(x) || opers.contains(x) =>
          copyFromListToListWhileNotDelimiterOrError(pList1.:+(ch), pList2.dropRight(1), pDelimiter)
        case _ => pList1
      }
    } else {
      pList1
    }
  }

  def calc(pRpnStack: List[Char], pCalcStack: List[Int] = Nil): Int = {
    println(s"listToList() 3 pRpnStack=${pRpnStack} pCalcStack=${pCalcStack}")

    if (!pRpnStack.isEmpty) {
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
    else {
      pCalcStack.head
    }
  }
}

