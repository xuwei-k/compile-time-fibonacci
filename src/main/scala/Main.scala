package compile_time_fibonacci

object Main{
  import MacroDef._

  def main(args:Array[String]){
    timer{println(fibmacro(38))}
  }
}

