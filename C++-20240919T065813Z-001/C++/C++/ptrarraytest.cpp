#include <iostream>
using namespace std;

int main()
{
	int marks[] = { 22, 33, 44, 55, 66};
	int* p = marks;
	cout << "First Element = " << *p << endl;

	for(int count = 0; count < 5; count++)
	{
		cout << *(marks++) << endl;
	}
     
	return 0;
}
