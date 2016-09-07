package sectionsnote

import javax.print.DocFlavor.BYTE_ARRAY

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by edinakim on 2016. 9. 7..
  */
class CurrySpec extends FunSuite with Matchers {
  // def foo(a: Int, b:Int, c:Int): Int = ???
  // (a,b,c) => d 는 입력이 3개이고 출력이 1개

  // y = f(x) 의 형태로 입력이 1개고 출력이 1개인 함수를 만들어 조합

  // a => b => c => d
  // 1. (a) => ((b) => ((c) => (d)))
  // 1. 에다가 f(a)
  // b => c => d
  // b를 적용시키면
  // c => d
  // c를 적용시키면
  // d

  // 장점
  // 함수를 여러군데에 활용할 수 있음

  def adder(x:Int, y:Int): Int = x + y

  val adder1: (Int) => (Int) => Int = (adder _).curried
  val adderWithOne = adder1(1)

  println(adderWithOne(10))
  println(adderWithOne(20))


  test("syntax") {
    def adder(x: Int)(y: Int) : Int = x + y
    val adderWithOne: (Int) => Int = adder(1)

    println(adderWithOne(10))
    println(adderWithOne(20))
  }

  // 많이 사용
  test("syntax 2") {
    def adder(x: Int) = (y: Int) => x + y
    val adderWithOne: (Int) => Int = adder(1)

    println(adderWithOne(10))
    println(adderWithOne(20))
  }

  test("x + y + z") {
    def adder(x: Int) = (y: Int) => (z: Int) => x + y + z
    val adderWithOne = adder(1)
    val adderWithOneAndTwo = adderWithOne(2)

    println(adderWithOneAndTwo(10))
    println(adderWithOneAndTwo(20))
  }

  // type annotaion 을 넣어야 partial function 으로 인식해서 에러 안남
  test("x + y + z 2") {
    def adder(x: Int)(y: Int)(z: Int) = x + y + z
    val adderWithOne: (Int) => (Int) => Int = adder(1)
    val adderWithOneAndTwo: (Int) => Int = adderWithOne(2)

    println(adderWithOneAndTwo(10))
    println(adderWithOneAndTwo(20))
  }
}
