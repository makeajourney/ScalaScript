/*
Q1 :
Write an object Conversions with methods inchesToCentimeter,
gallonsToLitter, and milesToKilometer.
 */

object Conversions {
  def inchesToCentimeter(inches: Double) = inches * 2.54
  def gallonsToLitter(gallons: Double) = gallons * 3.78541
  def milesToKilometer(miles: Double) = miles * 1.60934
}

/*
Q2 :
The preceding problem wasn't very object-oriented. Provide a
general superclass UnitConversion and define objects
InchesToCentimeter, GallonsToLitter, and MilesToKillometer
that extend it.
 */
class UnitConversion (value: Double) {
  def convert (conVal: Double) = value * conVal
}

object InchesToCentimeter extends UnitConversion(2.54)
object GallonsToLiter extends UnitConversion(3.78541)
object MilesToKilometer extends UnitConversion(1.60934)

/*
Q3 :
Define an Origin object that extends java.awt.Point.Why is this
not actually a good idea? (Have a close look at the methods of
the Point class.)
 */



/*
Q4 :
Define a Point class with a companion object so that you can
construct Point instances as Point(3, 4), without using new.
 */

class Point(var x: Int, var y: Int)

object Point {
  def apply(x: Int, y: Int) =
    new Point(x, y)
}

val point1 = Point(2, 3)

/*
Q5 :
Write a Scala application, using the App trait, that prints the
command-line arguments in reverse order, separated by spaces.
For example, scala Reverse Hello World should print World Hello.
 */
object Reverse extends App {
  if (args.length > 0) {
    for (i <- (0 until args.length).reverse) print(args(i))
  }
}

/*
Q6 :
Write an enumeration describing the four playing card suits so
that the toString method returns ♣, ♦, ♥ and ♠
 */
