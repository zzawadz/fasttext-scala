package com.github.fasttext

import scala.io.Source.fromFile
import breeze.linalg.DenseVector

class fastvec(val path : String) {


  val file = fromFile(path).getLines
  val (nwords, dim) = file.take(1).toArray.head.split(" ").map(_.toInt) match {
    case Array(x: Int, y: Int) => (x,y)
  }

  val emptyVector : DenseVector[Float] = DenseVector(Array.fill(dim)(0f))

  val data : Map[String, DenseVector[Float]] = file.toArray.
    map(x => {
      val y = x.split(" ")
      y.head -> DenseVector(y.tail.map(_.toFloat))
    }).toMap

  def getWordVector(word : String) : DenseVector[Float] = {
    data.getOrElse(word, emptyVector)
  }

}
