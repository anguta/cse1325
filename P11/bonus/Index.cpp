#include "Index.h" 

void Index::add_word(Word word, std::string filename, int line) {
    // if(_index.find(word) == _index.end())
    Location location(filename, line);
    _index[word].insert(location);
    
}

std::ostream& operator<<(std::ostream& ost, const Index& index) {
    for(auto& [ word, locations ] : index._index) {
        ost << word << ": ";
        Location::next_word();

        for(auto& location : locations) {
            ost << location << ", ";
        }
	    
        ost << '\n';
	}
	return ost;
}
