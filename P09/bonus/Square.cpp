#include "Square.h"

    Square::Square(double side) 
        : _side{side} {}

    std::string Square::name() {
        return std::to_string(_side) + " Square " + '\n';
    }
    
    double Square::area() {
        return _side * _side;
    }
