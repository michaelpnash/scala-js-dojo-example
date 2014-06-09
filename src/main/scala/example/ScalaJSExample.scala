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

object BorderContainer extends DojoComponent {
  def apply(parent: String)(implicit borderContainer: js.Dynamic) = jsnew(borderContainer)(js.Dictionary("id" -> parent), parent).asInstanceOf[BorderContainer]
}

@JSName("ContentPane")
trait ContentPane extends DojoComponent {
  val id: String = ???
  var region: String = ???
  var selected: Boolean = ???
  val title: String = ???
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

object OnDemandGrid {
  def apply(id: String, columns: List[ColumnDef])(implicit grid: js.Dynamic) =
    jsnew(grid)(js.Dictionary("columns" -> js.Dictionary(columns.map(col => (col.fieldName, col.title)): _*)), id).asInstanceOf[OnDemandGrid]

}

case class ColumnDef(fieldName: String, title: String)

@JSExport
object ScalaJSExample {
  @JSExport
  def main(): Unit = {
    val paragraph = g.document.createElement("p")
    paragraph.innerHTML = s"<strong>It worked!</strong>"
    g.document.getElementById("playground").appendChild(paragraph)

    val pp = dom.document.createElement("p")

    val playground = g.document.getElementById("playground")
    List(1, 2, 3).foreach {
      i =>
        val elem = g.document.createElement("p")
        elem.innerHTML = s"Here is $i"
        playground.appendChild(elem)
    }

    val scene = (new ThreeScene).asInstanceOf[js.Dynamic]

    val threeS = scene.asInstanceOf[ThreeScene]


    val bc = dom.document.createElement("div")
    bc.id = "bordercontainer"
    dom.document.body.appendChild(bc)
    bc.innerHTML = "<p>bordercontainer div</p>"

     val bc2 = dom.document.createElement("div")
    bc2.id = "bc2"
    dom.document.body.appendChild(bc2)

    g.require(Array[String]("dijit/layout/BorderContainer",
      "dijit/layout/ContentPane",
      "dgrid/Grid",
      "dojo/domReady!"), {
      (borderContainer: js.Dynamic, contentPane: js.Dynamic, grid: js.Dynamic) =>
        val cont2 = jsnew(borderContainer)(js.Dictionary(), "bordercontainer").asInstanceOf[BorderContainer]
        //val cont2 = BorderContainer("bc2")(borderContainer)

//        val pp = dom.document.createElement("p")
//        pp.innerHTML = "testing, testing"
//        cont2.domNode.appendChild(pp)

        //g.console.log("Inner contt2:" + cont2.domNode.innerHTML)

        val top = ContentPane("top")(contentPane)
        top.region = "top"
        top.domNode.innerHTML = "<p>top</p>"
        g.console.log("Region of top:" + top.region)
        cont2.addChild(top)

        val center = ContentPane("center")(contentPane)
        center.region = "center"
        cont2.addChild(center)
        cont2.startup()

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

