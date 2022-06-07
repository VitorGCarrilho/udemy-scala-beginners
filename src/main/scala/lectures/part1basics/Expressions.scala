package lectures.part1basics

object Expressions extends App {

  var x = 1 + 2 // EXPRESSION

  println(2 + 3 *4)

  x+=1
  println(x)
  println(x+=1)

  val aCodeBlock = {
    val x = 1
    val y = x + 1

    if (x>y) "hello" else "goodbye"
  }

  var test = println(s"codeBlock says: ${aCodeBlock}")


}
