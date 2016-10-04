import scala.beans.BeanProperty

/*
Q1 :
Improve the Counter class in Section 1 so that it doesn't turn negative at Int.MaxValue.
 */

class Counter {
  private var value = 0
  def increment() {
    if (value != Int.MaxValue) value += 1
  }

  def current() = value
}

/*
Q2 :
Write a class BankAccount with methods deposit and withdraw, and read-only property
balance.
 */

class BankAccount {
  private var balance = 0
  println("Create new Bank Account!")

  def deposit(money: Int): Unit = {
    balance = balance + money
  }
  def withdraw(money: Int): Unit = {
    balance = balance - money
  }
}

/*
Q3 :
Write a class Time with read-only properties hours and minutes and a method
before(other: Time): Boolean that checks whether this time comes before the other.
A Time object should be constructed as new Time(hrs, min), where hrs is in military time
(between 0 and 23).
 */

class Time (val hrs: Int, val min: Int) {

  def before(other: Time): Boolean = {
    if (this.hrs > other.hrs) true
    else if (this.hrs == other.hrs) (this.min > other.min)
    else false
  }

  /*
  Q4 : Reimplement the Time class from the preceding exercise so that the internal
  representation is the number of minutes since midnight (between 0 and 24 x 60 - 1).
  Do not change the public interface. That is, client code should be unaffected by
  your change.
   */
  def minutes = hrs * 60 + min
}

/*
Q5 :
Make a class Student with read-write JavaBeans properties name (of type String) and
id (of type Long). What methods are generated? (Use javap to check.) Can you call the
JavaBeans getters and setters in Scala? Should you?
 */
class Student(@BeanProperty var name: String, @BeanProperty var id: Long)

/*
Q6 :
In the Person class of Secrion 1, provide a primary constructor that turns negative ages to 0.
 */
class Person (var name: String, var age: Int){
  age = if (age < 0) 0 else age
}

/*
Q7 :
Write a class Person with a primary constructor that accepts a string containing a
first name, a space, and a last name, such as new Person("Fred Smith"). Supply
read-only properties firstName and lastName. Should the primary constructor parameter
be a var, a val, or a plain parameter? Why?
 */
