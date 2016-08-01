package sectionsnote

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by edina on 2016. 7. 21..
  */
class ClassesSpec extends FunSuite with Matchers {
  test("classes with val") {
      class ClassWithValParameter(val name: String)
      val aClass = new ClassWithValParameter("Gandalf")
      aClass.name should be("Gandalf")
    }

  test("classes with var") {
    class ClassWithVarParameter(var name: String)
    val aClass = new ClassWithVarParameter("Gandalf")
    aClass.name = "DD"
    aClass.name should be("DD")
  }
}
