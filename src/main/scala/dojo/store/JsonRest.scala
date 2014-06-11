package dojo.store

import scala.scalajs.js

import js.Dynamic.{newInstance => jsnew}

trait JsonRest extends js.Object {

}

object JsonRest {

  def apply[T, K]()(jsonRest: js.Dynamic) = jsnew(jsonRest)().asInstanceOf[JsonRest]

  val require = "dojo/store/JsonRest"
}
