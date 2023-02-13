package com.kine

import com.kine.geom.Screen

class CoordinateSuite extends munit.FunSuite {
  test("expected coordinate transformation") {
    val screen = Screen(800, 600)
    val (x, y) = screen(400, 300)
    println(x -> y)

    assertEquals((x, y), (0.5d, 0.5d))

    val screen(x2, y2) = (1,1)
    println(x2 -> y2)
  }
}
