package lectures.part2oop

object InheritanceAndTraits extends App {

  // prevents class from being extended in other files
  sealed class Animal {
    def eat = println("eating..")
  }

  class Cat extends Animal

  val cat = new Cat
  cat.eat

  //constructors
  class Person(name: String, age: Int)
  class Adult(name: String, age: Int, idCard: String) extends Person(name = name, age = age)


  //override

  class Dog extends Animal {
    override def eat = println("dog is eating")
  }
}
