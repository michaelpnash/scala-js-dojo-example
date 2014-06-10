package example

import scala.scalajs.js
import js.annotation.JSExport
import org.scalajs.dom
import scala.scalajs.js.annotation.JSName
import js.Dynamic.{global => g, newInstance => jsnew, literal => lit}
import org.scalajs.dom.HTMLElement

@JSName("THREE.Scene")
class ThreeScene

trait DojoComponent extends js.Object {
  def addChild(child: DojoComponent): Unit = ???
  def domNode: HTMLElement = ???
}

@JSName("BorderContainer")
trait BorderContainer extends DojoComponent {
  val id: String = ???
  def startup(): Unit = ???
}

object BorderContainer {
  def apply(id: String)(implicit borderContainer: js.Dynamic) = jsnew(borderContainer)(js.Dictionary(), id).asInstanceOf[BorderContainer]
}

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

@JSName("Grid")
trait OnDemandGrid extends DojoComponent {
  def renderArray(data: js.Object): Any = ???

  def save(): Unit = ???

  def revert(): Unit = ???

  val id: String = ???
}

@JSName("TabContainer")
trait TabContainer extends DojoComponent {
  val id: String = ???
}

object TabContainer {
  def apply(region: String)(tabContainer: js.Dynamic) = jsnew(tabContainer)(js.Dictionary("region" -> region)).asInstanceOf[TabContainer]
}

object OnDemandGrid {
  def apply(id: String, columns: List[ColumnDef])(implicit grid: js.Dynamic) =
    jsnew(grid)(js.Dictionary("columns" -> js.Dictionary(columns.map(col => (col.fieldName, col.title)): _*)), id).asInstanceOf[OnDemandGrid]
}

case class ColumnDef(fieldName: String, title: String)

@JSExport
object ScalaJSExample {
  @JSExport
  def main(): Unit = {

    val bc = dom.document.createElement("div")
    bc.id = "bordercontainer"
    dom.document.body.appendChild(bc)
    bc.style.height = "700px"

    g.require(Array[String]("dijit/layout/BorderContainer",
      "dijit/layout/ContentPane",
      "dgrid/Grid",
      "dijit/layout/TabContainer",
      "dojo/domReady!"), {
      (bc: js.Dynamic, contentPane: js.Dynamic, grid: js.Dynamic, tabContainer: js.Dynamic) =>
        val cont2 = BorderContainer("bordercontainer")(bc)

        val top = ContentPane("top")(contentPane)
        top.region = "top"
        top.domNode.innerHTML = "<h1>Dojo Scala.js application - development version</h1>"
        g.console.log("Region of top:" + top.region)
        cont2.addChild(top)

        val center = ContentPane("center")(contentPane)
        center.region = "center"
        cont2.addChild(center)
        cont2.startup()

        val tabs = TabContainer("t")(tabContainer)
        val tabOne = ContentPane("tc")(contentPane)
        tabOne.title = "One"
        tabs.addChild(tabOne)

        cont2.addChild(tabs)

        val odg = OnDemandGrid("grid3", List(ColumnDef("name", "Name"), ColumnDef("rank", "Rank"), ColumnDef("serial", "Serial Number")))(grid)

        val army = Array(new Soldier("Fred", "Barkers", 89), new Soldier("Vanna", "Blue", 55),
          new Soldier("Pat", "Sajak", 65))
        center.addChild(odg)

        odg.renderArray(army)
    })

  }
}

@JSExport
class Soldier(val _name: String, val _rank: String, val _serial: Int) {
  @JSExport
  val name = _name
  @JSExport
  val rank = _rank
  @JSExport
  val serial = _serial
}

