package dojo.store

import scala.scalajs.js

import js.Dynamic.{newInstance => jsnew}

trait DataStore extends js.Object

trait JsonRest extends DataStore {
  val target: String = ???
  val idProperty: String = ???
}

object JsonRest {

  def apply(target: String, idProperty: String)(jsonRest: js.Dynamic) = jsnew(jsonRest)(js.Dictionary("target" -> target, "idProperty" -> idProperty)).asInstanceOf[JsonRest]

  val require = "dojo/store/JsonRest"
}
