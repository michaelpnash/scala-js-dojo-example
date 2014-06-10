package dijit.layout

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import js.Dynamic.{global => g, newInstance => jsnew, literal => lit}
import dojo.DojoComponent

@JSName("ContentPane")
trait ContentPane extends DojoComponent {
  val id: String = ???
  var region: String = ???
  var selected: Boolean = ???
  var title: String = ???
}

object ContentPane {
  def apply(id: String)(implicit contentPane: js.Dynamic) = jsnew(contentPane)(js.Dictionary("id" -> id)).asInstanceOf[ContentPane]
}


