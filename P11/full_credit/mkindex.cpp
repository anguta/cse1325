#include <iostream>
#include "Index.h"

int main(int argc, char* argv[]) {

    if(argc < 2) {
        std::cerr << "Usage: " << argv[0] << '\n';
        return -1;
    }
    
    Index index;
    std::string line;
    
    for(int i = 1; i < argc; i++) {
        std::string file{argv[i]};
        std::ifstream ist{file};
        
        int line_number = 0;
        
        if(!ist) {
            std::cerr << "Unable to open file: " << file << '\n';
            return -1;
        }
        
        while(std::getline(ist, line)) {
            std::istringstream s{line};
            std::string word;
            line_number++;
            
            while(s >> word) {
                if(ispunct(word.front())) {
                    word.erase(0,1);
                }
                
                if(ispunct(word.back())) {
                    word.pop_back();
                }
                
                for(char& c : word) {
                    c = std::tolower(c);
                }
                
                index.add_word(word, file, line_number);
            }      
        }
    }
    std::cout << index; 
    return 0; 
}
