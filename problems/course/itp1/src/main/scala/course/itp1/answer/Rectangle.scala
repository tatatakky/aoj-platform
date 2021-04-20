package course.itp1.answer

import cats.Applicative
import course.itp1.UseCase
import course.itp1.answer.Rectangle.{InputData, OutputData}

class Rectangle[F[_]](implicit F: Applicative[F]) extends UseCase[F, InputData, OutputData] {
  def program(input: InputData): F[OutputData] =
    F.ifA( constraints(input) )(
      F.map2( area(input.a, input.b), length(input.a, input.b) )( (a, l) => OutputData((a, l)) ),
      F.pure[OutputData]( OutputData((0, 0)) )
    )

  private def area(a: Int, b: Int): F[Int] = F.pure[Int]( a * b )

  private def length(a: Int, b: Int): F[Int] = F.pure[Int]( 2 * (a + b) )

  def constraints(input: InputData): F[Boolean] =
    F.pure[Boolean]( ( 1 <= input.a && input.a <= 100 ) && ( 1 <= input.b && input.b <= 100 ) )

}

object Rectangle {
  case class InputData(a: Int, b: Int)
  case class OutputData(v: (Int, Int))
}
