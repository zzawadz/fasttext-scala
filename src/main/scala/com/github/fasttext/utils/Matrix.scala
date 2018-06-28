package com.github.fasttext.utils

import com.github.fasttext.readutils.BinaryReader
import breeze.linalg.DenseVector

class Matrix(fastTextParser : BinaryReader) {

  val quant_ : Boolean = fastTextParser.extractNextBool()
  val m_ : Long = fastTextParser.extractNextLong()
  val n_ : Int = fastTextParser.extractNextLong().toInt

  fastTextParser.setFloatArraySize(n_)

  val data : Array[DenseVector[Float]] = (0 until m_.toInt)
          .map(x => fastTextParser.extractNextNFloats())
          .toArray

  def getRow(i : Int): DenseVector[Float] = {
    data(i)
  }
}
