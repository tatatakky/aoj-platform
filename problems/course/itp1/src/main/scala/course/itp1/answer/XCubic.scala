package course.itp1.answer

import cats.Monad
import cats.implicits._
import course.itp1.UseCase
import course.itp1.answer.XCubic.{InputData, OutputData}

class XCubic[F[_]](implicit F: Monad[F]) extends UseCase[F, InputData, OutputData] {
  def program(input: InputData): F[OutputData] =
    for {
      bool <- constraints(input)
      res  <- if(bool) cube(input.v) else zero
    } yield OutputData(res)

  def constraints(input: InputData): F[Boolean] = F.pure[Boolean]( 1 <= input.v && input.v <= 100 )

  private def cube(v: Int): F[Int]    = F.pure[Int]( v*v*v )
  private def zero: F[Int]            = F.pure[Int]( 0 )
}

object XCubic {
  case class InputData(v: Int)
  case class OutputData(v: Int)
}