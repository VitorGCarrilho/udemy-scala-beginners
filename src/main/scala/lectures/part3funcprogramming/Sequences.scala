package lectures.part3funcprogramming

object Sequences extends App {

  // Seq

  val aSequence = Seq(1, 2, 3, 4)
  println(aSequence) // List

  println(aSequence.reverse)

  println(aSequence(2)) // index 2

  println(aSequence ++ Seq(5, 6, 7)) //List(1, 2, 3, 4, 5, 6, 7)

  // Ranges
  val aRange: Seq[Int] = 0 to 4 // 4 included
  aRange.foreach(println)
  (0 until 4).foreach(println) // 4 excluded

  // Lists
  val aList = List(1, 2, 3, 4)
  val prepended = 42 :: aList
  println(prepended)
  println(-1 +: aList :+ 1)

  val fiveApples = List.fill(5)("Apple")
  println(fiveApples)

  println(aList.mkString(" ] [ "))
}
