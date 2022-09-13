package lectures.part2oop

object AbstractDataTypes extends App {

  val crocodile = new Crocodile
  crocodile.eat(new Dog)

  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"

    override def eat: Unit = {
      println("eating..")
    }
  }

  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Feline
  trait Quadruped

  class Lion extends Animal with Carnivore with Feline with Quadruped {
    override val creatureType: String = "Lion"

    override def eat: Unit = println("Eating...")
    override def eat(animal: Animal): Unit = {
      println(s"eating ${animal}")
    }
  }

  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "croc"

    override def eat: Unit = println("Eating...")
    override def eat(animal: Animal): Unit = println(s"I´m a ${creatureType} and i´m eating a ${animal.creatureType}")
  }


}
