package Lotus
import scala.math

class ANN {
  
  val data: Matrix = InputData

  
  private class Node{
    
  }
  
  def sigmoid(x:Double) : Double = {
    1/(1 + math.exp(-1*x))
  }
  
  
  def build_Model(hiddenNodes:Int, iterations:Int = 20000,printLoss:Boolean = false) : Map[String,Matrix] = {
    val r = scala.util.Random
    val dimensions = data.getNumberOfColumns()
    val lim = hiddenNodes * dimensions
    var startingMat = 1 to lim map (_ => r.nextGaussian())
    
    var W1 = new Matrix(hiddenNodes,data.getNumberOfColumns(), startingMat.toList )
    
    var Model:Map[String,Matrix] = Map()
    
    
    
    
    return Model
  }
  
}
