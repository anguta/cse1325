#ifndef __INDEX_H
#define __INDEX_H

#include <iostream>
#include <sstream>
#include <fstream>
#include <string>
#include <set>
#include <map>
#include "Location.h"

class Index {

    typedef std::string Word;
    typedef std::set<Location> Locations;

    public:
        void add_word(Word word, std::string filename, int line);
        friend std::ostream& operator<<(std::ostream& ost, const Index& index);

    private:
        std::map<Word, Locations> _index;

};

#endif
