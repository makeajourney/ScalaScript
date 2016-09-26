// Ordered trait mix-in
class Rational(n: Int, d: Int) extends Ordered[Rational] {
  require(d != 0) // 제약조건

  // class fields
  private val g = gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g

  def this(n: Int) = this(n, 1)   // auxiliary constructor

  // 암시적 타입 변환
  // implicit def intToRational(x: Int) = new Rational(x)

  override def toString = numer + "/" + denom

  def + (that: Rational): Rational =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  def + (i: Int): Rational =
    new Rational(numer + i * denom , denom)

  def - (that: Rational): Rational =
    new Rational (
      numer * that.denom - that.numer * denom,
      denom * that.denom
    )

  def - (i: Int): Rational =
    new Rational(numer - i * denom, denom)

  def * (that: Rational): Rational =
    new Rational(numer * that.numer, denom * that.denom)

  def * (i: Int): Rational =
    new Rational(numer * i, denom)

  def / (that: Rational): Rational =
    new Rational(numer * that.denom, denom * that.numer)

  def / (i: Int): Rational =
    new Rational(numer, denom * i)

  // Ordered trait 이용
  def compare(that: Rational) =
    (this.numer * that.denom) - (that.numer * this.denom)

//  def < (that: Rational) =
//    this.numer * that.denom < that.numer * this.denom

//  def > (that: Rational) = that < this

  def <= (that: Rational) = (this < that) || (this == that)

  def >= (that: Rational) = (this > that) || (this == that)

  def max(that: Rational) =
    if (this.lessThan(that)) that else this

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}
