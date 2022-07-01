package lectures.part1basics

object StringOps extends App {

  val str: String  = "hello, i am learning scala"

  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)

  val number = "54".toInt

}
