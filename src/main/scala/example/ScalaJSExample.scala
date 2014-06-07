package example

import scala.scalajs.js
import js.annotation.JSExport
import org.scalajs.dom
import scala.scalajs.js.annotation.JSName
import js.Dynamic.{ global => g, newInstance => jsnew, literal => lit }

@JSName("THREE.Scene")
class ThreeScene



class Grid(id: String, columns: List[(String, String)]) {
    g.require(Array[String]("dgrid/Grid", "dojo/domReady!"), { (grid: js.Dynamic) =>

      val rows = js.Array(js.Dictionary("first" -> "Fred", "last" -> "Barking", "age" -> 89),
        js.Dictionary("first" -> "Vanna", "last" -> "Green", "age" -> 55))

      val cols = js.Dictionary("columns" -> js.Dictionary("first" -> "First Name", "last" -> "Last Name", "age" -> "Age"))

      g.console.log(rows)

      val gr = jsnew(grid)(cols, "grid2")

    gr.columns = cols
      gr.renderArray(rows)
    })
    def renderArray(data: List[(String, String)]) = ???
}

@JSExport
object ScalaJSExample {
  @JSExport
  def main(): Unit = {
    val paragraph = g.document.createElement("p")
    paragraph.innerHTML = s"<strong>It worked!</strong>"
    g.document.getElementById("playground").appendChild(paragraph)

    val pp = dom.document.createElement("p")

    val playground = g.document.getElementById("playground")
    List(1, 2, 3).foreach { i => 
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
     "dojo/domReady!"), { (borderContainer: js.Dynamic, contentPane: js.Dynamic) =>
      val cont1 = jsnew(borderContainer)({}, "bordercontainer")
      val pp = dom.document.createElement("p")
      pp.innerHTML = "testing, testing"
      cont1.domNode.appendChild(pp)

    val top = jsnew(contentPane)()
    top.region = "top"
    cont1.addChild(top)
     cont1.startup()
   })

    new Grid("foo", null)
    //grid2()

  }

//  def grid2() {
//    g.require(Array[String]("dgrid/Grid", "dojo/domReady!"), { (grid: js.Dynamic) =>
//      val dat = Array(Map("first" -> "Fred", "last" -> "Barker", "age" -> 89))
//      val data = Array(
//        lit("first" -> "Fred", "last" -> "Barkers", "age" -> 89),
//        lit(first = "Vanna", last = "Blue", age = 55),
//        lit(first = "Pat", last = "Sajak", age = 65)
//      )
//
//    val row = Array(js.Dictionary("first" -> "Fred", "last" -> "Barking", "age" -> 89))
//
//      val cols = Array(new ColumnDef("first", "First Name"), new ColumnDef("last", "Last Name"), new ColumnDef("age", "Age"))
//      val cd = (new Columns(cols)).asInstanceOf[js.Dynamic]
//      val gridCall = lit(columns = lit(first = "First Name", last = "Last Name", age = "Age"))
//
//      val gr = jsnew(grid)(gridCall, "grid2")
//      gr.renderArray(row)
//    })
//  }
//
//  /** Computes the square of an integer.
//   *  This demonstrates unit testing.
//   */
//  def square(x: Int): Int = x*x
}

//@JSExport
//class ColumnDef(field: String, label: String)
//
//@JSExport
//class Columns(columns: Array[ColumnDef])
