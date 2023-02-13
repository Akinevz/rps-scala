package com.kine

import java.util.Timer
import java.util.TimerTask
import java.time.Instant

case class Ticker(rate: FPS)(op: => Unit) {
  def start() = this.thread.scheduleAtFixedRate(() => op, 0, 1000 / rate.fr)

  val thread = new Timer("animation ticker")
}
