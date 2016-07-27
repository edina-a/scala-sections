package sectionsnote

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by edina on 2016. 7. 21..
  * http://www.scalatest.org/user_guide
  */
class AssertsSpec extends FunSuite with Matchers {

  test("hello scala") {
    println("hello world!")
  }

  test("asserts test") {
    true should be(true)

    val v1 = 4
    v1 shouldEqual 4

    assert(2 == 1+1)
  }
}
