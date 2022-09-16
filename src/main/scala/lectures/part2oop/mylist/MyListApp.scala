package lectures.part2oop.mylist

object MyListApp extends App {

  val list = MyLinkedList[String]

  println(s"empty: ${list.isEmpty()}")
  list.add("Vitor")
  list.add("Gabriel")
  list.add("Carrilho")

  println(list.getHead())
  println(list.getTail())
  println(list.toString())
  println(s"empty: ${list.isEmpty()}")


  val reverseListString = list.map(s => s.reverse)
  println(reverseListString)

}
