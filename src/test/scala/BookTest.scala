import java.util.concurrent.Executors

import com.outworkers.phantom.ResultSet
import com.outworkers.phantom.connectors.KeySpace
import entities.Book
import org.scalatest.FunSuite
import repository.BookRepository
import scala.concurrent.duration._

import scala.concurrent.{Await, ExecutionContext, Future}

class BookTest extends FunSuite{

  test("Guardar en la base de datos"){

    /*implicit val ecBook = ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(20))
    implicit val session = LocalDatabase.session
    implicit val keySpace = KeySpace(LocalDatabase.keyspace.name)
    LocalDatabase.books.saveBook(Book("123456","El Principito","Antoine","Aventura","ABC","EEUU",1))*/
    val res: Future[ResultSet] =BookRepository.saveBook(Book("1234567","El Principito","Antoine","Aventura","ABC","EEUU",2))
    val res2=Await.result(res,10 seconds)
    println(res2)
  }

  test("Modificar Libro en la base de datos"){
    val res =BookRepository.updateBook(Book("1234567","El Principito2","Antoine2","Aventura","ABC","EEUU",2))
  }
  test("Eliminar libro en la base de datos"){
    BookRepository.deleteBook(Book("1234567","El Principito2","Antoine2","Aventura","ABC","EEUU",2))
  }
  test("Buscar libro por ISBN en la base de datos."){
    BookRepository.searchBook("1234567")
  }

}
