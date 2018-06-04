import org.scalatest.FlatSpec

import com.github.fasttext.utils.functions.hash


class FunctionsTests extends FlatSpec {

  "Hash codes" should "match predefined values" in {
    assert(hash("Dictionary") == 1266202965)
    assert(hash("scala") == 2258051773L)
    assert(hash("fasttext") == 1651308888)
  }

}