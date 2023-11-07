#include <iostream>
#include <vector>

#include "Rectangle.h"
#include "Circle.h"
#include "Square.h"
#include "Shape.h"

int main() {
    
    std::vector<Shape*> shapes = {new Circle{3.0}, new Rectangle{3.0, 4.0}, new Square{4.0}};
    
    for(auto c : shapes) { 
        std::cout << c->to_string() << '\n';
    }

    return 0;
}
