package com.kine

trait Rule[A, B] {
  type Belongs = A
  type Beats = B
}

trait FromRule[A] {
  def beats[B](other: FromRule[B]): Rule[A, B] = new Rule[A, B] {

  }
}

object Rule extends FromRule[Nothing] {
  def apply[A] = this.asInstanceOf[FromRule[A]]
}
