package Lotus

class Matrix(length: Int, height: Int, data: List[Double]) {
    var rows: List[List[Double]] = data.grouped(length).toList
    var columns: List[List[Double]] = fillMatrixColumns(length,height,data)
    val dataAsList:List[Double] = data

    def getNumberOfColumns() : Int = {
      columns.length
    }
    
    def getNumberOfRows() : Int = {
      rows.length
    }
    
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
    
    def ^(that:Int): Matrix = {
      this
    }
    
    def /(that:Double):Matrix = {
      val newData = this.dataAsList.map { x => x/that }
      new Matrix(this.getNumberOfRows(),this.getNumberOfColumns(),newData)
    }
    
 // toString method for matrix class //
    def print() : Unit = {
      for(i <- 0 to this.height- 1){
        println(columns(i))
      }
    }    
  // Returns a deep copy of matrix;; not yet implemented //
    def copy(): Matrix = {
      this
    }
    
}

class DataMismatchError(message:String =  "Out of Bounds")extends Exception{
  
}
