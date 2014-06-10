package dojo.store

import scala.scalajs.js

import js.Dynamic.{newInstance => jsnew}

trait JsonRest[T, K] extends js.Object {
  def add(obj: T, directives: PutDirectives[T, K]): K = ???
  def get(id: K): T = ???
  def getChildren[V](parent: T, options: QueryOptions): QueryResults[V] = ???
  def getIdentity(obj: T): K = ???
  def getMetadata(obj: T): Array[Any] = ???
  def put(obj: T, directives: PutDirectives[T, K]): K = ???

   def query(query: String, options: QueryOptions): QueryResults[T] = ???
   def query(query: Map[Any, Any], options: Any): QueryResults[T] = ???
   def query(query: (T) => Boolean, options: QueryOptions): QueryResults[T] = ???

   def remove(id: K): Boolean = ???

   def transaction(): Transaction = ???

}

object JsonRest {
  class CreateOptions(val target: String = "",
    val idProperty: String = "",
    val accepts: String = "",
    val ascendingPrefix: String = "",
    val descendingPrefix: String = "",
    val headers: Array[String] = Array()) extends js.Object {

  }

  def apply[T, K](createOptions: JsonRest.CreateOptions)(jsonRest: js.Dynamic) = jsnew(jsonRest)(createOptions).asInstanceOf[JsonRest[T, K]]

  val require = "dojo/store/JsonRest"
}
