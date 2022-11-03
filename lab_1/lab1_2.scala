package lab_1

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer
import scala.io.StdIn

object lab1_2 {
  def main(args: Array[String]): Unit = {
    println("Author: Dmytro Prokhorchuk")
    println("Variant: 14, task 2")

    println("input n: ")
    val n = StdIn.readInt()
    val nList = (0 to n).toList.sortBy(_-n)(Ordering[Int].reverse)
    println("input array: ")
    nList foreach println

    val oddNums = calcOddNums(nList)
    println("odd nums:")
    oddNums foreach println
  }

  def calcOddNums(list: List[Int]): List[Int] = {
  val odds = new ListBuffer[Int]
    @tailrec
    def calcOddNumsR(list: List[Int]): Unit = {
      if (list.nonEmpty) {
        val head = list.head
        if (head % 2 == 0) {
          odds.addOne(head)
        }
        calcOddNumsR(list.slice(1, list.size))
      }
    }
    calcOddNumsR(list)
    odds.toList
  }
}

//4  3

