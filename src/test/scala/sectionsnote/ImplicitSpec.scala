package sectionsnote

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by edinakim on 2016. 9. 28..
  */
class ImplicitSpec extends FunSuite with Matchers {
  // implicit 은연중의 <-> 명시적의 : explicit

  test("explicit") {

    def foo(bar: String) : String = bar + " " + bar

    val str = "hello"
    implicit val str2 = "world"

    println(foo(str))  // 명시적

    def foo1(implicit bar1: String): String = bar1 + " " + bar1

    println(foo1(str))  // 명시적임
    println(foo1) // 암묵적으로 쓰고 싶습니다

    // 1. 현재 스코프에서 찾음
    // 2. 컴패니언 오브젝트에서 찾음
    // 3. import 된 애들에서 찾음
    // 4. 에러
    // 찾는 기준은 타입

    // Quiz1. 만약 str 도 앞에 implicit 이 있으면 어떻게 될까요?
    // Answer. implicit 가 두개 존재하면 모호한 값으로 에러 발생함

   }

  test("implicit") {

    import Implicit._

    def foo1(implicit bar1: String): String = bar1 + " " + bar1

    println(foo1)

    // 1. 함수의 파라미터에 implicit  => def foo(implicit a:String)
    // 2. 변수에 implicit => implicit val a = ?
    // 3. 함수에 implicit => implicit def foo(a: String)
    //      :: 암묵적인 타입 캐스팅에 많이 쓰임
    // 4. 클래스에 implicit => implicit class Foo(a: String) {
    //                      def bar:String = a + " " + a
    //                    }


    // 함수 implicit 예제
    implicit def foo2(bar: Int): String = bar.toString + " 10000"
    val a : String = 123

    println(a)

    case class Status(status: Int)
    implicit def foo3(bar: Int): Status = Status(bar)
    val a1: Status = 123
    val a2: Status = foo3(123)

    println(a1)
    println(a2)


    // class implicit 예제
    implicit class Foo(a: String) {
      def barbarbar = a + a + a
    }
    println(a.barbarbar)

    // 자바의 단점. interface 를 바꿀 수 없다
    // 오래된 List => 의 interface가 아직도 그대로다
    // 스칼라는 기존의 것을 파괴하지 않고도 추가할 수 있다

    // 람다 = 익명함수, arrow, first class function

  }

}
