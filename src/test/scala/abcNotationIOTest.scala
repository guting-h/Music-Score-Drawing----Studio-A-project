import io.TuneManager
import org.scalatest.flatspec.AnyFlatSpec

class abcNotationIOTest extends AnyFlatSpec {
  val manager = new TuneManager
  manager.readTune("The Flowers of the Forest.txt")
}
