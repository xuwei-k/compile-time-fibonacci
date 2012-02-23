package compile_time_fibonacci

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

  def macro fibmacro(a:Int):Long = {
    val Literal(Constant(i:Int)) = a
    println(reify(a))
    println("start compile time fibonacci calculate")
    val result = timer{ fib(i).longValue }
    println("finish compile time fibonacci calculate")
    println("fibonacci " + a + " = " + result)
    Literal(Constant(result))
  }
}
