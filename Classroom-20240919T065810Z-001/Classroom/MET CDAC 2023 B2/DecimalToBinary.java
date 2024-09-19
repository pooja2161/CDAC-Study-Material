import java.util.*;
public class DecimalToBinary
{
    int tos,MaxSize,stack[];
    public void createStack(int size)
    {
        tos=-1;
        MaxSize=size;
        stack=new int[MaxSize];
    }
    void push(int e)
    {
        while (e > 0)
        {
            int rem = e % 2;
            tos++;
            stack[tos]=rem;
            e = e / 2;
        }
    }
    void printStack()
    {
        System.out.println("Binary Equivalent:");
        for(int i=tos;i>-1;i--)
            System.out.print(stack[i]);
    }
    public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the number to convert binary to decimal");
      int num = sc.nextInt();
      DecimalToBinary d = new DecimalToBinary();
      d.createStack(num);
      d.push(num);
      d.printStack(); 
    }

    }