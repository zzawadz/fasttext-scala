import org.scalatest.FlatSpec

import com.github.fasttext.readutils.BinaryReader
import com.github.fasttext.utils.Args

class ArgsSpec extends FlatSpec {

  "Parameters" should "match predefined values" in {

    val filePath = "data/loremipsum/loremModel.bin"
    val reader = new BinaryReader(filePath)
    val args   = new Args(reader)

    assert(args.dim == 10)
    assert(args.ws == 5)
    assert(args.epoch == 5)
    assert(args.minCount == 5)
    assert(args.neg == 5)
    assert(args.wordNgrams == 1)
    assert(args.loss == 2)
    assert(args.model == 2)
    assert(args.bucket == 2000000)
    assert(args.minn == 3)
    assert(args.maxn == 6)
    assert(args.lrUpdateRate == 100)
    assert(args.t == 1.0E-4)
  }

}