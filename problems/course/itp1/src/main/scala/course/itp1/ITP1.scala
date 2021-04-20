package course.itp1

import cats.effect.IO
import cats.effect.unsafe.implicits.global
import course.itp1.answer._

object ITP1 {

  def execute: Unit = {
    println( s"Rectangle: $rectangle" )
    println( s"XCubic: $xCubic" )
  }

  private def rectangle: Rectangle.OutputData = new Rectangle[IO].program( Rectangle.InputData(5, 3) ).unsafeRunSync()
  private def xCubic: XCubic.OutputData       = new XCubic[IO].program( XCubic.InputData(3) ).unsafeRunSync()
}
