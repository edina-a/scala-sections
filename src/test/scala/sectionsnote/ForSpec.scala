package sectionsnote

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by edinakim on 2016. 12. 7..
  */

case class MyList[A](list: List[A]) {
  // List[A] ==> f: A => List[B] ===> List[B]
  def flatMap[B](f: A => MyList[B]) : MyList[B] = {
    MyList(list.flatMap(i => f(i).list))
  }
}

class ForSpec extends FunSuite with Matchers {
//
//  test("mylist") {
//    val my1 = MyList(List(1,2,3))
//    val my2 = my1.flatMap(i => MyList(List(i *10)))
//    for {
//      my <- my1
//    } yield println(my)
//  }
  val numList = List(1,2,3,4)

  test("for basic") {
    for (num <- numList) println(num)

    numList.foreach(println)
  }

  test("filter") {
    numList.filter(_ % 2 ==0).foreach(println)
  }

  val numDoubleList = List(List(0), List(1,3,5))

  test("multiple generator") {
    for(nums <- numDoubleList; num <- nums) println(num)

    val result: List[(Int, String)] =
      for(x <- List(1,2); y <- List("One", "Two")) yield(x,y)
    println(result) // List[(1, "One"), (1, "Two"), (2, "One"), (2, "Two")]

    // for 표현식은 제너레이터에서 시작
    // 둘 이상의 제너레이터는 뒤쪽의 제너레이터가 앞의것보다 빨리 변화한다
  }

  test("binding") {
    for {
      num <- numList
      numStr = "S" + num.toString
    } println(numStr)
  }

  test("one generator to map") {
    val list1: List[String] = for(num <- numList) yield num.toString
    val list2: List[String] = numList.map(num => num.toString)
  }

  test("generator-filter to withFilter-map") {
    val expr2: List[Int] = numList.withFilter(_ % 2 == 0).map(num => num * 10)

    println(expr2)  // List(20, 40)
  }

  test("two generator to flatmap") {

    val numDoubleList = List(List(0), List(1,3,5))

    val expr3: List[String] = numDoubleList.flatMap(nums => nums.map(n => n.toString))
    println(expr3) // List(0, 1, 3, 5)
  }
}


