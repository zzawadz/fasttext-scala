import org.scalatest.FlatSpec

import com.github.fasttext.readutils.BinaryReader
import com.github.fasttext.utils.Args

class ArgsSpec extends FlatSpec {

  "Parameters" should "match values" in {

    val filePath = "data/wiki.pl/wiki.pl.bin"
    val reader = new BinaryReader(filePath)
    val args   = new Args(reader)

    assert(args.dim == 300)

  }

}