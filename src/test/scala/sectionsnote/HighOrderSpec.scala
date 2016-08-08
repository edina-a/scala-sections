package sectionsnote

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by edinakim on 2016. 8. 8..
  */
class HighOrderSpec extends FunSuite with Matchers {
  test("high order") {

    // int => String function을 인자로 받는다
    def myFirstHighOrder(value: Int)(f: Int => String): String = {
      f(value)
    }

    println(myFirstHighOrder(10)(x => x.toString))

    // 1. 고차함수 API를 잘 활용해보자
    // map, fold, reduce, flatMap
    val list = List(1,2,3)
    println(list.map(_ + 10))


    // 2. reduce를 이용해서 전체 합을 구하세요
    println(list.reduce(_ + _))
    list.reduce((x,y) => x+y)
    list.sum

    // 3. fold를 이용해서 전체 곱을 구하세요
    println(list.fold(1)((x,y) => x*y))
    list.fold(1)(_*_)


    // 4. flatMap
    println(list.flatMap(x=>List(x*11, x*11+1)))
  }
}
