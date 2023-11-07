#include "Rectangle.h"

    Rectangle::Rectangle(double height, double width) 
        : _height{height}, _width{width} {}
                 
    std::string Rectangle::name() {
        return std::to_string(_height) + "x" +  std::to_string(_width) + " Rectangle " /*+ " with area " + std::to_string(area())*/ + '\n';
    }
        
    double Rectangle::area() {
        return _height * _width;
    }
