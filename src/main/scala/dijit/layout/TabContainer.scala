package dijit.layout

import scala.scalajs.js
import js.annotation.JSExport
import org.scalajs.dom
import scala.scalajs.js.annotation.JSName
import js.Dynamic.{global => g, newInstance => jsnew, literal => lit}
import org.scalajs.dom.HTMLElement
import dojo.DojoComponent

@JSName("TabContainer")
trait TabContainer extends DojoComponent {
  val id: String = ???
}

object TabContainer {
  def apply(region: String)(tabContainer: js.Dynamic) = jsnew(tabContainer)(js.Dictionary("region" -> region)).asInstanceOf[TabContainer]
}


