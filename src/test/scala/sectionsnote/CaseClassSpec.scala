package sectionsnote

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by edinakim on 2016. 8. 29..
  */
class CaseClassSpec extends FunSuite with Matchers{

  test("case class") {
    // 클래스 종류 중 1개
  }

  test("왜 어디에 쓰이나?") {
    case class Foo(a: Int, b: Boolean)
    val foo = Foo(1, false)
    foo.a
    foo.b
    println(foo)
    // new를 쓰지 않아도 된다

    // 값 비교를 잘한다
    val foo1 = Foo(1, false)
    val foo2 = Foo(2, false)

    assert(foo1 == foo1)
    assert(foo != foo2)

    // case class는 상속이 안된다

    // 불변 속성을 가진다
    val foo3 = foo.copy(a=10, b=true)
    println(foo)
    println(foo3)

    // val(final), var
    var f = foo
    f = foo1

    // case class vs class
    case class Bar(a: Int, b: Int) {
      def sum() = a + b
    }

    val bar = Bar(10, 20)
    println(bar.sum())

    class Bar1(val a: Int, var b:Int) {
      def sum() = a + b
    }

    var bar1 = new Bar1(10, 20)
    println(bar1.sum())
  }

}
