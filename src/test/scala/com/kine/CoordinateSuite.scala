package com.kine

import com.kine.geom.Screen

class CoordinateSuite extends munit.FunSuite {
  test("expected coordinate transformation") {
    val screen = Screen(800, 600)
    val (x, y) = screen(0.5, 0.5)
    assertEquals((x, y), (400, 300))
    val screen(x2, y2) = (900, 500)
    assert(x2>1)
    assert(y2<1)
    println(x -> y)
  }
}
