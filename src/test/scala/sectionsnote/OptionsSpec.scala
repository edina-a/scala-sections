package sectionsnote

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by edina on 2016. 7. 21..
  */
class OptionsSpec extends FunSuite with Matchers {
    test("options") {
      val someValue: Option[String] = Some("I am wrapped in something")
      someValue should be(Some("I am wrapped in something"))

      val emptyValue: Option[String] = None
      emptyValue should be(None)
    }

    def maybeItWillReturnSomething(flag: Boolean): Option[String] = {
      if (flag) Some("Found value") else None
    }

    test("getOrElse") {
      val value1 = maybeItWillReturnSomething(true)
      val value2 = maybeItWillReturnSomething(false)

      value1 getOrElse "No value" should be("Found value")
      value2 getOrElse "No value" should be("No value")
      value2 getOrElse {
        "default function"
      } should be("default function")
    }

    test("isEmpty") {
      val value1 = maybeItWillReturnSomething(true)
      val value2 = maybeItWillReturnSomething(false)

      value1.isEmpty should be(false)
      value2.isEmpty should be(true)
    }

    test("match") {
      val someValue: Option[Double] = Some(20.0)
      val value = someValue match {
        case Some(v) => v
        case None => 0.0
      }
      value should be(20.0)
      val noValue: Option[Double] = None
      val value1 = noValue match {
        case Some(v) ⇒ v
        case None ⇒ 0.0
      }
      value1 should be(0.0)
    }

    test("pattern matching") {
      val a = List(1,2,3)
      val value = a match {
        case x:List[Int] => x
        case _ => 0
      }

      println(value)
    }

    test("map") {
      val number: Option[Int] = Some(3)
      val noNumber: Option[Int] = None
      val result1 = number.map(_ * 1.5)
      val result2 = noNumber.map(_ * 1.5)

      result1 should be(Some(4.5))
      result2 should be(None)
    }

    test("map test") {
      val lists: List[Int] = List(1,2,3)
      println(lists.map(_ * 1.5))
    }

    test("fold") {
      val number: Option[Int] = Some(3)
      val noNumber: Option[Int] = None
      val result1 = number.fold(0)(_ * 3)
      val result2 = noNumber.fold(0)(_ * 3)

      result1 should be(9)
      result2 should be(0)
    }
}
