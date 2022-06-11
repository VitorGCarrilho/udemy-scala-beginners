package lectures.part1basics

import scala.annotation.tailrec
import scala.collection.mutable

object Functions extends App {


  printSum(18, 24)

  def sum(num1: Int, num2: Int): Int = {
    return num1 + num2
  }

  def printSum(num1: Int, num2: Int): Unit = {
    println(s"the sum is ${sum(num1, num2)}")
  }

  def printFibonacci(number: Int): Unit =
    println(s"fibonnaci from ${number} is ${fibonacci(number)}")


  val map = mutable.HashMap[Int, Int]()


  // IN FUNCTIONAL PROGRAMMING, WHEN NEED LOOPS, USE RECURSION
  def fibonacci(number: Int): Int = {

    if (map.contains(number)) {
      return map.get(number).get
    }

    if (number == 0) {
      map.addOne(number, number)
      return number
    } else if (number<= 2) {
      map.addOne(number, 1)
      return 1
    }

    var fibonacciValue =  fibonacci(number-2) + fibonacci(number-1)
    map.addOne(number, fibonacciValue)
    fibonacciValue
  }

  printFibonacci(1000)

  def greeting(name: String, age: Int): Unit =
    println(s"Hi, my name is ${name} and i am ${age} years old")

  greeting("Vitor", 26)

  def factorialNolTailRecursive(number: BigDecimal): BigDecimal = {
    if (number==1) {
      return 1
    }

    return factorialNolTailRecursive(number-1) * number
  }

  def printFactorial(number: Int): Unit = {
    println(s"factorial of ${number} is ${factorialNolTailRecursive(number)}")
  }

  def factorialTailRecursive(number: BigDecimal): BigDecimal = {
    @tailrec
    def tailRecursiveHelper(number: BigDecimal, acumulator: BigDecimal):BigDecimal = {
      if (number<=1) {
        return acumulator;
      }
      tailRecursiveHelper(number -1 , acumulator*number)
    }
    return tailRecursiveHelper(number, 1)
  }

  def printTailRecursiveFactorial(number: Int): Unit = {
    println(s"factorial of ${number} is ${factorialTailRecursive(number)}")
  }

  printFactorial(5)

  @tailrec
  def isPrime(targetNumber: Int, divisor: Int): Boolean = {
    if (divisor == 1) {
      return true
    }
    if (targetNumber==divisor || targetNumber%divisor != 0) {
      isPrime(targetNumber, divisor -1)
    } else {
      false
    }
  }

  def isPrime(number: Int): Unit = {
    println(isPrime(number, number))
  }

  isPrime(930)

  //printFactorial(50000) -> java.lang.StackOverflowError
  printTailRecursiveFactorial(50000)
}
