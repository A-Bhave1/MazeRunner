import java.util.EmptyStackException;

public class MyStack {
   private Square[] stack;
   private int size;
   //private int initCap; //max cap of stack alb

   public MyStack(){ //sets to 5 as default
       this(5); //ab
       //this.initCap = 5; //alb
       //this.stack = new Square[initCap]; //alb
       //this.size = -1; //alb
   }

   public MyStack(int initCap){
       //this.initCap = initCap; //alb
       this.stack = new Square[initCap];
       this.size = -1;
   }

   public boolean isEmpty(){
       return (stack[0] == null); //ab
       //return size == -1; //alb
   }

   public Square peek(){
       if(isEmpty())
           throw new EmptyStackException();
       else
           return stack[size];
   }

   public Square pop(){
       if(isEmpty())
           throw new EmptyStackException();
       else{
           Square m = stack[size];
           stack[size] = null;
           size--;
           
           return m;
       }
   }

   public void push(Square item){
       if(size + 1 >= stack.length)
           doubleCapacity();
       stack[size+1] = item;
       size++;
   }

   private void doubleCapacity(){
       Square[] temp = new Square[stack.length];
       for(int i = 0; i < temp.length; i++) //makes temp array
           temp[i] = stack[i];

       this.stack = new Square[stack.length*2];
       for(int i = 0; i < temp.length; i++)  // puts all old values into new array
           stack[i] = temp[i];
   }

   public void clear(){
       for(int i = 0; i < size; i++)
           stack[i] = null;
   }

   @Override
   public String toString(){
       String returnString = "[";
       for(int i = 0; i <= size; i++) {
           returnString = returnString + stack[i] + ", ";
       }
        
       return returnString.substring(0,returnString.length()-2) + "]";
   }
}