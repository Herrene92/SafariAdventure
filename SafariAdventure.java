#include <iostream>
#include <string>
#include <cstdlib>
#include <ctime>

using namespace std;

string toLower(string str) {
    for (char &c : str) c = tolower(c);
    return str;
}

int main() {
    srand(time(0)); // Seed random number generator

    const string validAreas[4] = {"jungle", "river", "desert", "mountains"};
    const int TOTAL_DAYS = 5;
    int totalPoints = 0;

    cout << "Welcome to Safari Adventure!" << endl;

    for (int day = 1; day <= TOTAL_DAYS; day++) {
        string area;
        cout << "\nDay " << day << ": Where would you like to explore? (Jungle, River, Desert, Mountains): ";

        bool valid = false;
        do {
            getline(cin, area);
            area = toLower(area);
            for (const string &validArea : validAreas) {
                if (area == validArea) {
                    valid = true;
                    break;
                }
            }
            if (!valid) {
                cout << "Invalid area. Please choose again: ";
            }
        } while (!valid); 

      cout << "You chose: " << area << endl;
        cout << "Exploring " << area << "..." << endl;

        int dailyPoints = 0;
        int eventCount = 0;

        // Up to 3 events per day using while loop
        while (eventCount < 3) {
            eventCount++;
            cout << "Event " << eventCount << ": ";

            int eventType = rand() % 5; // 0-4: different events

            if (eventType == 0) {
                cout << "You spotted a bird. (Too small to track. Moving on.)" << endl;
                continue; // skip to next event
            } else if (eventType == 1) {
                cout << "You found edible berries! (+15 points)" << endl;
                dailyPoints += 15;
            } else if (eventType == 2) {
                cout << "You discovered ancient ruins! (+30 points)" << endl;
                dailyPoints += 30;
            } else if (eventType == 3) {
                cout << "A crocodile appears! Type 'run' to escape: ";
                string action;
                getline(cin, action);
                if (toLower(action) == "run") {
                    cout << "You escaped safely, ending the day early." << endl;
                    break; // escape from event loop
                } else {
                    cout << "You got hurt! No points gained today." << endl;
                    dailyPoints = 0;
                    break;
                }
            } else if (eventType == 4) {
                cout << "A lion blocks your path! Type 'run' to escape: ";
                string action;
                getline(cin, action);
                if (toLower(action) == "run") {
                    cout << "You escaped safely, ending the day early." << endl;
                    break;
                } else {
                    cout << "You were injured! Ending the day with no points." << endl;
                    dailyPoints = 0;
                    break;
                }
            }

          // Final summary
    cout << "\n Safari Complete! You collected " << totalPoints << " points!" << endl;
    if (totalPoints >= 100) {
        cout << "You survived and completed the adventure!" << endl;
    } else {
        cout << "You didn't collect enough resources. Try again next time." << endl;
    }

    return 0;
}

