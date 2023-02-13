package com.kine.game

import scala.collection.mutable.ArrayBuffer

class Pool[T](var buffer: ArrayBuffer[T]) extends Iterable[T] {
  def +=(elem: T): Integer = {
    this.buffer += elem
    this.buffer.length
  }

  override def iterator: Iterator[T] = buffer.iterator
}

object Pool {
  def apply[T](seq: Seq[T]): Pool[T] = new Pool(ArrayBuffer(seq: _*))
  def apply[T](): Pool[T] = new Pool(ArrayBuffer())
}
