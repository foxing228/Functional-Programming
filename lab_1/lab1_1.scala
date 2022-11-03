package lab_1

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer
import scala.io.StdIn

object lab1_1 {
  def main(args: Array[String]): Unit = {
    println("Author: Dmytro Prokhorchuk")
    println("Variant: 14, task 1")

    println("input b: ")
    val b = StdIn.readInt()

    println("input p: ")
    val p = StdIn.readInt()

    println("input m: ")
    val m = StdIn.readInt()

    val result = calcExp(b, p, m)
    println(result)
  }

  def calcPow(b: Int, p: Int): Int = {
    var cou = 0
    def power(b: Int, p: Int): Int = p match {
      case 0 => 1;
      case 1 => b
      case Even(p) => {
        cou = cou + 1
        power(b, p/2) * power(b, p/2)
      }
      case Odd(p) => {
        cou = cou + 1
        b * power(b, p - 1)
      }
    }
    var res = power(b, p)
    println(s" b*p = $res")
    println(s"depth or recursion: $cou")
    res
  }

  def calcExp(b: Int, p: Int, m: Int): Int = {
    val pow = calcPow(b, p)
    pow % m
  }

}

object Even {
  def unapply(x: Int) = if (x % 2 == 0) Some(x) else None
}

object Odd {
  def unapply(x: Int) = if (x % 2 == 1) Some(x) else None
}