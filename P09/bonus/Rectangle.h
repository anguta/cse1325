#ifndef _RECTANGLE_H
#define _RECTANGLE_H

#include "Shape.h"

class Rectangle : public Shape {

    public:
        Rectangle(double height, double width);
        
        virtual std::string name() override;
        virtual double area() override;

    private:
        double _height;
        double _width;

};

#endif
