#include <iostream>

#include "data_structure/array.hpp"

int main()
{
    Array<int> array(4);
    array.AddLast(1);
    array.AddLast(2);
    array.AddLast(3);
    array.AddLast(4);
    
    array.PrintInfo();
    array.AddLast(5);
    array.PrintInfo();

    array.RemoveLast();
    array.RemoveLast();
    array.RemoveLast();
    array.PrintInfo();

    return 0;
}