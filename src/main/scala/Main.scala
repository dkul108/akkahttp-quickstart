import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer

import scala.concurrent.{Await, ExecutionContext}
import scala.util.{Failure, Success}

object Main extends App {

  val host = "0.0.0.0"
  val port = 9000

  implicit val system: ActorSystem = ActorSystem("todoapi")
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  //implicit val executor: ExecutionContext = system.dispatcher
  import system.dispatcher
  import akka.http.scaladsl.server.Directives._

  val todoRepository = new InMemoryTestRepository(Seq(Todo("1", "one", "one", true), Todo("2", "two", "two", false)))
  val router = new TodoRouter(todoRepository)

  val server = new Server(router, host, port)
  val binding = server.bind()

  binding.onComplete {
    case Success(_) => println("Success")
    case Failure(error) => println(s"error: $error.getMessage")
  }

  import scala.concurrent.duration._
  Await.result(binding, 3.seconds)
}
