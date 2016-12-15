package functional

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by edinakim on 2016. 12. 15..
  */
class polymorphicFunction extends FunSuite with Matchers {

  def isSorted[A](as:Array[A], ordered: (A,A) => Boolean): Boolean = {
    @annotation.tailrec
    def loop(n:Int): Boolean = {
      if (n >= as.length) true
      else {
        if(ordered(as(n), as(n+1))) loop(n+1)
        else false
      }
    }
    loop(0)
  }



  test("poly") {
    val myArr = Array(1,2,3,4)
    isSorted(myArr, (a: Int, b:Int) => a < b ) should be (true)

    // method
    def predicate1(a:Int, b:Int):Boolean = a < b

    // function
    val predicate2 : (Int, Int) => Boolean = (a:Int, b:Int) => a < b

    val predicate3 = (_:Int) < (_:Int)

    //Function2 trait
    val predicate4 : (Int, Int) => Boolean = {
      new ((Int, Int) => Boolean) {
        override def apply(v1: Int, v2: Int): Boolean = v1 < v2
      }
    }
  }

  // 커링
  // 하스켈 커리
  // (A, B, C) => D
  // (A => (B => (C => D)))
  // A => B => C => D
  // 함수를 리턴하는데에서 자주 쓰인다
  // 파셜 펑션에서 자주 씀. 함수의 재활용

  def curry[A,B,C,D,E](f:(A,B,C,D)=>E):A=>B=>C=>D=>E =
    a => b => c => d =>f(a,b,c,d)

  def uncurry[A,B,C](f: A=>B=>C):(A,B)=> C =
    (a,b) => f(a)(b)

  def foo1(a:Int, b:Int) = a + b
  def foo2(a:Int, b:Int) = a + b
  def foo3(a:Int): Int => Int = b => a + b

  foo1(1,2) shouldBe 3  // 이방식은 인자를 동시에 적용시켜야만 함

  // 그러나 커링을 쓰면 일부 기능을 함수로 구현해서 앞에 인자에 따라 두번째 인자를 결정할 수 있음 
  def foo2(a:Int)(b:Int) = a + b
  val addWithOne:(Int) => Int = foo2(1)
  addWithOne(10)  // 11
  addWithOne(11)  // 12

}
