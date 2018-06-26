import org.scalatest.FlatSpec

import com.github.fasttext.readutils.BinaryReader
import com.github.fasttext.utils.Args
import com.github.fasttext.utils.Dictionary
import com.github.fasttext.utils.Matrix
import org.scalactic.TolerantNumerics
import org.scalactic.Equality

class MatrixTests extends FlatSpec {


  "Parameters" should "match predefined values" in {

    val filePath = "data/wiki.pl/wiki.pl.bin"
    val reader = new BinaryReader(filePath)
    val args   = new Args(reader)
    val dict   = new Dictionary(args, reader)

    val mat = new Matrix(reader)
    val matOut = new Matrix(reader)

    assert(!mat.quant_)
    assert(mat.m_ == 3032577)
    assert(mat.n_ == 300)

    implicit val floatEq : Equality[Float] = TolerantNumerics.tolerantFloatEquality(0.0001f)

    assert(mat.data(0)(0) === -0.00276645f)
    assert(mat.data(1)(0) === 0.053267f)
    assert(mat.data.last(mat.n_ - 1) === 0.24957f)

    assert(matOut.data(0)(0) === 0.0211942f)
    assert(matOut.data(1)(0) === -0.0282539f)
    assert(matOut.data.last(mat.n_ - 1) === -0.0868598f)

    val wordVecsTmp = dict
            .getSubwords("scala")
            .map(i => mat.getRow(i))
    val wordVec = wordVecsTmp.reduce(_ + _) * (1.0 / wordVecsTmp.length).toFloat


    println(wordVec)

  }

}