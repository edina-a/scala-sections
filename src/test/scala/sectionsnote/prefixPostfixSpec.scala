package sectionsnote

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by edinakim on 2016. 12. 16..
  */
class prefixPostfixSpec extends FunSuite with Matchers {
  test("single parameter") {
    val num: Int = 3

    num + 4 shouldBe num.+(4)

    val str: String = "ABC"
    str.charAt(0) shouldBe "A"
    str charAt 0 shouldBe "A"
  }

  test("two params") {
    val str: String = "IOI"
    str.indexOf('I') shouldBe 0
    str.indexOf('I', 1) shouldBe 2
    str indexOf ('I', 1)
  }

  test("postfix") {
    val a: Int = 31
    a.toHexString
    a toHexString
  }

  test("priority") {
    val str: String = "101"
    // 중위연산자가 후위연산자보다 우선순위가 높음
    (str indexOf "1" toString) shouldBe "0"
  }

  test("unary") { // 단항연산자
    val g: Int = 31
    (-g) shouldBe -31
    g.unary_- shouldBe -31

    class MyClass() {
      def unary_+ : String = "on"
      def unary_- : String = "off"
    }

    val my = new MyClass()
    +my shouldBe "on"
    -my shouldBe "off"
  }

  test("cons") {
    val a = 1
    val b = 2
    val sum: List[Int] = a :: b :: Nil

    Nil.::(b).::(a) shouldBe sum

    class MyList2 {
      def ::(str:String): List[String] = List(str, str)
    }

    val my2 = new MyList2
    "edina" :: my2 shouldBe List("edina", "edina")

    trait AB[A,B]
    type IntAndString = AB[Int, String]
    type IntAndString2 = Int AB String

    // natural transformation

    // F[A] === functor map ====> F[B]
    // F[A] === natural transformation(~>) ====> G[A]
    val someInt: Some[Int] = Some(1)
    val someString = someInt.map(_.toString)
    val listInt: List[Int] = someInt.toList

    new AB[Int, String]{}
    trait ~>[F, G] {
      def apply(f: F): G
    }

    new (Int ~> String) {
      override def apply(f: Int): String = ???
    }
  }
}
