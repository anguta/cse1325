#ifndef _SHAPE_H
#define _SHAPE_H

#include <string>

class Shape {

    public:
        virtual std::string name() = 0;
        virtual double area() = 0;
        std::string to_string();

};

#endif
