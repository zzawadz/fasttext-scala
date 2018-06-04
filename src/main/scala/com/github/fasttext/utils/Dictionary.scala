package com.github.fasttext.utils

import com.github.fasttext.readutils.BinaryReader

class Dictionary(val args : Args, fastTextParser : BinaryReader) {

  val size = fastTextParser.extractNextInt()
  val nwords = fastTextParser.extractNextInt
  val nlabels = fastTextParser.extractNextInt
  val ntokens = fastTextParser.extractNextLong()
  val pruneidxSize = fastTextParser.extractNextLong()

  val words = (0 until size).map(x => fastTextParser.extractNextDictWord())

}
