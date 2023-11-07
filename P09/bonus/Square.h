#ifndef _SQUARE_H
#define _SQUARE_H

#include "Shape.h"

class Square : public Shape {

    public:
        Square(double side);
        virtual std::string name() override;
        virtual double area() override;

    private:
        double _side;

};

#endif
