package fpinsnote

import scala.annotation.tailrec

/**
  * Created by edinakim on 2016. 9. 19..
  */

object Recursion {  // class 이면 test 에서 불러오지 못함. object 로 변경

  // 피보나치 수열
  def fib(n: Int): Int = {

    // 장점 : 구현이 간단. 수학공식을 그대로 표현할 수 있음
    // 단점 : stackover flow 발생

    // tailrec : while
    @annotation.tailrec
    def loop(n: Int, prev: Int, cur: Int): Int = {
      // 1. base case 끝나는 부분 값을 구현
      if (n <= 0) prev
      // 2. 반복되는 부분을 구현
      else loop(n - 1, cur, prev + cur)
    }
    loop(n, 0, 1)
  }

  // 팩토리얼
  // n! => 1 * 2* 3 ... n-1*n
  // (n+1)! =>

  def factorial(n: Int): Int = {
    if (n == 0) 1
    else {factorial(n-1) * n}
  }
  // => stack overflow 발생함.

  // tailrec => stack overflow 해결. 컴파일러 단에서 while 로 변경해서 처리.
  // 결과값을 계속 파라미터로 넘겨줌 (꼬리 재귀함수)
  def factorial1(n: Int): Int = {
    @tailrec
    def fact(n1: Int, acc: Int) : Int = {
      if (n1 == 0) acc
      else {
        fact(n1-1, acc * n1)
      }
    }
    fact(n, 1)
  }

  // tailrec 안쓰고 while 문으로 구현한 버전
  def factorial2(n: Int): Int = {
    var acc: Int = 1
    var n1: Int = n
    while (n1 != 0) {
      acc = acc * n1
      n1 = n1 - 1
    }
    acc
  }
}
