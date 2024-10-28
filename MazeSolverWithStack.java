public class MazeSolverWithStack extends MazeSolver{
      private MyStack stack;
    
    public MazeSolverWithStack(Maze maze){
        super(maze);
    }
    
    public void makeEmpty(){
        System.out.println("default constructor to initialize "  +
        "stack with default capacity");
        super.setStack(new MyStack());
    }
    
    public boolean isEmpty(){
        return (stack.isEmpty());
    }
    
    public void add(Square s){
        stack.push(s);
        System.out.println(s.toString2());
    }
    
    public Square next(){
        return stack.pop();
    }
    
    public void stepRunner(){
        super.step();
    }
}