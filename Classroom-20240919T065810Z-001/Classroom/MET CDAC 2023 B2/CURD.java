import java.util.*;

class Node {
     int empId;
     String name,gender;
     double salary;
     Node next;

    Node(int id,String na,String gen,double sal)
    {
        empId = id;
        name = na;
        gender = gen;
        salary = sal;
        next = null;
    }
}

    public class CURD {
    Node root;
  
    void createList() {
        root = null;//root is not created but assigned
    }

    void insertRight(int empId,String name,String gender,double salary) {
        Node n = new Node(empId,name,gender,salary);
        if (root == null)
        root = n;
        else 
        {
        Node t = root;
        while (t.next != null)
            t = t.next;
        t.next = n;
    }
    System.out.println("Inserted");
}

    void printList() {
        if (root == null)
            System.out.println("Empty List");
        else {
            Node t = root;
            while (t != null) {
                System.out.print("|" + t.empId +"|->" + "|"+ t.name +"|->" + "|"+  t.gender +"|->" + "|");
                t = t.next;
            }
        }
    }
    void updateemp(int id,String na,String gen,double sal) {
        Node t = root;
        while (t != null) {
            if (t.empId == id) {
                t.name = na;
                t.gender = gen;
                t.salary = sal;
                

            }
            t = t.next;
        }

        }
        void Deleteemp(int id) {
            if (root == null)
                System.out.println("Empty List");
            else {
                Node t = root;
                Node t2 = t;
                while (t != null)// search till key not found
                {
                    if (t.empId == id) {
                        System.out.println("Employee is Present");// print found and exit
                        {// cases
                            if (t == root)// case1
                            {
                                root = root.next;
                            } else if (t.next == null)// case2
                            {
                                t2.next = null;
                            } else// case 3
                            {
                                t2.next = t.next;
                            }
                            System.out.println("Deleted: " + t.empId);
                            break;
                        }
    
                    }
                    t2 = t;
                    t = t.next;
    
                }
                if (t == null) {
                    System.out.println("Not found in list");
                }
            }
        }

            
    void Fatchemp(int id) {
        if (root == null)
            System.out.println("Empty List");
        else {
            Node t = root;
            while (t != null) {
                if (t.empId == id)
                {
                    System.out.println("Employee Id is " + t.empId + "\nEmployee Name " + t.name + "\nEmployee Salary "
                            + t.salary + "\nEmployee Gender " + t.gender);
                    break;
                }
                t = t.next;
            }
        }
    }
    
    public static void main(String[] args) {
            
        CURD obj = new CURD();
        Scanner in = new Scanner(System.in);
        int ch;
        obj.createList();//creating LinkedList
        System.out.println("Enter your choice!");
        do {
            System.out.println("\n1.Insert \n2.Fetch Employee \n3.Print All \n4.Update \n5.Delete \n0.Exit");
            ch = in.nextInt();
            switch (ch) 
                {
                    case 1:
                      System.out.println("Enter Employee record in list");
                      System.out.println("Enter Employee ID");
                      int empId = in.nextInt();
                      System.out.println("Enter Employee Name");
                      String name =in.next();
                      System.out.println("Enter Employee Gender");
                      String gender =in.next();
                      System.out.println("Enter Employee Salary");
                      double salary =in.nextDouble();
                      obj.insertRight(empId, name, gender, salary);
                      System.out.println("Record Inserted");
                      break;
                      
                    case 2:
                      System.out.println("Enter Eid:");
                      int e1 = in.nextInt();
                      obj.Fatchemp(e1);
                      break;

                    case 3:
                      obj.printList();
                      break;
                    
                    case 4:
                      System.out.println("Enter Emp id:");
                      int e = in.nextInt();
                      System.out.println("Enter Name:");
                      String n1 = in.next();
                      System.out.println("Enter Gender:");
                      String g1 = in.next();
                      System.out.println("Enter Salary:");
                      double sal1 = in.nextDouble();
                      obj.updateemp(e, n1, g1, sal1);
                      break;
                      
                    case 5:
                      System.out.println("Enter Emp id:");
                      int e2 = in.nextInt();
                      obj.Deleteemp(e2);
                      break;


                    default:
                      System.out.println("Wrong Input");
                    break;
                }
        
            }while(ch!=0);
    }
}

