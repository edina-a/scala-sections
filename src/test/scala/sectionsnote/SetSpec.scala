package sectionsnote

import org.scalatest.{FunSuite, Matchers}

import scala.collection.immutable.Set

/**
  * Created by edinakim on 2016. 8. 17..
  */
class SetSpec extends FunSuite with Matchers {
  // list 와 set 의 차이
  // set은 중복된 값은 들어가지 않음
  test("set") {
    val list1 = List(1,1,1,1,1)
    val set1 = Set(1,1,1,1,1)

    println(list1) // List(1, 1, 1, 1, 1)
    println(set1)  // Set(1)

    val set2 = set1 + 2
    println(set2)

    val set3 = Set(2,3,4,5)
    val set4 = set1 ++ set3

    println(set4) // Set(5, 1, 2, 3, 4)

    // 집합
    // 교집합
    println(set4.intersect(set2)) // Set(1, 2)

    // 합집합
    val set5 = Set(2,3,4,5)
    println(set5.union(set2)) // Set(5, 1, 2, 3, 4)

    // 차집합
    println(set5.diff(set2))  // Set(3, 4, 5)
    println(set2.diff(set5))  // Set(1)


  }
}
