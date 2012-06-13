package compile_time_fibonacci

import language.experimental.macros
import scala.reflect.makro._
import scala.reflect.api._

object MacroDef{

  def timer[T](f : => T):T = {
    val start = System.currentTimeMillis
    val r = f
    println((System.currentTimeMillis - start) + " mililis elapsed")
    r
  }

  val ZERO = BigInt(0)
  val ONE  = BigInt(1)

  private def fib(n:Int):BigInt = {
    require(n >= 0)
    def f(x:BigInt):BigInt = x match {
      case ZERO => x
      case ONE  => x
      case _    => f(x-1) + f(x-2)
    }
    f(n)
  }

  def fibmacro(a:Int):Long = macro fibmacroImpl

  def fibmacroImpl(c:Context)(a:c.Expr[Int]):c.Expr[Long] = {
    import c.universe._
    val Literal(Constant(i:Int)) = a.tree
    println("start compile time fibonacci calculate")
    val result = timer{ fib(i).longValue }
    println("finish compile time fibonacci calculate")
    println("fibonacci " + c + " = " + result)
    c.Expr(Literal(Constant(result)))
  }
}
