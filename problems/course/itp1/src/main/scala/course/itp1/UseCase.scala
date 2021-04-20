package course.itp1

trait UseCase[F[_], Input, Output] {
  def program(in: Input): F[Output]
  def constraints(in: Input): F[Boolean]
}