package lectures.part3funcprogramming

import lectures.part2oop.mylist.MyTransformer

object WhatsAFunction extends App {

  // DREAM: use functions as first class elements

  val doubler = new MyTransformer[Int, Int] {
    override def apply(t: Int): Int = t * 2
  }

  println(doubler(2))

  // function types = Function1[A, B]
  val stringToIntConverter = new Function1[String, Int] {
    override def apply(v1: String): Int = v1.length
  }
  println(stringToIntConverter("123"))

  // function 2
  // Function2[A, B, R] === (A, B) => R

  val adder: ((Int, Int) => Int) = (v1, v2) => v1 + v2

  // ALL SCALA FUNCTIONS ARE OBJECTS


  val concatStringsFunction = (str1: String, str2: String) => str1.concat(str2)
  println(concatStringsFunction("Vitor ", "Carrilho"))

  val printBalance = (value: Int) => {
    println(s"Your balance is ${value}, it seems you have money  ( ͡° ͜ʖ ͡°)")
  }
  val printEmptyBalance = (value: Int) => {
    println(s"you don't have money ()")
  }
  val printNegativeBalance = (value: Int) => {
    println(s"oh my god! ( ͡◉ ͜ʖ ͡◉) You are negative ${value}")
  }

  // define a function which takes an int and returns another function which takes an int
  val getPrintFunction = (value: Int) => {
    if (value==0) {
      printEmptyBalance
    } else if (value > 0) {
      printBalance
    } else {
      printNegativeBalance
    }
  }

  println(getPrintFunction(10)(10))
}
