#ifndef _SHAPE_H
#define _SHAPE_H

#include <string>

class Shape {

    public:
        virtual std::string name();
        virtual double area();
        std::string to_string();

};

#endif
