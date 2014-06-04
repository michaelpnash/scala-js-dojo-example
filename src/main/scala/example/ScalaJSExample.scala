package example

import scala.scalajs.js
import js.annotation.JSExport
import org.scalajs.dom
import org.scalajs.dom.HTMLElement
import scala.scalajs.js.annotation.JSName
import js.Dynamic.{ global => g, newInstance => jsnew }

@JSName("dgrid.Grid")
class Grid(obj: js.Dynamic, id: String) extends js.Object {
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

    grid2()
  }

  def grid2() {
    g.require(Array[String]("dgrid/Grid", "dojo/domReady!"), { (grid: js.Dynamic) =>
      val data = Array(
        js.Dynamic.literal(first = "Fred", last = "Barkers", age = 89),
        js.Dynamic.literal(first = "Vanna", last = "Blue", age = 55),
        js.Dynamic.literal(first = "Pat", last = "Sajak", age = 65)
      )

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
