//Team crispy-octo-fiesta James Hua, Ruochong Wu
//APCS1 pd10
//HW55 -- Don't Think You Are. Know You Are.
//2016-01-06

/*====================================
  class Matrix -- models a square matrix

  TASK: Implement methods below.
        Categorize runtime of each. 
        Test in your main method.
  ====================================*/ 

public class Matrix {

    //constant for default matrix size
    private final static int DEFAULT_SIZE = 2;

    private Object[][] matrix;


    //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
    public Matrix( ) {
	matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
    }

    
    //constructor intializes an a*a matrix
    public Matrix( int a ) {
	matrix = new Object[a][a];
    }


    //return size of this matrix, where size is 1 dimension
    private int size() {
	return matrix.length;
    }


    //return the item at the specified row & column   
    private Object get( int r, int c ) {
	return matrix[r][c];
    }


    //return true if this matrix is empty, false otherwise
    private boolean isEmpty( int r, int c ) {
	return matrix[r][c] == null;
    }


    //overwrite item at specified row and column with newVal
    //return old value
    private Object set( int r, int c, Object newVal ) {
	Object retval = matrix[r][c];
	matrix[r][c] = newVal;
	return retval;
    }


    //return String representation of this matrix
    // (make it look like a matrix)
    public String toString() {
	String retstr = "";
	for ( Object[] a : matrix){
	    for ( Object x : a){
		retstr+= x + "\t";
	    }
	    retstr+="\n";
	}
	return retstr;
    }


    //override inherited equals method
    //criteria for equality: matrices have identical dimensions,
    // and identical values in each slot
    public boolean equals( Object rightSide ) {      
	boolean foo = false;
	if (this == rightSide){
	    foo = true;
	}
	
	else if ( rightSide instanceof Matrix
		  && size() == ( ( Matrix)rightSide).size() ){
	    Matrix r = (Matrix)rightSide;
	    foo = true;
	    for( int i = 0; i < size() ; i++){
		for( int j = 0; j < size(); j++){
		    if ( !isEmpty(i,j) && ( !get(i,j).equals(r.get(i,j)))){
			foo = false;
			break;
		    }
		    else if ( !(isEmpty(i,j) && r.isEmpty(i,j))){
			foo = false;
			break;		        
		    }
		}
		break;
	    }
	    
	}
	return foo;	

    }

    //swap two columns of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapColumns( int c1, int c2 ) {
	for ( int x = 0; x < matrix.length; x++){
	    set(x,c1,set(x,c2,matrix[x][c1]));
	}
    }

    //swap two rows of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapRows( int r1, int r2  ) {
	for ( int x = 0; x < matrix.length; x++){
	    set(r1,x,set(r2,x,matrix[r1][x]));
	}
    }

    public boolean isFull(){
	for ( int a = 0; a < size(); a++){
	    for ( int b = 0; b < size(); b++){
		if ( isEmpty(a,b)){
		    return false;
		}
	    }
	}
	return true;
    }
		
    public Object[] getRow( int r){
	return matrix[r];
    }
    
    public Object[] setRow( int r, Object[] newRow){
	Object[] temp = getRow(r);
	matrix[r]= newRow;
	return temp;
    }
    
    public Object[] getCol (int c){
	Object[] temp = new Object[size()];
	for ( int a = 0; a < size(); a++){
	    temp[a] = matrix[a][c];
	}
	return temp;
    }
    
    public Object[] setCol (int c, Object[] newCol){
	Object[] retcol = getCol(c);
	for ( int x = 0; x < size(); x++){
	    matrix[x][c] = newCol[x];
	}
	return retcol;
    }

    public boolean contains(Object o){
	for (Object[] row : matrix){
	    for (Object elem : row){
		if ((elem!=null)&&(elem.equals(o))){
		    return true;
		}
	    }
	}
	return false;
    }
	
	
    //main method for testing
    public static void main( String[] args ) {
	Matrix yes = new Matrix(3);
	yes.set(0,0,3);
	yes.set(1,1,1);
	yes.set(2,2,"cat");
	yes.set(1,0,"dog");
	System.out.println(yes);
	/*
	System.out.println(yes.isEmpty(0,1));
	System.out.println(yes.isEmpty(0,0));
	System.out.println(yes.get(1,0));
	yes.swapColumns(0,1);
	System.out.println(yes);
	yes.swapColumns(1,2);
	System.out.println(yes);
	yes.swapRows(0,1);
	System.out.println(yes);
	yes.swapRows(1,2);
	System.out.println(yes);
	*/
	Matrix same = new Matrix(3);
	same.set(0,0,3);
	same.set(1,1,1);
	same.set(2,2,"cat");
	same.set(1,0,"dog");

	System.out.println(yes.equals(same));

	Matrix also = new Matrix(3);
	also.set(1,2,"cat");
	also.set(1,0,"dog");

	System.out.println(yes.equals(also));

	Matrix aswell = new Matrix(2);

	System.out.println(yes.equals(aswell));

    	Matrix I = new Matrix(2);
	I.set(0,0,1);
	I.set(0,1,2);
	I.set(1,0,"cat");
	I.set(1,1,"dog");

	Matrix Me = new Matrix(2);
	Me.set(0,0,1);
	Me.set(0,1,2);
	Me.set(1,0,"cat");
	Me.set(1,1,"dog");

	System.out.println(I);
	System.out.println(Me);
	
	System.out.println(I.equals(Me));
	System.out.println(Me.equals(I));

	System.out.println("New tests");

	Matrix test = new Matrix();
	Matrix test2 = new Matrix();
	System.out.println(test.equals(test2));
	test.set(0,0,"hello");
	test2.set(1,0,99);
	System.out.println(test.equals(test2));
	System.out.println(test.contains("hello"));
	System.out.println(test.contains(99));
	System.out.println(test2.contains(99));
	System.out.println(test2.contains("hello"));
	System.out.println(test2);
    }
    
}//end class Matrix
