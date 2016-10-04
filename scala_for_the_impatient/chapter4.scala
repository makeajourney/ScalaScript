import java.util.Scanner

/*
Q1 :
Set up a map of prices for a number of gizmos that you covet. Then produce a second map
with the same keys and the prices at a 10 percent discount.
 */

val price = Map("computer" -> 300, "monitor" -> 100, "nas" -> 100, "camera" -> 150)

def discountPrice(map: Map[String, Int], percent: Int): Map[String, Double] = {
  for ((k, v) <- map) yield (k, v * ((100 - percent) * 0.01))
}

discountPrice(price, 10)
discountPrice(price, 20)


/*
Q2 :
Write a program that reads words from a file. use a mutable map to count how often
each word appears. To read the words, simply use a java.util.Scanner:
  val in = new java.util.Scanner(new java.io.File("myfile.txt"))
  while (in.hasNext()) process in.next()
Or look at the "Files and Regular Expressions" chapter for a Scalaesque way.
At the end, print out all words and their counts.
 */

val map = new scala.collection.mutable.HashMap[String, Int]
val in = new Scanner(new java.io.File("/Users/kimsoyoun/Downloads/myfile.txt"))

while (in.hasNext()) {
  val word = in.next()
  if (map.contains(word)) map(word) = map(word) + 1
  else map(word) = 1
}

map.mkString("(", ", ", ")")

/*
Q3 :
Repeat the preceding exercise with an immutable map.
 */
var immutableMap = Map[String, Int]()
val in2 = new Scanner(new java.io.File("/Users/kimsoyoun/Downloads/myfile.txt"))

while (in.hasNext()) {
  val word = in.next()
  if (immutableMap.contains(word)) {
    immutableMap = immutableMap + (word -> immutableMap(word))
  }
  else
    immutableMap = immutableMap + (word -> 1)
}

immutableMap.mkString("(", ", ", ")")
