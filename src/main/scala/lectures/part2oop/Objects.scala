package lectures.part2oop

object Objects extends App {


  // object -> singleton instances 
  object SingletonPerson {
    // static / class level functionality
    val NUMBER_OF_EYES = 2

    def canFly: Boolean = false
  }

  class Person {
    val numberOfEyes = 2

    def canFly: Boolean = false
  }

  val p1 = SingletonPerson
  val p2 = SingletonPerson

  assert(p1 == p2)

  val p3 = new Person
  val p4 = new Person
  assert(p3 != p2)
}
