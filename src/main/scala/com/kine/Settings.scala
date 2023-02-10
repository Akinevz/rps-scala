package com.kine

import javax.swing.JComponent

// class Settings {
  // var listeners: List[Listener[_]] = List()
  // def register(listener: Listener[_]) = {
    // listeners = listeners appended listener
  // }
  // 
// }

final case class Settings(
    rules:Rules, spawnNumber:Integer, velocity:Double
)

trait Setting[T] {
  def key: String
  def value: T
}

trait Listener[T] {
  def changeHappened(oldSetting: Setting[T], newSetting: Setting[T]): Unit
}