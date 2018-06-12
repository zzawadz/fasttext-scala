import org.scalatest.FlatSpec
import com.github.fasttext.readutils.BinaryReader
import com.github.fasttext.utils.{Args, Dictionary}

class DictionaryTest extends FlatSpec {

  "Parameters" should "match predefined values" in {

    val filePath = "data/wiki.pl/wiki.pl.bin"
    val reader = new BinaryReader(filePath)
    val args   = new Args(reader)
    val dict   = new Dictionary(args, reader)

  }

}