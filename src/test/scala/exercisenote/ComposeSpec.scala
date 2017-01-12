package exercisenote

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by edinakim on 2017. 1. 12..
  */
class ComposeSpec extends FunSuite with Matchers {

  test("compose") {
    def foo(a: Int):String = a.toString
    def bar(b: String):Long = b.toLong

    def barComposedWithFoo(a: Int): Long = bar(foo(a))

    // compose 와 andThen은 같은 일을 하지만 합성되는 순서가 다르다
    def compose[A,B,C](f: B => C, g: A => B): A => C = x => f(g(x))
    def andThen[A,B,C](foo: A => B, bar: B => C): A => C = x => bar(foo(x))

    // 함수의 합성의 일반화
    compose(bar, foo)

    barComposedWithFoo(100) shouldBe compose(bar, foo)(100)
  }
}
