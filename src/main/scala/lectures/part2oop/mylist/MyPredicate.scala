package lectures.part2oop.mylist

trait MyPredicate[T] {
  
  def test(t: T): Boolean

}
