public class Runner {
   public static void main(String[] args) {
       Maze test = new Maze();
       test.loadMaze("maze-2");

       System.out.println(test.toString());

       System.out.println(test.getExit().getRow());
       System.out.println(test.getStart().getRow());

       Square temp = test.getSquare(0, 0);

       System.out.println(test.getNeighbors(temp));
   }
}