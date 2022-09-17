package lectures.part3funcprogramming

import scala.annotation.tailrec

object HigherOrderFunctionsAndCurries extends App {

  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null
  // Higher order function (HOF)

  // map, flatMap, filter

  @tailrec def nTimes(function: Int => Int, times: Int, value: Int): Int =
    if (times<=0) value
    else nTimes(function, times-1, function(value))

  val plusOne = (x: Int) => x+1
  println(nTimes(plusOne, 10, 0))

  // ntb(f, n) = x => f(f(f...(x)))
  def nTimesBetter(func: Int => Int, times: Int): (Int => Int) =
    if (times <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(func, times-1)(func(x))

  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(0))

  // curried functions
  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3) // y => 3 + y

  println(add3(10))
  println(superAdder(10)(10))

  // functions with multiple parameter list
  def curriedFormatter(formatter: String) (value: Double): String = formatter.format(value)

  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))
}
