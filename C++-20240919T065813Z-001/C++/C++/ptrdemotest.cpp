#include <iostream>
using namespace std;

int main()
{ 
  int num = 100;
  const int* p = &num;
  cout << "Number value " << num << endl;
  *p = *p + 100;  // 200
  cout << "Number value indirect way " << *p << endl;
  return 0;

}
