package sectionsnote

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by edinakim on 2016. 8. 1..
  */

// 오브젝트는?
// 함수를 포함할수 있음
// companion object (같은 이름의 클래스와 서로 private 멤버에 접근 가능)
// 싱글톤 객체, 패턴
// class 는 new 를 써야하지만 object는 new 필요 없음
// 자바의 main 메소드를 가짐. (class 에 main 을 만들면 이름만 main일뿐 처음 실행되진 않음)
// constructor 를 가질 수 없음
class Foo(a:Int) {
  private def bar: Int = 10
  Foo.bar2
}

object Foo {
  private def bar2: Int = 10
  val a = new Foo(10)
  a.bar
}

object HelloWorld {
  // static (object 안에 메소드는 모두 static)
  def main(args: Array[String]): Unit = {
    println("hello world")
  }
}

object HelloWorld2 extends App {
  println("Hello World")
}

class ObjectSpec extends FunSuite with Matchers {
  test("private") {
    val a = new Foo(10)
    val b = Foo // new 없이 사용 가능
  }

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
