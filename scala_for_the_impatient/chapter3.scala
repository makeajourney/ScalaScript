import scala.collection.mutable.ArrayBuffer

/*
Q1 :
Write a code snippet that sets a to an array of n random
integers between 0(inclusive) and n(exclusive).
 */
def makeArray(n: Int) = {
//  val temp = new Array[Int](n)
//  for (i <- 0 until n)
//    temp(i) = i
//  temp
  (for (i <- 0 until n) yield i).toArray
}

val arr1 = makeArray(10)
arr1.mkString

/*
Q2 :
Write a loop that swaps adjacent elements of an array of
integers. For example, Array(1, 2, 3, 4, 5) becomes
Array(2, 1, 4, 3, 5).
 */
def swapArray(n: Array[Int]) {
  var temp: Int = 0
  for (i <- 0 until n.length if i % 2 == 0) {
    temp = n(i)
    n(i) = n(i + 1)
    n(i + 1) = temp
  }
}

swapArray(arr1)
arr1.mkString

/*
Q3 :
Repeat the preceding assignment, but produce a new array with
the swapped values. Use for/yield.
 */
def yieldSwapArray(n: IndexedSeq[Int]) = {
  for (i <- 0 until n.length) yield {
    if (i % 2 == 0) n(i + 1)
    else n(i - 1)
  }
}

val arr2 = makeArray(10)
yieldSwapArray(arr2)

/*
Q4 :
Given an array of integers, produce a new array that contains
all positive values of the original array, in their original
order, followed by all values that are zero or negative, in
their original order.
 */
def adjustNegAndPosiValue(n: Array[Int]): Array[Int] = {
  n.filter(_ > 0) ++ n.filter(_ <= 0)
}

val arr3 = Array(1, 2, -3, 4, 5, -6, 7, 8, 9, -10)
adjustNegAndPosiValue(arr3).mkString(", ")
arr3.mkString(", ")

/*
Q5 :
how do you compute the average of an Array[Double]?
 */
def computeAverage(n: Array[Double]): Double =
  n.sum / n.length

val arr4 = Array(1.6, 1.9, 3.4, 5.7, 2.5)
val average = computeAverage(arr4)


/*
Q6 :
How do you rearrange the elements of an Array[Int] so that they
appear in reverse sorted order? How do you do the same with an
ArrayBuffer[Int]?
 */
arr3.reverse.mkString(", ")

var arrayBuf = ArrayBuffer(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
arrayBuf.reverse

/*
Q7 :
Write a code snippet that produces all values from an array
with duplicates removed. (Hint: Look at ScalaDoc)
 */
val arr5 = Array(1, 1, 2, 3, 4, 4, 5, 7, 8, 10)
arr5.distinct.mkString(", ")
