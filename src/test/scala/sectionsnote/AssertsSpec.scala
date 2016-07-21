package sectionsnote

import org.scalatest.{Matchers, WordSpec}

/**
  * Created by edina on 2016. 7. 21..
  */
class AssertsSpec extends WordSpec with Matchers {
  "asserts group test" should {
    "matchers" in {
      true should be(true)

      val v1 = 4
      v1 shouldEqual 4

      assert(2 == 1+1)

    }
  }
}
