package com.github.fasttext.utils

object functions {
  def computeSubwords(word : String, minn : Int, maxn : Int) : IndexedSeq[String] = {

    val iter = 0 until word.length
    val sizes = minn to maxn

    iter.flatMap(i => sizes.map(j => (i, j + i))).
      filter(_._2 < word.length + 1).
      map{case (i ,j) => word.substring(i, j)}
  }

  def hash(word : String) : Long = {

    var h : Int = 2166136261L.toInt
    for(w <- word.getBytes) {
      h = (h ^ w) * 16777619
    }

    h & 0xffffffffL // to unsigned
  }
}