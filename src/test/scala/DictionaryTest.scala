import org.scalatest.FlatSpec
import com.github.fasttext.readutils.BinaryReader
import com.github.fasttext.utils.{Args, Dictionary}

class DictionaryTest extends FlatSpec {

  "Parameters" should "match predefined values" in {

    val filePath = "data/wiki.pl/wiki.pl.bin"
    val reader = new BinaryReader(filePath)
    val args   = new Args(reader)
    val dict   = new Dictionary(args, reader)

    val wordsIdxs = dict.getSubwords("scala")

    val target : Array[Int] = Array(32937, 1828514, 2069569, 3026629, 1748544, 2157591, 1229711,
    1084350, 2622266, 1626048, 2536187, 2143885, 1690100, 1269816,
    1523105)

    assert(wordsIdxs.zip(target).forall{case (x, y) => x == y})

  }

}