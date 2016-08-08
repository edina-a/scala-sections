package sectionsnote

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by edinakim on 2016. 8. 3..
  */
class LambdaSpec extends FunSuite with Matchers {
  test("lambda") {
    // function : 함수의 이름이 없을 수 있다
    // method : class, object 안에 있어야 함

    val f = (x: Int) => x.toString
    val f2 = new Function[Int, String] {
      override def apply(v1: Int): String = v1.toString
    }
  }

  test("function vs method") {
    // method
    def foo(a: String): String = {
      a + a
    }

    // function
    val foo1 = (x: String) => x + x
    val foo2 = new Function1[String, String] {
      override def apply(x: String): String = x + x
    }

  }

}
