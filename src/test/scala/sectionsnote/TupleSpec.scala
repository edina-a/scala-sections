package sectionsnote

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by edinakim on 2016. 8. 3..
  */
class TupleSpec extends FunSuite with Matchers {

  test("tuples") {
    val tuple5 = ("a", 1, 2.2, "ABC", "five")

    tuple5._2 should be(1)
    tuple5._5 should be("five")
  }

  test("destructuring") {
    val student = ("Sean Rogers", 21, 3.5)
    val (name, age, gpa) = student

    name should be("Sean Rogers")
    age should be(21)
    gpa should be(3.5)
  }
}
