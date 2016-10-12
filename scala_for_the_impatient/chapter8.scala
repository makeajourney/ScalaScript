/*
Q1 :
Extend the following BankAccount class to a CheckingAccount class that charges
$1 for every deposit and withdrawal
class BankAccount(initialBalance: Double) {
  private var balance = initialBalance
  def deposit(amount: Double) = { balance += amount; balance }
  def withdraw(amount: Double) = { balance -= amount; balance }
}
 */
class BankAccount(initialBalance: Double) {
  private var balance = initialBalance
  def deposit(amount: Double) = { balance += amount; balance }
  def withdraw(amount: Double) = { balance -= amount; balance }
}
class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {
//  override var balance = initialBalance
  override def deposit(amount: Double) = { super.deposit(amount - 1) }
  override def withdraw(amount: Double) = { super.withdraw(amount + 1) }
}

/*
Q2. Extend the BankAccount class of the preceding exercise to a class SavingsAccount
that earns interest every month (when a method earnMonthlyInterest is called) and that
has three free deposits or withdrawals every month. Reset the transaction count in the
earnMonthlyInterest method.
 */
class SavingsAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  // 3번의 공짜 입금 혹은 출금 제공
  var freecharge: Int = 3
  val percent: Double = 0.05

  override def deposit(amount: Double) = {
    if (freecharge > 0) {
      freecharge -= 1
      super.deposit(amount)
    }
    else super.deposit(amount - 1)
  }

  override def withdraw(amount: Double) = {
    if (freecharge > 0) {
      freecharge -= 1
      super.deposit(amount)
    }
    else super.withdraw(amount + 1)
  }

  // 매달 이자 지급
  def earnMonthlyInterest = {
    freecharge = 3
//    balance += (balance * percent)
  }
}
