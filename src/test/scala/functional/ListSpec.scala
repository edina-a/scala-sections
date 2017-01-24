package functional

import org.scalatest.{Matchers, WordSpec}

/**
  * Created by edinakim on 2017. 1. 24..
  */
/**
  * [ "x", 1, object, list | -]--> [ | -]--> [ | -]--> Nil
  */
// List(1, 2, 3)
// List(1, "x", Some(1))

// ADT = Algebraic Data Type
sealed trait MyList[+A]
case object MyNil extends MyList[Nothing]
case class Cons[A](head: A, tail: MyList[A]) extends MyList[A]

sealed trait MyList2[-A]

trait A
trait B extends A
trait Covariant[+A]
trait Invariant[A]
trait Contravariant[-A]
// 재귀적 자료 구조형 MyList[A]
// covariant, invariant, contravariant
//
class ListSpec extends WordSpec with Matchers{
  "list" should {
    "a" in {
      val list = 1 :: 2 :: 3 :: Nil
//      val myList: MyList[Int] = Cons(1, Cons(2, Cons(3, MyNil)))
//      println(myList)
      // B는 A의 하위 타입이다.
      // Invariant[B]가 Invariant[A]하위 타입일까? no.

      val a: Invariant[A] = new Invariant[A] {}
      val b: Invariant[B] = new Invariant[B] {}
//      val c: Invariant[A] = new Invariant[B] {}
      //

      // MyList[+A]
      // Nothing는 Int의 하위 타입이다.
      // MyList[Nothing]가 MyList[Int]하위 타입일까? yes
      val myIntList : MyList[Int] = new MyList[Nothing] {}

      //
      // MyList[-A]
      // Any는 Int의 상위 타입이다.
      // MyList[Any]가 MyList[Int]상위 타입일까? e : y, j : y, k : y
      val myIntList2 : MyList2[Int] = new MyList2[Any] {}

    }
  }
}
