package dijit.layout

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import js.Dynamic.{global => g, newInstance => jsnew, literal => lit}
import dojo.DojoComponent

@JSName("BorderContainer")
trait BorderContainer extends DojoComponent {
  val id: String = ???
  def startup(): Unit = ???
}

object BorderContainer {
  def apply(id: String)(implicit borderContainer: js.Dynamic) = jsnew(borderContainer)(js.Dictionary(), id).asInstanceOf[BorderContainer]
  val require = "dijit/layout/BorderContainer"
}


