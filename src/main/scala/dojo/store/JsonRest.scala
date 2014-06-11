package dojo.store

import scala.scalajs.js

import js.Dynamic.{newInstance => jsnew}

trait JsonRest extends js.Object {

}

object JsonRest {

  def apply(target: String, idProperty: String)(jsonRest: js.Dynamic) = jsnew(jsonRest)(js.Dictionary("target" -> target, "idProperty" -> idProperty).asInstanceOf[JsonRest]

  val require = "dojo/store/JsonRest"
}
