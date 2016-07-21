package sectionsnote

import org.scalatest.{Matchers, WordSpec}

/**
  * Created by edina on 2016. 7. 21..
  */
class ClassesSpec extends WordSpec with Matchers {
  "classes group test" should {
    "class" in {
      class ClassWithValParameter(val name: String)
      val aClass = new ClassWithValParameter("Gandalf")
      aClass.name should be("Gandalf")
    }
  }
}
