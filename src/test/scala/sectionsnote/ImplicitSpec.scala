package sectionsnote

import org.scalatest.{FunSuite, Matchers}

import scala.concurrent.Future


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

  test("실전") {
    // 1. 암묵적인 type casting

    // Edina(sul: String) => Suldina(edina: String)
    case class Edina(sul: String)
    case class Suldina(sul: String)

    implicit def toSul(edina: Edina): Suldina = Suldina(edina.sul)
    val suldina: Suldina = Edina("isool")

    // 암묵적으로 되는 건 명시적으로도 된다!

    println(suldina)

    // 2. 기존 class 에 문법 추가
    // Edina 에 name 추가

    implicit class Edinana(s: Edina) {
      def name = "에디나"
    }
    def e1 = Edina("막걸리")
    e1.name == "에디나"

    // 3. 암묵적인 변수를 특정 클래스에 주입

    implicit val ec = scala.concurrent.ExecutionContext.Implicits.global
    Future {
      println(10)
      Thread.sleep(1000)
      1+1
    }(ec)

    val a: Future[Int] = Future[Int](2)(ec)
    val f: Future[Int] = Future[Int](2) // ec를 implicit 로 넣으면서 생락 가능
    val l: List[Int] = List[Int](1+2)

  }
}
