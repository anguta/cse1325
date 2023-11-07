#include "Circle.h"
     
    Circle::Circle(double radius) 
        : _radius{radius} {}
        
    std::string Circle::name() {
        return "Circle of radius " + std::to_string(_radius) /*+ " with area " + std::to_string(area())*/ + '\n';
    }
            
    double Circle::area() {
        return _radius *  _radius * 3.14159;
    }
