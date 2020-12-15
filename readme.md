Repository with my own java OO implementation of tic-tac-toe game for 3x3 board with simple console UI.
Tested with testNG (using DataProviders/groups/dependsOnGroups)


Questions about tests to be addressed:
1) to test smaller pieces of code in Arbiter class, I had to make private methods package-private
2) Testing POJO with equals/hashcode - only those 2 methods? When POJO with getters only not tested (Move)
3) For purpose of test had to implement equals/hashcode in Move class (it is not required for app itself)
4) Data providers - all in one class, as different test modules are using them