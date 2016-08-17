package sectionsnote

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by edinakim on 2016. 8. 17..
  */
class MapsSpec extends FunSuite with Matchers {
  test("Map") {

    // 1. Map (A, B)
    // 2. A -> B
    val map1 = Map[Int, String]((10, "ten"), (1, "one"))
    val map2 = Map(10 -> "ten", 1 -> "one")

    map1 shouldBe map2

    val map3 = map1.+(2 -> "two")
    println(map3)

    map3.get(10) shouldBe Some("ten")
    map3.get(3) shouldBe None
    map3.getOrElse(5, "five") shouldBe "five"

  }
}
