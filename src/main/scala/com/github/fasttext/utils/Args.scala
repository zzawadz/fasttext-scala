package com.github.fasttext.utils

import com.github.fasttext.readutils.BinaryReader

class Args(fastTextParser : BinaryReader) {

  val dim   : Int = fastTextParser.extractNextInt()
  val ws    : Int  = fastTextParser.extractNextInt()
  val epoch : Int = fastTextParser.extractNextInt()
  val minCount : Int = fastTextParser.extractNextInt()
  val neg      : Int = fastTextParser.extractNextInt()
  val wordNgrams : Int = fastTextParser.extractNextInt()
  val loss   : Int = fastTextParser.extractNextInt()
  val model  : Int = fastTextParser.extractNextInt()
  val bucket : Int = fastTextParser.extractNextInt()
  val minn  :  Int = fastTextParser.extractNextInt()
  val maxn  :  Int = fastTextParser.extractNextInt()
  val lrUpdateRate : Int = fastTextParser.extractNextInt()
  val t : Double = fastTextParser.extractNextDouble()

}
