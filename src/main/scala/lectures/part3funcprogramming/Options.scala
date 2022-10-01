package lectures.part3funcprogramming

import scala.util.Random

object Options extends App {

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)

  // unsafe APIs
  def unsafeMethod(): String = null
  val result = Option(unsafeMethod())  // Some or none
  println(result)

  // chained methods
  def backupMethod(): String = "A valid result"
  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))

  // Desing unsafe apis
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("Valid result")

  val betterChainedResult = betterUnsafeMethod().orElse(betterBackupMethod())

  // functions on options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get)// unsafe

  // map, flatMap, filter
  println((myFirstOption.map(_ * 2)))
  println((myFirstOption.filter(x => x>10)))
  println(myFirstOption.flatMap(x => Option(x * 10)))



  val config: Map[String, String] = Map(
    "host" -> "176.45.36.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected" // connected to some server
  }
  object Connection {
    val random =  new Random(System.nanoTime())


    def apply(host: String, port: String) : Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None
  }


  val optHost = config.get("host")
  val optPort = config.get("port")

  val connection = optHost.flatMap(host => optPort.flatMap(port => Connection.apply(host, port)))
  val connectionStatus = connection.map(c => c.connect)
  println(connectionStatus)
  connectionStatus.foreach(println)

  // chained calls

  config.get("host")
    .flatMap(host =>
      config.get("port")
      .flatMap(port => Connection(host, port))
        .map(connection => connection.connect))
    .foreach(println)

  // for-comprehension
  val forConnectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect


}
