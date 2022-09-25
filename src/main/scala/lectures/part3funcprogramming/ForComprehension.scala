package lectures.part3funcprogramming

object ForComprehension extends App {

  val numberList = List(1, 2, 3, 4)
  val charList = List('a', 'b', 'c')
  val colorList = List("green", "blue", "yellow")

  val list = numberList.flatMap(number => charList.flatMap(char => colorList.map(color => s"${number}${char}-${color}")))
  println(list)

  val result = for {
    number <- numberList
    char <- charList
    color <- colorList
  } yield s"${number}${char}-${color}"

  println(result)

  for {
    number <- numberList
    char <- charList
    color <- colorList
  } print(s"${number}${char}-${color}, ")
}
