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
    
	Employee(double ss, double cc, int aa)
	{
		eid = 1000 + (++count);  //
        sal = ss;
		comm = cc;
		age = aa;
	}
	void SetSal(double ss)
	{
		sal = ss;
	}

	double GetSal()
	{
		return sal;

	}
    void PrintEmployee() const
	{
	   cout << "Employee Id " << eid << endl;
	   cout << "Employee Sal " << sal << endl;
	   cout << "Employee Comm " << comm << endl;
	   cout << "Employee Age " << age << endl;
	}

	double AnnualIncome() const
	{
		double income = 0;
        income = (sal + comm) * 12;
		return income;
	}
};

int Employee::count = 0;
//Global Function
/*
double Tax(Employee e)
{
	double income = e.AnnualIncome();
	double tax = (income > 50000) ? (income - 50000) * 0.1 : 0;
    return tax;

}
*/
double Tax(const Employee* e) 
{
	double income = e->AnnualIncome();
	double tax = (income > 50000) ? (income - 50000) * 0.1 : 0;
	e->SetSal(100000);
    return tax;

}


int main()
{
  Employee emp1; // Default contructor is getting called which does not 
                // have any code
  Employee emp2(30000, 6000, 34);
  emp1.PrintEmployee();
  cout << "Annual Income of Employee " << emp1.AnnualIncome() << endl 
       << " and Tax is " << Tax(&emp1) <<endl;
  emp2.PrintEmployee();
  cout << "Annual Income of second Employee " << emp2.AnnualIncome() << endl 
       << " and Tax is " << Tax(&emp2) <<endl
	   << "Sal Income after change " << emp2.GetSal() << endl; 
  return 0;

}




