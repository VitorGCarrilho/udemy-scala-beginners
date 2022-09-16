package lectures.part2oop.mylist

trait MyTransformer [T, Z]{
  def apply(t: T): Z
}
