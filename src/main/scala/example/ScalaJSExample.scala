package example

import scala.scalajs.js
import js.annotation.JSExport
import org.scalajs.dom
import scala.scalajs.js.annotation.JSName
import js.Dynamic.{global => g, newInstance => jsnew, literal => lit}

@JSName("THREE.Scene")
class ThreeScene

trait OnDemandGrid extends js.Object {
  def renderArray(data: Any) = ???
}

case class Grid(id: String, columns: List[ColumnDef])(implicit grid: js.Dynamic) {
  private var wrapped: js.Dynamic = null

      //val rows = js.Array(js.Dictionary("first" -> "Fred", "last" -> "Barking", "age" -> 89),
      //  js.Dictionary("first" -> "Vanna", "last" -> "Green", "age" -> 55))

      val cols = js.Dictionary("columns" -> js.Dictionary(columns.map(col => (col.fieldName, col.title)): _*))
      val gr = jsnew(grid)(cols, id)
      //gr.renderArray(rows)
      wrapped = gr

  def renderArray(data: List[Map[String, Any]]) = {
    require(wrapped != null)
    val records = data.map(m => m.map(pair => (pair._1, pair._2)))

    val rows = js.Array(records: _*)

    val rows2 = js.Array(js.Dictionary("first" -> "Fred", "last" -> "Barking", "age" -> 89),
        js.Dictionary("first" -> "Vanna", "last" -> "Green", "age" -> 55))
     wrapped.renderArray(rows2)
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

    val x = jsnew(g.Date)()

    val scene = (new ThreeScene).asInstanceOf[js.Dynamic]

    val threeS = scene.asInstanceOf[ThreeScene]

    // dom.alert("Here")


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
        val gr = Grid("grid2", List(ColumnDef("first", "First Name"), ColumnDef("last", "Last Name"), ColumnDef("age", "Age")))(grid)
        gr.renderArray(List(Map("first" -> "Fred", "last" -> "Barkingdog", "age" -> 89),
          Map("first" -> "Vanna", "last" -> "Green", "age" -> 55)))
    })

  }
}

