package lectures.part2oop.mylist

trait MyList[T] {

  def isEmpty(): Boolean

  def add(element: T): Unit

  def toString(): String

  def getHead(): Option[T]

  def getTail(): Option[T]
}
