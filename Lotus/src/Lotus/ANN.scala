package Lotus
import scala.math

class ANN {
  
  val data: Matrix = InputData

  
  private class Node{
    
  }
  
  def sigmoid(x:Double) : Double = {
    1/(1 + math.exp(-1*x))
  }
  
  
  def build_Model(hiddenNodes:Int, iterations:Int = 20000,printLoss:Boolean = false,outputDim:Int,inputDim:Int) : Map[String,Matrix] = {
    val r = scala.util.Random
    val dimensions = data.getNumberOfColumns() - 1
    val lim = hiddenNodes * dimensions
    var startingMat = 1 to lim map (_ => r.nextGaussian())
    var startingMat2 = 1 to lim map (_ => r.nextGaussian())
    var W1 = new Matrix(data.getNumberOfColumns(),inputDim, startingMat.toList ) / Math.sqrt(inputDim)
    var b1 = new Vector(List.tabulate(hiddenNodes)(_ => 0.0))
    var W2 = new Matrix(outputDim,data.getNumberOfColumns(),startingMat2.toList) / Math.sqrt(outputDim)
    
    var Model:Map[String,Matrix] = Map()
    
    
    
    
    return Model
  }
  
}
