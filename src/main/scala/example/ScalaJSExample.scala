package example

import scala.scalajs.js
import js.annotation.JSExport
import org.scalajs.dom
import org.scalajs.dom.HTMLElement
import scala.scalajs.js.annotation.JSName
import js.Dynamic.{ global => g, newInstance => jsnew, literal => lit }

@JSName("Apple")
class Apple extends js.Object {
  val `type`: String = ???
  val color: String = ???
}

@JSName("THREE.Scene")
class ThreeScene


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

    //dom.alert(x.color)

    grid2()

    //new Grid("foo")
  }

  def grid2() {
    g.require(Array[String]("dgrid/Grid", "dojo/domReady!"), { (grid: js.Dynamic) =>
      val data = Array(
        lit(first = "Fred", last = "Barkers", age = 89),
        js.Dynamic.literal(first = "Vanna", last = "Blue", age = 55),
        js.Dynamic.literal(first = "Pat", last = "Sajak", age = 65)
      )

    //{ first : "First Name", last : "Last Name"}

      val gridCall = js.Dynamic.literal(columns = js.Dynamic.literal(first = "First Name", last = "Last Name", age = "Age"))

      val g = jsnew(grid)(gridCall, "grid2")

      g.renderArray(data)
    })
  }

  /** Computes the square of an integer.
   *  This demonstrates unit testing.
   */
  def square(x: Int): Int = x*x
}
