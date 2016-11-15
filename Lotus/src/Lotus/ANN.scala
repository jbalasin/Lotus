package Lotus
import scala.math

class ANN {
  private class Node{
    
  }
  
  def sigmoid(x:Double) : Double = {
    1/(1 + math.exp(-1*x))
  }
  
}