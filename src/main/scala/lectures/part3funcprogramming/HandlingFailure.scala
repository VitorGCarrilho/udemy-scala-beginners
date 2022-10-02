package lectures.part3funcprogramming

import lectures.part3funcprogramming.Options.Connection

import scala.util.{Failure, Random, Success, Try}

object HandlingFailure extends App {

  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("SUPER FAILURE"))

  println(aSuccess)
  println(aFailure)

  def unsafeMethod(): String = throw new RuntimeException("no string for you")


  // try objects via the apply method
  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)


  val anotherFailure = Try {
    unsafeMethod()
  }

  // utilities
  println(anotherFailure.isFailure)
  println(anotherFailure.isSuccess)

  // or Else
  def backupMethod(): String = "A valid result"
  val fallbackTry = Try(unsafeMethod()).orElse(Try(backupMethod()))
  println(fallbackTry)

  // IF you design the api
  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException)
  def betterBackupMethod(): Try[String] = Success("A valid result")
  val betterFallback = betterUnsafeMethod().orElse(betterBackupMethod())
  println(betterFallback)

  // map, flatmap, filter
  println(aSuccess.map(_ * 2))
  println(aSuccess.flatMap(x => Success(x*10)))
  println(aSuccess.filter(_ > 100)) // turns into a failure

  val hostname = "localhost"
  val port = "8080"
  def renderHTML(page: String) = println(page)

  class Connection {
    def get (url: String): String = {
      val random = new Random(System.nanoTime())
      if(random.nextBoolean()) "<html></html>"
      else throw new RuntimeException("Connectioni Interrupted")
    }
  }

  object HttpService {
    val random = new Random(System.nanoTime())

    def getConnection(host: String, port: String): Connection =
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("Some one else took the port")
  }


  println("Getting html page:")

  // chain
  val tryGetConn = Try(HttpService.getConnection(hostname, port))
    .flatMap(conn => Try(conn.get("https://www.udemy.com/course/rock-the-jvm-scala-for-beginners/")))
    .foreach(renderHTML)

  // for-comprehension version

  for {
    connection <- Try(HttpService.getConnection(hostname, port))
    html <- Try(connection.get("/home"))
  } renderHTML(html)
}
