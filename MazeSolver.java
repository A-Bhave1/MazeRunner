import java.util.List;

public abstract class MazeSolver {
    private Maze maze;
    private boolean solved = false;
    private boolean solvable = false;
    private boolean unsolvable = false;
    private MyStack path;
    
    MazeSolver(Maze maze){
        this.maze = maze;
        makeEmpty();
    }
    
    public abstract void makeEmpty();
    
    public abstract boolean isEmpty();
    
    public abstract void add(Square s);
    
    public abstract Square next();
    
    public boolean isSolved(){
        if(solved)
            return true;
        else if(unsolvable)
            return true;
        else
            return false;   
    }
    
    public void step(){
        if(isEmpty()){
            unsolvable = true;
        }
        else{
            Square temp = next();
            
            if(temp == maze.getExit()){
                solved = true;
                return;
            }
            
            List<Square> neighbors = maze.getNeighbors(temp);
            for(int i = 0; i < neighbors.size(); i++){
                if(neighbors.get(i).getStatus() != Square.EXPLORED && neighbors.get(i).getType() != Square.WALL){
                    neighbors.get(i).setStatus(Square.WORKING);
                    add(neighbors.get(i));
                }
            }
            
            maze.getSquare(temp.getRow(),temp.getCol()).setStatus(Square.EXPLORED);
                
        }
        
        
        
        
        
        
        
        /*
        if(isEmpty()){
            unsolvable = true;
        }
        else{
            solvable = true;
            Square temp = path.peek();
            if(temp.equals(maze.getExit())){
                solved = true;
                return;
            }
            else{
                List<Square> neighbors = maze.getNeighbors(temp);
                for(int i = 0; i < neighbors.size(); i++){
                    if(neighbors.get(i).getStatus() != Square.EXPLORED)
                        path.push(neighbors.get(i));
                    
                    Square s = path.pop(); //latest one
                    Square t = path.pop(); //last one
                    if (s.equals(path.peek())){
                        path.pop();
                        path.push(t);
                    }
                    else{
                        path.push(t);
                        path.push(s);
                    }
                    
                    path.peek().setStatus(Square.WORKING);
                    step();
                    
                    path.pop();
                    temp.setStatus(Square.EXPLORED);
                }
                /*
                MyStack stackTemp = new MyStack(neighbors.size());
                for(int i = 0; i < neighbors.size(); i++){
                    stackTemp.push(path.pop());
                }
                stackTemp.pop();
                for(int i = 0; i < neighbors.size(); i++){
                    path.push(stackTemp.pop());
                }
                
               
            }
        }*/
    }
    
    public String getPath(){
        String path = "";
        if(solvable == true)
            path += "Solvable, ";
        
        else if(unsolvable == true)
            path += "Unsolvable, ";
        
        if(solved == true)
            path += "and solved";
        
        else if(solved == false)
            path += "but unsolved";
        
        return path;
    }
    
    public void solve(MyStack path){
        while(solved == false || unsolvable == false){
            step();
        }
    }
    
    public void setStack(MyStack m){
        path = m;
    }
}