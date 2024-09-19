#include <iostream>
using namespace std;

void myswap(int x, int y)
{
	int temp;
	temp = x;
	x = y;
	y = temp;
}

void pointermyswap(int* x, int* y)
{
	int temp;
	temp = *x;
	*x = *y;
	*y = temp;
}

void referencemyswap(int& x, int& y)
{
	int temp;
	temp = x;
	x = y;
	y = temp;
}

int main()
{
  int num1 = 100;
  int num2 = 200;
  cout << "Before Swapping " << num1 <<" / " << num2 << endl;
  pointermyswap(&num1, &num2);
  referencemyswap(num1, num2);
  cout << "Before After Swapping " << num1 << " / " << num2 << endl;

}
