package com.github.fasttext.readutils

import java.io.InputStream
import java.nio.ByteBuffer
import java.nio.ByteOrder
import scala.collection.mutable.ArrayBuffer
import java.nio.charset.StandardCharsets
import java.io.{BufferedInputStream, FileInputStream, InputStream}

class BinaryReader(val filePath : String) {

  val inputStream : InputStream = new BufferedInputStream(new FileInputStream(filePath))

  val oneByte : Array[Byte]  = Array[Byte](1)
  val fourBytes : Array[Byte] = Array[Byte](1,1,1,1)
  val eightBytes : Array[Byte] = Array[Byte](1,1,1,1,1,1,1,1)
  inputStream.read(fourBytes)

  val magicNumberLittleEndian : Int = ByteBuffer.wrap(fourBytes).order(ByteOrder.LITTLE_ENDIAN).getInt
  val magicNumberBigEndian : Int = ByteBuffer.wrap(fourBytes).order(ByteOrder.BIG_ENDIAN).getInt


  val FASTTEXT_FILEFORMAT_MAGIC_INT32 : Int = 793712314
  val FASTTEXT_VERSION : Int = extractNextInt()

  val byteOrder =  if(magicNumberLittleEndian == FASTTEXT_FILEFORMAT_MAGIC_INT32) ByteOrder.LITTLE_ENDIAN
  else if(magicNumberBigEndian == FASTTEXT_FILEFORMAT_MAGIC_INT32) ByteOrder.BIG_ENDIAN
  else throw new Exception

  def extractNextInt() : Int = {
    inputStream.read(fourBytes)
    ByteBuffer.wrap(fourBytes).order(byteOrder).getInt
  }

  def extractNextLong() : Long = {
    inputStream.read(eightBytes)
    ByteBuffer.wrap(eightBytes).order(byteOrder).getLong
  }

  def extractNextDouble() : Double = {
    inputStream.read(eightBytes)
    ByteBuffer.wrap(eightBytes).order(byteOrder).getDouble
  }

  def extractNextString() : String = {

    var x : ArrayBuffer[Byte] = new ArrayBuffer()
    var bt = inputStream.read().toByte

    while(bt == 0) bt = inputStream.read().toByte

    while(bt != 0) {
      if(bt != 0) {
        x += bt
      }
      bt = inputStream.read().toByte
    }

    new String(x.toArray)

  }

  def extractNextDictWord() : (String, Int, Int) = {
    (extractNextString(), extractNextInt(), extractNextInt())
  }


}



  
