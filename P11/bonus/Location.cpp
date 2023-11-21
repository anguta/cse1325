#include "Location.h"

Location::Location(std::string filename, int line) 
: _filename{filename}, _line{line} {}

int Location::compare(const Location& location) const {
    if(_filename < location._filename) return -1;
    if(_filename > location._filename) return 1;
    if(_line < location._line) return -1;
    if(_line > location._line) return 1;
    return 0;
	
}

std::string Location::last_filename;

void Location::next_word() {
    last_filename = "";
}

std::ostream& operator<<(std::ostream& ost, const Location& location) {

    if(location._filename != Location::last_filename) {
        ost << location._filename << " line ";
        Location::last_filename = location._filename;
    }
    ost << location._line;
    // ost << location._filename << " line " << location._line;
	
    return ost;
}

