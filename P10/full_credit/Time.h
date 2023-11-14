#ifndef __TIME_H
#define __TIME_H

#include <iostream>
#include <iomanip>
#include <sstream>

class Time {
	
	public:
	    Time(int hour = 0, int minute = 0, int second = 0);
		Time operator+(Time time);
		Time& operator++();
		Time operator++(int);
		inline bool operator==(const Time& time) {return (compare(time) == 0);}
		inline bool operator!=(const Time& time) {return (compare(time) != 0);}
		inline bool operator<(const Time& time) {return (compare(time) < 0);}
		inline bool operator>(const Time& time) {return (compare(time) > 0);}
		inline bool operator<=(const Time& time) {return (compare(time) <= 0);}
		inline bool operator>=(const Time& time) {return (compare(time) >= 0);}
		friend std::ostream& operator<<(std::ostream& ost, const Time& time);
		friend std::istream& operator>>(std::istream& ist, Time& time);
		
	private:
		int _hour;
		int _minute;
		int _second;
		
		void rationalize();
		int compare(Time time);
	
};

#endif
