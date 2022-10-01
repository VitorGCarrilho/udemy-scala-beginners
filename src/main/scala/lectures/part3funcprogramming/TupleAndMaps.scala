package lectures.part3funcprogramming

object TupleAndMaps extends App {

  // tuples = finite ordered "lists"
  val aTuple = Tuple2(2, "hello, Scala")// Tuple2[int, String] = (Int, String)


  println(aTuple._1) // 2
  println(aTuple.copy(_2 = "goodbye Java"))
  println(aTuple.swap) // ("hello, Scala", 2)

  // Maps - keys -> values
  val aMap: Map[String, Int] = Map()
  val phonebook = Map(("Jim", 555), "Daniel" -> 789).withDefaultValue(-1)
  // a -> b is sugar for ( a, b)
  println(phonebook)

  // maps ops
  println(phonebook.contains("Jim"))
  println(phonebook("Mary"))

  // add a pairing
  val newPariring = "Mary" -> 768
  val newPhonebook = phonebook + newPariring
  println(newPhonebook)

  // functions on maps
  // maps, flatMap, filter

  println(phonebook.map(pair => pair._1.toLowerCase() -> pair._2))

  // filterKeys
  println(phonebook.view.filterKeys(x => x.startsWith("J")).toMap)

  // conversion to other collections
  println(phonebook.toList)
  println(List(("Daniel", 555)).toMap)
  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))

}
