package dojo.store

import scala.scalajs.js

import js.Dynamic.{newInstance => jsnew}

trait JsonRest extends js.Object {


}

object JsonRest {
  class CreateOptions(val target: String = "",
    val idProperty: String = "",
    val accepts: String = "",
    val ascendingPrefix: String = "",
    val descendingPrefix: String = "",
    val headers: Array[String] = Array()) extends js.Object {

  }

  def apply(createOptions: JsonRest.CreateOptions)(jsonRest: js.Dynamic) = jsnew(jsonRest)(js.Dictionary("target" -> "/home/foo", "idProperty" -> "bar")).asInstanceOf[JsonRest]

  val require = "dojo/store/JsonRest"
}
