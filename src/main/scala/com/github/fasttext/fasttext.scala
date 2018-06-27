package com.github.fasttext

import breeze.linalg.DenseVector
import com.github.fasttext.readutils.BinaryReader
import com.github.fasttext.utils.{Args, Dictionary, Matrix}

class fasttext(val filePath : String) {

  val reader = new BinaryReader(filePath)
  val args   = new Args(reader)
  val dict   = new Dictionary(args, reader)

  val mat = new Matrix(reader)
  val matOut = new Matrix(reader)

  def getWordVector(word : String) : DenseVector[Float] = {
    val wordVecsTmp = dict
      .getSubwords(word)
      .map(i => mat.getRow(i))
    val wordVec = wordVecsTmp.reduce(_ + _) * (1.0 / wordVecsTmp.length).toFloat
    wordVec
  }

}
