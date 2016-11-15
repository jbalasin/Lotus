package Lotus

object main {
  def main(args:Array[String]) = {
    val data:List[Double] = List.range(1, 10).map (_.toDouble)
    println(data)
    val myM = new Matrix(3,3,data)
  }
}