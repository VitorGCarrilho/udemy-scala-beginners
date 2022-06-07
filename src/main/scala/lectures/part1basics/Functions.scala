package lectures.part1basics

object Functions extends App {

  def myFunction(): Unit = {
    println("my function")
  }

  myFunction()

  def sum(num1: Int, num2: Int): Int = {
    return num1 + num2
  }

  def printSum(): Unit = {}
}
