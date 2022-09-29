package lectures.part3funcprogramming

import scala.util.Random

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


  // arrays

  val numbers = Array(1, 2, 3, 4)
  val threeElements = Array.ofDim[String](3) // ( null, null, null
  threeElements.foreach(println)

  // mutation
  numbers(2) = 0 // syntax sugar >> numbers.update(2, 0)
  println(numbers.mkString(", "))

  // arrays and seq


  val numbersSeq: Seq[Int] = numbers  // implicit conversion
  println(numbersSeq)

  // Vector

  val vector: Vector[Int] = Vector(1, 2, 3)
  println(vector)

  // vectors vs list

  val maxRuns = 100
  val maxCapc = 1000000
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapc), r.nextInt())
      System.nanoTime() - currentTime

    }

    times.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapc).toList
  val numbersVector = (1 to maxCapc).toVector

  // update first element is efficient
  // update in the middle takes a long time
  // keeps reference to tail
  println(getWriteTime(numbersList)) // 1.110254427E7

  // depth of the tree is small
  // needs to replace an entire 32-element chunk
  println(getWriteTime(numbersVector)) // 18886.7
}
