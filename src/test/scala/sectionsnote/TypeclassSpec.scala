package sectionsnote

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by edinakim on 2016. 12. 27..
  */

case class Foo1[A](a:A, b:A)

import simulacrum._

@typeclass trait Functor1[F[_]] {
  @op(">>") def map[A, B](fa: F[A])(f: A => B): F[B]
}

object TypeclassSpec extends FunSuite with Matchers {

  implicit val fooFunctor: Functor1[Foo1] = new Functor1[Foo1] {
    override def map[A, B](fa: Foo1[A])(f: (A) => B): Foo1[B] =
      Foo1(f(fa.a), f(fa.b))
  }

  import Functor1.ops._
  val foo2 = Foo1(10,20)
  foo2 >> (_ + 10)

  // monoid 에는 뭐가 있나?
  // def empty
  // def append

  // 1번. 타입을 받는 trait을 만든다
  trait Monoid[A] {
    def zero:A
    def append(a:A, b:A):A
  }

  // 2번. 인스턴스를 만든다
  implicit val intSumMonoid: Monoid[Int] = {
    new Monoid[Int] {
      def zero: Int = 0

      def append(a: Int, b: Int): Int = a + b
    }
  }

  // 3번 syntax 또는 operator를 만든다
  object Monoid {
    def append1[A](a:A, b:A)(implicit M: Monoid[A]): A =
      M.append(a, b)

    def append2[A: Monoid](a:A, b:A): A =
      implicitly[Monoid[A]].append(a,b)
  }

  val a: Int = 10
  val b: Int = 20
  Monoid.append1(a,b)

  case class Foo(a:Int, b:Int)
  implicit val fooMonoidInstance: Monoid[Foo] = new Monoid[Foo] {
    override def zero: Foo = Foo(0,0)

    override def append(x: Foo, y: Foo): Foo =
      Foo(Monoid.append1(x.a, y.a), Monoid.append1(x.b, y.b))
  }



}

