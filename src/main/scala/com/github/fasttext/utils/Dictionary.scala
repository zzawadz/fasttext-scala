package com.github.fasttext.utils

import com.github.fasttext.readutils.BinaryReader
import com.github.fasttext.utils.functions

class Dictionary(val args : Args, fastTextParser : BinaryReader) {

  val MAX_VOCAB_SIZE : Int = 30000000


  val size : Int = fastTextParser.extractNextInt()
  val nwords : Int = fastTextParser.extractNextInt()
  val nlabels : Int = fastTextParser.extractNextInt()
  val ntokens : Long = fastTextParser.extractNextLong()
  val pruneidxSize : Long = fastTextParser.extractNextLong()

  val words : Array[(String, Int, Int)] = (0 until size).
                map(x => fastTextParser.extractNextDictWord()).toArray
  fastTextParser.extractNextBool()


  // init word2int_
  val word2intsize : Int = Math.ceil(size / 0.7).toInt
  val word2int_ : Array[Int] = Array.fill(word2intsize){-1}
  for(i <- 0 until size) word2int_(find(words(i)._1)) = i


  val BOW : String = "<"
  val EOW : String = ">"
  val EOS : String = "</s>"

  def getSubwords(word : String): Array[Int] = {

    if(word == EOS) {
      Array[Int](0)
    } else {
      val i = getId(word)

      val prefix = if(i >= 0) Array(i) else Array()

      val subwords = functions.computeSubwords(BOW + word + EOW, args.minn, args.maxn)
      val hashArray = subwords.map(x => (nwords + functions.hash(x) % args.bucket).toInt).toArray
      prefix ++ hashArray
    }

  }


  def find(w : String): Int = find(w, functions.hash(w))
  def find(w : String, h : Long): Int = {

    var id = (h % word2intsize).toInt
    while ( {
      (word2int_(id) != -1) && (words(word2int_(id))._1 != w)
    }) id = (id + 1) % word2intsize
    id
  }

  def getId(w : String) : Int = {
    val h : Int = find(w)
    word2int_(h)
  }

}
