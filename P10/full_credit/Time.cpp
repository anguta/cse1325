#include "Time.h"

Time::Time(int hour, int minute, int second) 
	: _hour{hour}, _minute{minute}, _second{second} {}

Time Time::operator+(Time time) {
    Time test(_hour + time._hour, _minute + time._minute, _second + time._second);
    rationalize();
    return *this;
}

Time& Time::operator++() {
    ++_second;
    rationalize();
    return *this;
}

Time Time::operator++(int) {
    Time result{*this};
    ++(*this);
    
    return result; 
}

std::ostream& operator<<(std::ostream& ost, const Time& time) {
    ost << std::setfill('0') << std::setw(2) << time._hour << ":" << std::setfill('0') << std::setw(2) << time._minute << ":" << std::setfill('0') << std::setw(2) << time._second;
	
    return ost;
}

std::istream& operator>>(std::istream& ist, Time& time) {
    ist >> time._hour >> time._minute >> time._second;
    if(!ist) {
        ist.setstate(std::ios::failbit);
    }
    
    time.rationalize();
    return ist;
}

void Time::rationalize() {
    while(_second > 59) {
        _second -= 60;
        _minute++;
    }
    
    while(_second < 0) {
        _second += 60;
        _minute--;
    }
    
    while(_minute > 59) {
        _minute -= 60;
        _hour++;
    }
    
    while(_minute < 0) {
        _minute += 60;
        _hour--;
    }
    
    while(_hour > 23) {
        _hour -= 24;
    }
    
    while(_hour < 0) {
        _hour += 24;
    }
    
}

int Time::compare(Time time) {
    if(_hour < time._hour) return -1;
    if(_hour > time._hour) return 1;
    if(_minute < time._minute) return -1;
    if(_minute > time._minute) return 1;
    if(_second < time._second) return -1;
    if(_second > time._second) return 1;
    return 0;
	
}
