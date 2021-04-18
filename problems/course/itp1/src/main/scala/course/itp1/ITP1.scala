package course.itp1

import cats.effect.IO
import cats.effect.unsafe.implicits.global
import course.itp1.answer._

object ITP1 {

  def execute: Unit = {
    println( "Rectangle: " + rectangle )
  }

  private def rectangle: (Int, Int) = new Rectangle[IO].program(3, 5).unsafeRunSync()
}
