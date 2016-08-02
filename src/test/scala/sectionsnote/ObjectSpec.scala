package sectionsnote

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by edinakim on 2016. 8. 1..
  */
class ObjectSpec extends FunSuite with Matchers {
  object MyObj {
    def edina = "edina.kim"
  }

  test("objects") {
    println(MyObj.edina)
  }

  // == 자바(레퍼런스 비교), 스칼라(값 비교)
  // equals 자바(값 비교)
  // eq 스칼라(레퍼런스 비교)
  test("object is singleton") {
    val edinanana = MyObj
    val edinakim = edinanana
    edinanana eq edinakim should be (true)
  }

  test("companion object") {
    class Movie(val name:String, val year: Short)

    object Movie {
      def apply(year: Short, name:String):Movie = new Movie(name, year)

      Movie(1992, "강시") // new Movie("강시", 1992)
    }
  }

  test("companion object can access private value") {
    class Person(val name:String)

    object Person {
      def accessPrivateValue(x:Person) = x.name
    }

  }

}
