# compile time fibonacci using scala macros

```
$ sbt11
[info] Loading project definition from /Users/user/compile_time_fibonacci/project
[info] Set current project to compile-time-fibonacci (in build file:/Users/user/compile_time_fibonacci/)
> clean
[success] Total time: 0 s, completed Feb 23, 2012 11:53:52 PM
> compile
[info] Updating {file:/Users/user/compile_time_fibonacci/}compile-time-fibonacci...
[info] Resolving macrodef#macrodef_2.10.0-M2;0.1-SNAPSHOT ...
[info] Resolving org.scala-lang#scala-library;2.10.0-M2 ...
[info] Done updating.
[info] Compiling 1 Scala source to /Users/user/compile_time_fibonacci/target/scala-2.10.0-M2/classes...
{
  val $mr: scala.reflect.mirror.type = scala.reflect.mirror;
  $mr.Literal($mr.Constant(38))
}
start compile time fibonacci calculate
14419 mililis elapsed
finish compile time fibonacci calculate
fibonacci 38 = 39088169
[success] Total time: 19 s, completed Feb 23, 2012 11:54:13 PM
> run
[info] Running compile_time_fibonacci.Main 
39088169
1 mililis elapsed
[success] Total time: 0 s, completed Feb 23, 2012 11:54:16 PM
```

