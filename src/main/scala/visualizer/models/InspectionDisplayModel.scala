package visualizer.models

import scala.collection.mutable.ArrayBuffer
import scala.swing._
import scala.swing.event.ActionEvent

class InspectionDisplayModel extends Publisher {
  // TODO: change to tree rather than arraybuffer
  val inspectedWaves = new ArrayBuffer[Waveform]()
  var scale = 2

  // private val reactors = new ArrayBuffer[InspectionDisplayModel.Listener]()

  def addWave(waveform : Waveform, source : Component) : Unit = {
    inspectedWaves += waveform
    publish(WavesAdded(source))
//    reactors.foreach { reactor =>
//      reactor.wavesAdded
//    }
  }

  def zoomIn(source : Component) : Unit = {
    scale *= 2
    publish(ZoomedIn(source))
  }

}

object InspectionDisplayModel {
  trait Listener {
    def wavesAdded
  }
}

case class Marker(id : Int, description: String, timestamp : Long)


// Events
case class WavesAdded(override val source: Component) extends ActionEvent(source)
case class ZoomedIn(override val source: Component) extends ActionEvent(source)