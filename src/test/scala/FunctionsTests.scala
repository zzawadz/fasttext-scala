import org.scalatest.FlatSpec

import com.github.fasttext.utils.functions.hash
import com.github.fasttext.utils.functions.computeSubwords

class FunctionsTests extends FlatSpec {

  "Hash codes" should "match predefined values" in {
    assert(hash("Dictionary") == 1266202965)
    assert(hash("scala") == 2258051773L)
    assert(hash("fasttext") == 1651308888)
  }

  "computeSubwords(scala)" should "match predefined values" in {
    val x : IndexedSeq[String] = Array("sc", "sca", "scal", "ca", "cal", "cala", "al", "ala", "la")
    assert(computeSubwords("scala", 2, 4) == x)
  }

}