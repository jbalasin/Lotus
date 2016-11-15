package Lotus

class Matrix(length: Int, height: Int, data: List[Double]) {
    var rows: List[List[Double]] = data.grouped(length).toList
    var columns: List[List[Double]] = fillMatrixColumns(length,height,data)
    
    def getColumn(colNum: Int) : List[Double] = {
      var myCol = List()
      var myCopy = rows(0)
      
      Nil
    }
    
    def fillMatrixColumns(length:Int,height:Int,data:List[Double]) : List[List[Double]] = {
      if(length * height != data.length) throw new DataMismatchError()
      Nil
    }
    
    def +(that:Matrix): Matrix = {
      that
    }
    
    def -(that:Matrix): Matrix = {
      that
    }

    def *(that:Matrix): Matrix = {
      that
    }
    
    def ^(that:Matrix): Matrix = {
      that
    }
    
    def print() : Unit = {
      for(i <- 0 to this.height- 1){
        println(columns(i))
      }
      
    }
    
    

    
}

class DataMismatchError(message:String =  "Out of Bounds")extends Exception{
  
}