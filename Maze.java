import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Maze {
   private Square[][] maze;
   private Square start;
   private Square end;

   public Maze(){}

   public boolean loadMaze(String fileName) {
       try {
           File file = new File(fileName);
           Scanner reader = new Scanner(file);
           int numRows = reader.nextInt(); //first line
           int numCols = reader.nextInt();
           maze = new Square[numRows][numCols];

           for (int i = 0; i < numRows; i++){//scan maze
               for (int j = 0; j < numCols; j++){
                   maze[i][j] = new Square(i, j, reader.nextInt());
                   if (maze[i][j].getType() == 2)
                       this.start = maze[i][j];
                   else if(maze[i][j].getType() == 3){
                       this.end = maze[i][j];
                   }
               }
           }

           return true;
       }
       catch(FileNotFoundException e){
           return false;
       }
   }

   public List<Square> getNeighbors(Square s){
       List<Square> neighbors = new ArrayList<>();
       int row = s.getRow();
       int col = s.getCol();

       if(row - 1 >= 0 && maze[row-1][col].getType() != 1)
           neighbors.add(maze[row-1][col]); //left

       if(row + 1 < maze.length && maze[row+1][col].getType() != 1)
           neighbors.add(maze[row+1][col]); //right

       if(col - 1 >= 0 && maze[row][col-1].getType() != 1)
           neighbors.add(maze[row][col-1]); //top

       if(col + 1 < maze[0].length && maze[row][col+1].getType() != 1)
           neighbors.add(maze[row][col+1]); //bottom


       return neighbors;
   }

   public Square getStart(){
       return start;
   }

   public Square getExit(){
       return end;
   }

   public Square getSquare(int row, int col){
       return maze[row][col];
   }
   

   public void reset(){
       for(int i = 0; i < maze.length; i++){
           for(int j = 0; j < maze[i].length; j++){
               if(maze[i][j].getType() == 0){
                   maze[i][j].setStatus('_');
               }
           }
       }
   }

   public String toString(){
       String mazeString = "";
       for(int i = 0; i < maze.length; i++){
           for(int j = 0; j < maze[i].length; j++){
               mazeString += maze[i][j].toString() + " ";
           }
           mazeString += "\n";
       }

       return mazeString;
   }
}