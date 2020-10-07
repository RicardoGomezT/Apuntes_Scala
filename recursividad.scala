//================ PATTERN MATCHING =========================

val a1 = "hola" match {
  case "mundo" => "Primero"
  case "hola" => "Segundo"
}
println(a1)

def g(x:Seq[Int]) = x match {
  case List(a, b, c) => a+b+c
  case List(a, b, c, d) => a+b+c+d
  case _ => 0
}
println (g(Seq(1,2,3,5,2)))

def matchTest(x: Int): String = x match {
  case 1 => "one"
  case 2 => "two"
  case _ => "other"
}
println(matchTest(20))


case class Persona(nombre: String, edad:Int) // creación de objetos
val p1= Persona("Richie",27)
val p2= Persona("Sofie",15)

//funcion que recibe un objeto para hacer pattern matching
def h(x: Persona) = x match {
  case x if x.edad >= 18 => println("Es mayor de edad")
  case _ => println("No es mayor de edad")
}
h(p2)

//================ TAIL RECURSION =========================
// Optimización de desarrollos

def factorial_no_optimizado (n: Long): Long = 
  if (n==0){
    println(s"Terminó ${n}")
    1
  }else{
    println(s"Va calculado ${n}")
    n * factorial_no_optimizado(n-1)
  }
println (factorial_no_optimizado(5))

def factorial_optimizado (n: Long, resultado: Long = 1L): Long = 
  if (n==0){
    println(s"Terminó ${n}")
    resultado
  }else{
    println(s"Va calculado ${n}")
    factorial_optimizado(n-1, n*resultado)
  }

println (factorial_optimizado(5))

// =============== AGREGACION ================================
// FoldLeft y FoldRight : Acumuladores

val resultado = (1 to 3).foldLeft(1L)((r,n)=>r*n) //r: acumulador de resultado n: contador
println(resultado)
