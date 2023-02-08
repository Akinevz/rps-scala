package com.kine.game

import scala.collection.mutable.ArrayBuffer

class Pool[T] {
  
  var buffer: ArrayBuffer[T] = ArrayBuffer()

  def +=(elem: T): Integer = {
    this.buffer += elem
    this.buffer.length
  }

}
