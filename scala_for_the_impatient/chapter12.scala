/*
Q1 :
주어진 범위의 함수 입력과 출력의 콜렉션을 주는 함수 values(fun: (Int) => Int, low: Int, high: Int)
를 작성하라 예를 들어 values(x => x * x, -5, 5)는 짝의 콜렉션 (-5, 25), (-4, 16), (-3, 9)
, ..., (5, 25)를 생산해야 한다.
 */

def values(fun: (Int) => Int, low: Int, high: Int): Map[Int, Int] = {
  if (low == high) Map(low -> fun(low))
  else Map(low -> fun(low)) ++ values(fun, low + 1, high)
}

values(x => x * x, -5, 5)


/*
Q2 :
어떻게 하면 reduceLeft로 배열의 가장 큰 원소를 얻을 수 있는가?
 */

val abc = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)
val cda = Array(9, 8, 7, 6, 5, 4, 3, 2, 1)

abc.reduceLeft(_ max _)
cda.reduceLeft(_ max _)


/*
Q3 :
루프나 재귀 없이 to와 reduceLeft를 사용하여 팩토리얼 함수를 구현하라.
 */

def factorial(num: Int): Int = {
  if (num > 0) (1 to num).reduceLeft(_ * _)
  else 0
}

factorial(5)


/*
Q4 :
앞의 구현은 n < 1 일 때 특별한 케이스가 필요했다. foldLeft로 이를 어떻게 피할 수 있는지 보여라.
(foldLeft에 대한 스칼라독을 참고한다.) 이는 호출에서 조합된 값들의 체인에서 첫 번째 값이 제공된다는
점을 제외하면 reduceLeft와 유사하다.)
 */

def factorial2(num: Int): Int = {
  (1 to num).foldLeft(1)(_ * _)
}

factorial2(5)
factorial2(-5)
