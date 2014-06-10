package dgrid

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import js.Dynamic.{global => g, newInstance => jsnew, literal => lit}
import dojo.DojoComponent

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


