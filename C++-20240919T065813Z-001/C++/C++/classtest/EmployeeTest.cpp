#include <iostream>
using namespace std;

class Employee
{
  private:
     // Instance fields , allocated in the instance
     int eid;
	 double sal;
	 double comm;
	 int age;
     static int count; // Shared data member, allocated separately
  						// in data section
  public:
    Employee()
	{
		eid = 1000 + (++count);  //
		sal = 15000;
		comm = 5000;
		age = 21;
	}

    void PrintEmployee()
	{
	   cout << "Employee Id " << eid << endl;
	   cout << "Employee Sal " << sal << endl;
	   cout << "Employee Comm " << comm << endl;
	   cout << "Employee Age " << age << endl;
	}

	double AnnualIncome()
	{
		double income = 0;
        income = (sal + comm) * 12;
		return income;
	}
};

int Employee::count = 0;
//Global Function
double Tax(Employee e)
{
	double income = e.AnnualIncome();
	double tax = (income > 50000) ? (income - 50000) * 0.1 : 0;
    return tax;

}


int main()
{
  Employee emp1; // Default contructor is getting called which does not 
                // have any code
  Employee emp2;
  emp1.PrintEmployee(); // method of class on object
  cout << "Annual Income of Employee " << emp1.AnnualIncome() << endl;
  emp2.PrintEmployee();
  cout << "Annual Income of Employee " << emp2.AnnualIncome() << endl;
  return 0;

}




