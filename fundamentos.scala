object HolaMundo{
  def main(): Unit = {
    println("Hola Mundo")
  }
}// El Unit puede entenderse como la unidad o el vacio
HolaMundo.main()

var x: Int = 1 //Mutable se puede actualizar la variable
val y: Int = 2 //Inmutable no se puede actualizar y
def z: Int = 3 //Definición inmutable

// VARIABLES
val u = () // devuelve un Unit = ()

// EXPRESIONES
def xx = (1)
def xxx = {1} //Las tres (x, xx, xxx) devuelven lo mismo y son maneras diferentes de expresar

def zz = {1;0;1+2} // ; me permite escribir varias expresiones, devuelve la ultima
def zzz = (1+2) // con parentesis solo permite escribir una expresión
println (zz)

if (x != 3) println("No es tres") else println("es tres") // si no pongo el else, el devuelve un Any = () si es 3

//==================FUNCIONES (Matematicas)==================================
                
def f(x: Int)= x*x
println (f(56))

//    Funciones anonimas : lambdas
(x:Int) => x * x //devuelte un int pero definicion en lambda
val a = (x:Int) => x * x  // se puede nombrar la función con 'a'
println(a(2))

//    Funciones como objetos: 
a.apply(2) // si tiene nombre la función si no-->
val c = f _ //nombramos a f como c pero no escribimos toda la función, para eso usamos comodin _
println(c.apply(5))

//    Funciones de orden superior : tratar la función como un valor más
def g (h:Int => Int)= h(3) //metimos una funcion dentro de otra asignandole siempre 3 
println(g(f))
def k (h: Int => Int)(x:Int)=h(x)    //encadenar valores de entrada 
println(k(f)(4))

//    Funciones como métodos
object Util{
  def metodo(x:Int) = x+x
  val n= metodo _
}
println(Util.metodo(10))

//Crear una funcion que genere una funcion para calcular si un numero es mayor que el que se le pasó
def isGreater(a1: Int): Int =>  Boolean = {
  (b1: Int) => a1 < b1
}
val ff = isGreater(10)
println (ff(20))

//================== COLECCIONES (Matematicas)==================================

//Listas : inmutables, tipo de dato más basico en PF LIst, Seq, Array
//Conjuntos : los elementos en un conjunto no tienen orden ni repeticiones: Set
//Mapas : Diccionarios, son inmutables :  Map
//Loops en FP : map(), filter(), filterNot(), forEach(), zip(), find()

val a11 = Seq(1,2,3)
val a22 = a11 :+ 4  //appended o val a22 = a11.:+(4)
println (a22) //a22(2) ir al elemento

val c1 = Set(1,20,3) //conjunto inmutable
val c2 = c1 + 4
println (c2(20)) //c2(2) devuelve true, este elemento existe en el conjunto?

val m1 = Map((1, "uno")) //siempre con la doble (()), de lo contrario indicar con flechita ->
val mm1 = Map(1->"one")
val m2 = m1 + ((2, "dos"))
val mm2 = m1 + (2 -> "dos")

val c3 = c2.map(r => r+1)
val m3 = m2.map(r => r+"*.*")
println (c3)

// Tuplas y objetos
println("====TUPLAS ====")
//tuplas: permiten agrupar y manipular datos de diferentes tipos

val tupla= (1, "Richie", false)
println (tupla._2) //para acceder a la tupla

case class persona (id:Int, nombre: String, activo:Boolean)
val persona1 = (2111160, "Ricardo", true)
//val dato = persona1.nombre
//println(dato)

//Funcion copy() : 
//Permite modificar los calores de un objeto sin necesidad de sacar sus datos con apply y tupled
case class A(id: Int) // Dos case class
case class B(id: Int, a: A)
val obj1 = B(1, A(0)) // obj1 es inmutable
val obj2 = obj1.copy(a = obj1.a.copy(1)) // obj2 es la copia con una copia interna modificada.
//Se puede observar que obj1.a.copy no necesita el nombre del atributo puesto que la clase A solo tiene
//uno. En cambio el obj1.copy sí necesita el nombre del atributo debido a que la clase B tiene varios.


//Función Lenses (lentes)
//Un Lens es una función que hace más simple mirar y modificar valores internos dentro de una estructura de 
//datos sin necesidad de demasiado código. Buscar : Quicklens y Monocle