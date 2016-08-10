package sectionsnote

import java.util

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by edinakim on 2016. 8. 10..
  */
class ListSpec extends FunSuite with Matchers {

  test("list") {
    // 불변성, 가변성
    // immutable, mutable

    // 가변성의 단점
    // 동시성에 좋지 않음
    // 동기화가 필요해짐 lock => bottleneck
    // 메모리를 제대로 다 쓰지 못함


    // 자바의 List = <mutable>
    // 스칼라의 List = [immutable]

    val list = List(1,2,3,4)
    val nil = Nil
    val nil2 = List()

    // cons
    val list2 = 1 :: 2 :: 3 :: 4 :: Nil
    println(list2)

    list should be(list2)

    val list3 = list.::(5)
    println(list3)

    val list4 = list :: 5 :: Nil

    val list5 = list :: List(5)

    list4 should be (list5)

    val list6 = 5 :: list
    println(list6)

    val list7 = list ::: list4
    println(list7)
  }

  test("pattern matching") {
    // 패턴 매칭
    // fp

    val list = List(1,2,3,4)

    list match {
      case a :: b :: c :: d :: Nil => println(a,b,c,d)
      case a :: Nil => println("one list")
      case Nil => println("empty")
    }
  }
}


