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


  val reverseTransformer: MyTransformer[String, String] = s => s.toString
  val reverseListString = list.map(reverseTransformer)
  println(reverseListString.map(s => s.length).map(s => BigDecimal(s, 1)))

  println(list.filter(s => s.contains("V")))

}
