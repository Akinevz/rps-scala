package com.kine

package object game {
  type GOId = Integer
  type GameObject = Entity with Drawable
  type Entities = Pool[GameObject]
}
