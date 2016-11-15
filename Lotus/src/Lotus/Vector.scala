package Lotus

class Vector(data: List[Double]) {
  var vec: List[Double] = data
  
  def +(that: Vector) : Vector = {
      var res = this.vec zip that.vec map {case (a,b) => a + b}
      new Vector(res)
  }
  
  def *(that: Vector) : Double = {
    var res = this.vec zip that.vec map {case (a,b) => a * b}
    res.sum
  }
  
  def -(that: Vector) : Vector = {
    new Vector(this.vec zip that.vec map {case (a,b) => a - b})
  }
  
  def get(i: Int) : Double = {
    this.vec(i)
  }

}