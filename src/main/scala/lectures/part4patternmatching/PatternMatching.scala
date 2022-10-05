package lectures.part4patternmatching

import scala.util.Random

object PatternMatching extends App {

  // switch on steroids
  val random = new Random
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "the one"
    case 2 => "double or nothing"
    case 3 => "third time is the charm"
    case _ => "something else" // _ = WILDCARD
  }

  println(x)
  println(description)

  // 1. Decompose values

  case class Person(name: String, age: Int)
  val bob = Person("Bob", 20)

  val greeting = bob match {
    case Person(n, a) if a<21 => s"Hi, my name is $n and i cant dring in USA"
    case Person(n, a) => s"Hi, my name is $n and i am $a years old"
    case _ => "I don't know who i am"
  }

  println(greeting)

  /*

  Exercise

  * */

  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

  def getHumanReadable(expr: Expr): String = expr match {
    case Number(n) => s"${n}"
    case Sum(e1, e2) => s"${getHumanReadable(e1)} + ${getHumanReadable(e2)}"
    case Prod(e1, e2) => {
      def maybeShowParentheses(exp: Expr) = exp match {
        case Prod(_, _) => getHumanReadable(exp)
        case Number(_) => getHumanReadable(exp)
        case _ => "(" + getHumanReadable(exp) + ")"
      }

      maybeShowParentheses(e1) + " * " + maybeShowParentheses(e2)
    }
    case _ => "none"
  }

  val readable = getHumanReadable(Prod(Sum(Number(3), Number(4)), Number(78)))
  println(readable)
}
