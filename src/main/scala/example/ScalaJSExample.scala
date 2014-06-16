package example

import scala.scalajs.js
import js.annotation.JSExport
import org.scalajs.dom
import dgrid._
import dijit.layout.{BorderContainer, ContentPane, TabContainer}
import dojo.store.{DataStore, JsonRest}
import dgrid.extensions.{DijitRegistry, ColumnResizer}
import dgrid.ColumnDef

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
      DijitRegistry.require,
      "dojo/store/JsonRest",
      "dojo/ready",
      "dojo/domReady!"), {
      (borderContainer: js.Dynamic,
       contentPane: js.Dynamic,
       grid: js.Dynamic,
       tabContainer: js.Dynamic,
       registry: js.Dynamic,
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

        center.addChild(tabs)

        tabs.addChild(tabOne)
        tabs.addChild(tabTwo)

        container.addChild(center)

        val odg = OnDemandGrid("grid3", List(ColumnDef("name", "Name"),
          ColumnDef("rank", "Rank"), ColumnDef("serial", "Serial Number")))(grid)

        val army = Array(new Soldier("Fred", "Barkers", 89), new Soldier("Vanna", "Blue", 55),
          new Soldier("Pat", "Sajak", 65))
        tabOne.addChild(odg)

        odg.renderArray(army)

        val acctDataStore = JsonRest("accounts.json", "code")(jsonRest)
        val acctGrid = CustomGrid("accounts", List(ColumnDef("code", "Code")), acctDataStore)(grid, registry)
        tabTwo.addChild(acctGrid)

        container.startup()
    })

  }
}

trait CustomGrid extends OnDemandGrid with DijitRegistry

object CustomGrid {
  def apply(id: String, columns: List[ColumnDef], store: DataStore)(grid: js.Dynamic, registry: js.Dynamic) =
    jsnew(grid)(js.Dictionary("store" -> store,
      "columns" -> js.Dictionary(columns.map(col => (col.fieldName, col.title)): _*)), id).asInstanceOf[CustomGrid]
}


@JSExport
class Soldier(val _name: String, val _rank: String, val _serial: Int) {
  @JSExport val name = _name
  @JSExport val rank = _rank
  @JSExport val serial = _serial
}

