package example

import scala.scalajs.js
import js.annotation.JSExport
import org.scalajs.dom
import scala.scalajs.js.annotation.JSName
import js.Dynamic.{global => g, newInstance => jsnew, literal => lit}

@JSName("THREE.Scene")
class ThreeScene

@JSName("Grid")
trait OnDemandGrid extends js.Object {
  def renderArray(data: js.Object): Any = ???

  def save(): Unit = ???

  def revert(): Unit = ???

  val id: String = ???

  def data(data: List[Map[String, Any]]): js.Object = {

    val records: Seq[js.Dictionary[Any]] = data.map { m =>
      js.Dictionary[Any](m.map(p => (p._1 -> p._2)).toSeq : _*)
    }.toSeq
    val rows = js.Array(records: _*)

    rows
  }
}

object OnDemandGrid {
  def apply(id: String, columns: List[ColumnDef])(implicit grid: js.Dynamic) =
    jsnew(grid)(js.Dictionary("columns" -> js.Dictionary(columns.map(col => (col.fieldName, col.title)): _*)), id).asInstanceOf[OnDemandGrid]

}

case class Grid(id: String, columns: List[ColumnDef])(implicit grid: js.Dynamic) {
  private var wrapped: js.Dynamic = null

      val cols = js.Dictionary("columns" -> js.Dictionary(columns.map(col => (col.fieldName, col.title)): _*))
      val gr = jsnew(grid)(cols, id)

      wrapped = gr

  def renderArray(data: List[Map[String, Any]]) = {

    val records: Seq[js.Dictionary[Any]] = data.map { m =>
      js.Dictionary[Any](m.map(p => (p._1 -> p._2)).toSeq : _*)
    }.toSeq
    val rows = js.Array(records: _*)

     wrapped.renderArray(rows)
  }
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

    g.require(Array[String]("dijit/layout/BorderContainer", "dijit/layout/ContentPane",
      "dojo/domReady!"), {
      (borderContainer: js.Dynamic, contentPane: js.Dynamic) =>
        val cont1 = jsnew(borderContainer)({}, "bordercontainer")
        val pp = dom.document.createElement("p")
        pp.innerHTML = "testing, testing"
        cont1.domNode.appendChild(pp)

        val top = jsnew(contentPane)()
        top.region = "top"
        cont1.addChild(top)
        cont1.startup()
    })

    g.require(Array[String]("dgrid/Grid", "dojo/domReady!"), {
      (grid: js.Dynamic) =>

        val odg = OnDemandGrid("grid3", List(ColumnDef("name", "Name"), ColumnDef("rank", "Rank"), ColumnDef("serial", "Serial Number")))(grid)

//      val data = Array(
//        js.Dynamic.literal(name = "Fred", rank = "Barkers", serial = 89),
//        js.Dynamic.literal(name = "Vanna", rank = "Blue", serial = 55),
//        js.Dynamic.literal(name = "Pat", rank = "Sajak", serial = 65)
//      )

      val army = Array(new Soldier("Fred", "Barkers", 89), new Soldier("Vanna", "Blue", 55),
        new Soldier("Pat", "Sajak", 65))

      odg.renderArray(army)
      g.console.log(odg.id)
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

