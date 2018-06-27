import org.scalatest.FlatSpec

import com.github.fasttext.fasttext
import com.github.fasttext.fastvec
import org.scalactic.TolerantNumerics
import org.scalactic.Equality

class fasttextTest extends FlatSpec {


  val filePath = "data/loremipsum/loremModel.bin"
  val filePathVec = "data/loremipsum/loremModel.vec"
  val fastModel = new fasttext(filePath)
  val fastVec = new fastvec(filePathVec)

  def checkWord(word : String) : Boolean = {
    (fastModel.getWordVector(word) - fastVec.getWordVector(word))
      .toArray.map(_.abs).max < 0.00005
  }

  "Word vectors" should "match predefined values - sample" in {

    assert(checkWord("vitae"))
    assert(checkWord("metus"))
    assert(checkWord("euismod"))
    assert(checkWord("condimentum"))
    assert(checkWord("curae;"))

  }

  "Word vector '</s>' (EOS)" should "match predefined values" in {
    assert(checkWord("</s>"))
  }

  "All word vectors" should "match predefined values" in {
    assert(fastVec.data.keys.forall(x => checkWord(x)))
  }


}
