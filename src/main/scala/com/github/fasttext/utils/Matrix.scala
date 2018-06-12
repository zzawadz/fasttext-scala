package com.github.fasttext.utils

import com.github.fasttext.readutils.BinaryReader

class Matrix(fastTextParser : BinaryReader) {

  val quant_ = fastTextParser.extractNextBool()
  val m_ : Long = fastTextParser.extractNextLong()
  val n_ : Int = fastTextParser.extractNextLong().toInt

  val data : Array[Array[Float]] = (0 until m_.toInt).map(x => fastTextParser.extractNextNFloats(n_)).toArray

}
