import org.scalatest.FlatSpec
import com.github.fasttext.readutils.BinaryReader
import com.github.fasttext.utils.{Args, Dictionary}

class DictionaryTest extends FlatSpec {

  "Parameters" should "match predefined values" in {

    val filePath = "data/loremipsum/loremModel.bin"
    val reader = new BinaryReader(filePath)
    val args   = new Args(reader)
    val dict   = new Dictionary(args, reader)

    val wordsIdxs = dict.getSubwords("scala")

    val target : Array[Int] = Array(
      796124, 1037179, 1994239, 716154, 1125201, 197321,
      51960, 1589876, 593658, 1503797, 1111495, 657710, 237426, 490715)

    assert(wordsIdxs.zip(target).forall{case (x, y) => x == y})

  }

}