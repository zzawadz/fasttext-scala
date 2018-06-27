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

  "Word vectors" should "match predefined values () sample" in {

    fastVec.getWordVector("vestibulum")

    def checkWord(word : String) : Boolean = {
      (fastModel.getWordVector(word) - fastVec.getWordVector(word))
        .toArray.map(_.abs).max < 0.00005
    }

    assert(checkWord("vitae"))
    assert(checkWord("metus"))
    assert(checkWord("euismod"))
    assert(checkWord("condimentum"))
    assert(checkWord("curae;"))

  }

}
