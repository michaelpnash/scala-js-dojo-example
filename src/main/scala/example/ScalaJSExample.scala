package example

import scala.scalajs.js
import js.annotation.JSExport
import org.scalajs.dom
import org.scalajs.dom.HTMLElement
import scala.scalajs.js.annotation.JSName
import js.Dynamic.{ global => g, newInstance => jsnew, literal => lit }

@JSName("Apple")
trait Apple extends js.Object {
  val `type`: String = ???
  val color: String = ???
}

@JSName("THREE.Scene")
class ThreeScene

@JSName("BorderContainer")
trait BorderContainer extends js.Object {
}

@JSName("ContentPane")
trait ContentPane extends js.Object {
  var region: String = ???
}

class Grid(id: String, columns: List[(String, String)]) {
   def columns(field1: String, label1: String) = Array(lit("field" -> field1, "label" -> label1))
   def columns(field1: String, label1: String, field2: String, label2: String) =
     Array(lit("field" -> field1, "label" -> label1), lit("field" -> field2, "label" -> label2))
   def columns(field1: String, label1: String, field2: String, label2: String, field3: String, label3: String) =
     Array(lit("field" -> field1, "label" -> label1), lit("field" -> field2, "label" -> label2), lit("field" -> field3, "label" -> label3))
   private var wrapped: js.Dynamic = null

   g.require(Array[String]("dgrid/Grid", "dojo/domReady!"), { (grid: js.Dynamic) =>

      val data = Array(
        js.Dynamic.literal(first = "Fred", last = "Barkers", age = 89),
        js.Dynamic.literal(first = "Vanna", last = "Blue", age = 55),
        js.Dynamic.literal(first = "Pat", last = "Sajak", age = 65)
      )

      val cols = lit("columns" -> columns("first", "First Name", "last", "Last Name", "age", "Age"))

      val g = jsnew(grid)(cols, id)
      g.renderArray(data)
      wrapped = g
    })
  def renderArray(e: Array[js.Dynamic]) = ???
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

    dom.alert("Here")

    val apple = jsnew(g.Apple)("type", "red")
    val a = apple.asInstanceOf[Apple]

    dom.alert(a.color)

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

    grid2()

  }

  def grid2() {
    g.require(Array[String]("dgrid/Grid", "dojo/domReady!"), { (grid: js.Dynamic) =>
      val dat = Array(Map("first" -> "Fred", "last" -> "Barker", "age" -> 89))
      val data = Array(
        lit("first" -> "Fred", "last" -> "Barkers", "age" -> 89),
        lit(first = "Vanna", last = "Blue", age = 55),
        lit(first = "Pat", last = "Sajak", age = 65)
      )

      val cols = Array(new ColumnDef("first", "First Name"), new ColumnDef("last", "Last Name"), new ColumnDef("age", "Age"))
      val cd = new Columns(cols)
      val gridCall = js.Dynamic.literal(columns = js.Dynamic.literal(first = "First Name", last = "Last Name", age = "Age"))

      val g = new OnDemandGrid(cd, "grid2")

      g.renderArray(data)
    })
  }

  /** Computes the square of an integer.
   *  This demonstrates unit testing.
   */
  def square(x: Int): Int = x*x
}

@JSExport
class ColumnDef(_field: String, _label: String) {
  @JSExport("field")
  def field: String = _field
  @JSExport("label")
  def label: String = _label
}

@JSExport
class Columns(_columns: Array[ColumnDef]) {
  def columns: Array[ColumnDef] = _columns
}

@JSName("dgrid.OnDemandGrid")
class OnDemandGrid(columns: Columns, id: String) extends js.Object {
  def renderArray(data: Any) = ???
}


