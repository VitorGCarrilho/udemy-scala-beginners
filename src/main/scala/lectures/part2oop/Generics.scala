package lectures.part2oop

object Generics extends App {

  class Animal
  class Cat extends Animal
  class Dog extends Animal



  // COVARIANCE

  class CovariantGeneric[+T]

  val animal: Animal = new Cat
  val covariantGeneric: CovariantGeneric[Animal] = new CovariantGeneric[Cat]
  val covariantGeneric2: CovariantGeneric[Animal] = new CovariantGeneric[Dog]


  // INVARIANCE
  class InvariantGeneric[T]
  // val invariantGeneric: InvariantGeneric[Animal] = new InvariantGeneric[Cat] -> compile error
  val invariantGeneric: InvariantGeneric[Animal] = new InvariantGeneric[Animal]

  // CONTRAVARIANCE

  class Contravariance[-T]

  val contravariance: Contravariance[Cat] = new Contravariance[Animal]

  // bounded types
  class Cage[A <: Animal] (animal: A)
  val cage = new Cage(new Dog)

}
