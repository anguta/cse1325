#ifndef __LOCATION_H
#define __LOCATION_H

#include <iostream>
#include <sstream>

class Location {

    public:
        Location(std::string filename, int line);
        inline bool operator==(const Location& location) const {return (compare(location) == 0);}
        inline bool operator!=(const Location& location) const {return (compare(location) != 0);}
        inline bool operator<(const Location& location) const {return (compare(location) < 0);}
        inline bool operator>(const Location& location) const {return (compare(location) > 0);}
        inline bool operator<=(const Location& location) const {return (compare(location) <= 0);}
        inline bool operator>=(const Location& location) const {return (compare(location) >= 0);}
        friend std::ostream& operator<<(std::ostream& ost, const Location& location);
        static void next_word();

    private:
        std::string _filename;
        int _line;
        static std::string last_filename;
		
        int compare(const Location& location) const;

};

#endif
