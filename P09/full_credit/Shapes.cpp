#include <iostream>
#include <vector>

#include "Rectangle.h"
#include "Circle.h"
#include "Shape.h"

int main() {
    
    std::vector<Shape*> shapes = {new Circle{3.0}, new Rectangle{3.0, 4.0}};
    
    /* Circle circle(3.0);
    Rectangle rectangle(3.0, 4.0);
    
    shapes.push_back(&circle);
    shapes.push_back(&rectangle); */
    
    for(auto c : shapes) { 
        std::cout << c->to_string() << '\n';
    }

    return 0;
}
