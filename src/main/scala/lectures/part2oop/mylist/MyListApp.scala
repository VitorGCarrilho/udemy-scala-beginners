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

  val accumulatedValue: String = list.fold("", (str1, str2) => str1 + str2)

  println(accumulatedValue)

  list.forEach(str => println(s"foreach i am printing ${str}"))

  val numericList = MyLinkedList[Integer]
  numericList.add(1)
  numericList.add(3)
  numericList.add(2)
  numericList.add(4)
  numericList.sort((n1, n2) => Integer.compare(n1, n2))

  println(numericList)

}
