package lectures.part2oop.mylist

trait MyList[T] {

  def isEmpty(): Boolean

  def add(element: T): Unit

  def toString(): String

  def getHead(): Option[T]

  def getTail(): Option[T]
  
  def map[Z](transformer: MyTransformer[T, Z] ): MyList[Z]
  
  def filter(predicate: MyPredicate[T]): MyList[T]

  def fold(accumulator: T, function2: (T, T) => T): T
  
  def forEach(func: (t: T) => Unit): Unit
  
  def sort(sortFunction: Function2[T, T, Int]): Unit
}
