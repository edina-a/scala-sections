package sectionsnote

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by edinakim on 2016. 9. 7..
  */
class RangeSpec extends FunSuite with Matchers {

  test("range") {
    val ten = Range(1,10)
    println(ten)  //Range(1, 2, 3, 4, 5, 6, 7, 8, 9)

    val ten2 = 1 to 10
    println(ten2) //Range(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    val ten3 = Range(1, 10, 2)
    println(ten3) //Range(1, 3, 5, 7, 9)

    val ten4 = 1 until 10
    println(ten4) //Range(1, 2, 3, 4, 5, 6, 7, 8, 9)

    val ten5 = Range('a','z')
    ten5.foreach(x=>print(x.toChar))
  }

}
