package Lotus

class Matrix(length: Int, height: Int, data: List[Double]) {
    var rows: List[List[Double]] = data.grouped(length).toList
    var columns: List[List[Double]] = fillMatrixColumns(length,height,data)
    val dataAsList:List[Double] = data
    val h = height
    val l = length
    
    def getNumberOfColumns() : Int = {
      length
    }
    
    def getNumberOfRows() : Int = {
      height
    }
    
    def get(x:Int,y:Int) : Double = {
      rows(x)(y)
    }
       
    def getColumn(colNum: Int) : List[Double] = {
      var ret = List()
      def inner(ls:List[Double],ind:Int, start:Int, Finish:Int): List[Double] = {
        if(start >= Finish) inner(this.get(start, ind)::ls,ind,start-1,Finish) else ls
      }
      inner(List(),colNum,height-1,0)
    }
    
    def fillMatrixColumns(length:Int,height:Int,data:List[Double]) : List[List[Double]] = {
      if(length * height != data.length) throw new DataMismatchError()
      
      def inner(ls: List[List[Double]],start:Int,stop:Int): List[List[Double]] = {
        if(start >= stop) inner(getColumn(start)::ls,start-1,stop) else ls
      }
      
      
      inner(List(),getNumberOfColumns()-1,0)
    }
    
    def +(that:Matrix): Matrix = {
      val thisVec = new Vector(this.dataAsList)
      val thatVec = new Vector(that.dataAsList)
      val difference = thisVec + thatVec
      
      new Matrix(that.getNumberOfColumns(),that.getNumberOfRows(),difference.vec)
    }
    
    def -(that:Matrix): Matrix = {
      val thisVec = new Vector(this.dataAsList)
      val thatVec = new Vector(that.dataAsList)
      val difference = thisVec - thatVec
      
      new Matrix(that.getNumberOfColumns(),that.getNumberOfRows(),difference.vec)
    }

    def *(that:Matrix): Matrix = {
      var f = for (
        i <- 0 until this.getNumberOfRows();
        j <- 0 until that.getNumberOfColumns()
      ) yield ((new Vector(this.rows(i))) * (new Vector(that.columns(j))))
         
      new Matrix(that.getNumberOfColumns(),this.getNumberOfRows(),f.toList)
    }
    
    def *(that:Double) : Matrix = {
      val newData = this.dataAsList.map { x => x*that }
      new Matrix(this.getNumberOfRows(),this.getNumberOfColumns(),newData)
    }
    
    def transpose() : Matrix = {
     new Matrix(h,l,columns.flatten)   
    }
    
    def ^(that:Int): Matrix = {
      
      def inner(mat:Matrix,count:Int,limit:Int): Matrix = {
        if(count < limit) inner(mat * mat,count + 1,limit) else mat
      }
      inner(this,0,that)
      this
    }
    
    def /(that:Double):Matrix = {
      val newData = this.dataAsList.map { x => x/that }
      new Matrix(this.getNumberOfRows(),this.getNumberOfColumns(),newData)
    }
    
    def getInverse() : Matrix = {
      this / this.getDeterminant()
    }
    
    def getDeterminant() : Double = {
      0
    }
    
    
    // toString method for matrix class //
    def print() : Unit = {
      for(i <- 0 to this.length- 1){
        println(rows(i))
      }
      
    }
    
    // Returns a deep copy of matrix //
    def copy(): Matrix = {
      new Matrix(this.getNumberOfColumns(),this.getNumberOfRows(),this.dataAsList:::List())
    }
    
    

    
}

class DataMismatchError(message:String =  "Out of Bounds")extends Exception{
  
}
