package lectures.part4patternmatching

import lectures.part2oop.mylist.MyList

object AllThePatterns extends App {

  // 1 - constants
  val x: Any = "Scala"
  val constants = x match {
    case 1 => "a number"
    case "Scala" => "The scala"
    case true => "the truth"
    case AllThePatterns => "A singleton object"
  }

  // 2 - match anything
  // 2.1 wildcard

  val matchAnything = x match {
    case _ =>
  }

  // 2.2 variable

  val matchAVariable = x match {
    case something => s"i've found ${something}"
  }

  // 3 - tuples

  val aTuple = (1, 2)

  val matchATuple = aTuple match {
    case(1, 1) =>
    case (something, 2) => s"i've found $something"
  }

  val nestedTuple = (1, (2, 3))
  val matchNestedTuple = nestedTuple match {
    case (_, (2, v)) =>
  }
  // pattern matches can be nested

  // 5 - list patterns
  val standardList = List(1, 2, 3, 42)

  val standardListMatching = standardList match {
    case List(1, _, _, _) => // extractor -advanced
    case List(1, _*) => // list of arbitrary lenght - advanced
    case 1 :: List(_) => // infix pattern
    case List(1, 2, 3) :+ 42 =>// infix pattern
  }

  // 6 - type specifiers
  val unknown: Any = 2

  val unknownMatch = unknown match {
    case list: List[Int] => // explicit type specifier
    case _ =>
  }



}
