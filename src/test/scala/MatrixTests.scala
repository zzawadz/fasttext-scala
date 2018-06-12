import org.scalatest.FlatSpec

import com.github.fasttext.readutils.BinaryReader
import com.github.fasttext.utils.Args
import com.github.fasttext.utils.Dictionary
import com.github.fasttext.utils.Matrix
import org.scalactic.TolerantNumerics

class MatrixTests extends FlatSpec {

  "Parameters" should "match predefined values" in {

    val filePath = "data/wiki.pl/wiki.pl.bin"
    val reader = new BinaryReader(filePath)
    val args   = new Args(reader)
    val dict   = new Dictionary(args, reader)

    val mat = new Matrix(reader)

    assert(mat.quant_ == 0)
    assert(mat.m_ == 3032577)
    assert(mat.n_ == 300)

    implicit val floatEq = TolerantNumerics.tolerantFloatEquality(0.0001f)

    assert(mat.data(0)(0) === -0.00276645f)
    assert(mat.data(1)(0) === 0.053267f)
    assert(mat.data.last.last === 0.24957f)
  }

}