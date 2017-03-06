package sectionsnote

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by edinakim on 2017. 3. 3..
  */
class MethodSpec extends FunSuite with Matchers {

  test("max") {
    def max(a:Int, b:Int): Int = {
      if(a > b) a else b
    }

    def foo(input: String): String = {
      input.toString
    }

    // 함수에 리턴타입이 꼭 있어야 할 때?
    // 함수가 public 일 때
    // 타입이 애매모호 할 때
    // 함수가 재귀함수 일 때
    // return 키워드가 있을때
    // 로컬 타입추론
    def factorial(n: Int):Int = {
      if(n <= 0) 1
      else n * factorial(n -1)
    }


  }

}
