package example

import scala.scalajs.js
import js.annotation.JSExport
import org.scalajs.dom
import dgrid.{OnDemandGrid, ColumnDef}
import dijit.layout.{BorderContainer, ContentPane, TabContainer}
import dojo.store.JsonRest

//import dojo.store.JsonRest
import js.Dynamic.{global => g, newInstance => jsnew, literal => lit}

@JSExport
object ScalaJSExample {
  @JSExport
  def main(): Unit = {

    val bc = dom.document.createElement("div")
    bc.id = "bordercontainer"
    dom.document.body.appendChild(bc)
    bc.style.height = "700px"

    g.require(Array[String](BorderContainer.require,
      ContentPane.require,
      OnDemandGrid.require,
      TabContainer.require,
      "dojo/store/JsonRest",
      "dojo/ready",
      "dojo/domReady!"), {
      (borderContainer: js.Dynamic,
       contentPane: js.Dynamic,
       grid: js.Dynamic,
       tabContainer: js.Dynamic,
       jsonRest: js.Dynamic,
       ready: js.Dynamic) =>

        val container = BorderContainer("bordercontainer")(borderContainer)

        val top = ContentPane("top")(contentPane)
        top.region = "top"
        top.domNode.innerHTML = "<h1>Dojo Scala.js application - development version</h1>"
        container.addChild(top)

        val center = ContentPane("center")(contentPane)
        center.region = "center"
        container.addChild(center)

        val tabs = TabContainer("t")(tabContainer)
        val tabOne = ContentPane("tc")(contentPane)
        tabOne.title = "One"

        val tabTwo = ContentPane("t2")(contentPane)
        tabTwo.title = "Two"
        tabTwo.domNode.innerHTML = "<p>Two</p>"

        center.addChild(tabs)

        tabs.addChild(tabOne)
        tabs.addChild(tabTwo)

        container.addChild(center)

        container.startup()

        val odg = OnDemandGrid("grid3", List(ColumnDef("name", "Name"), 
          ColumnDef("rank", "Rank"), ColumnDef("serial", "Serial Number")))(grid)

        val army = Array(new Soldier("Fred", "Barkers", 89), new Soldier("Vanna", "Blue", 55),
          new Soldier("Pat", "Sajak", 65))
        tabOne.addChild(odg)

        odg.renderArray(army)

      val acctDataStore = JsonRest()(jsonRest)
      g.console.log("At the end" + acctDataStore)
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

