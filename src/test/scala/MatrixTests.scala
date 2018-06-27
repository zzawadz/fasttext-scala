import org.scalatest.FlatSpec

import com.github.fasttext.readutils.BinaryReader
import com.github.fasttext.utils.Args
import com.github.fasttext.utils.Dictionary
import com.github.fasttext.utils.Matrix
import org.scalactic.TolerantNumerics
import org.scalactic.Equality

class MatrixTests extends FlatSpec {


  val filePath = "data/loremipsum/loremModel.bin"
  val reader = new BinaryReader(filePath)
  val args   = new Args(reader)
  val dict   = new Dictionary(args, reader)

  val mat = new Matrix(reader)
  val matOut = new Matrix(reader)

  implicit val floatEq : Equality[Float] = TolerantNumerics.tolerantFloatEquality(0.0001f)

  "Parameters" should "match predefined values" in {

    assert(!mat.quant_)
    assert(mat.m_ == 2000187)
    assert(mat.n_ == 10)

  }

}
