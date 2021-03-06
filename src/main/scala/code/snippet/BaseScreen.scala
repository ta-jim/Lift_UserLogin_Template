package code
package snippet

import scala.xml.NodeSeq
import net.liftweb._
import common._
import http._
import util.Helpers._
import net.liftweb.http.js.JsCmds

/*
* Base all LiftScreens off this. 
* Currently configured to use bootstrap.
*/
trait BaseScreen extends LiftScreen {
  override def allTemplatePath =
    "templates-hidden" :: "bootstrap-screen" :: Nil
  override val cancelButton =
    super.cancelButton % ("class" -> "btnLogin") % ("tabindex" -> "4") 
  override val finishButton =
    super.finishButton % ("class" -> "btnLogin") % ("tabindex" -> "4")

  def displayOnly(fieldName: => String, html: NodeSeq) =
    new Field {
      type ValueType = String
      override def name = fieldName
      override implicit def manifest = buildIt[String]
      override def default = ""
      override def toForm: Box[NodeSeq] = Full(html)
    }
}