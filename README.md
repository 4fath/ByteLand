# ByteLand
Simple solution for Byteland unification problem using Java.

### Problem Description 

Byteland is a strange country, with many cities, but with a poorly developed road network (in fact, there is exactly one route from each city to any other city, possibly leading through other cities). Until recently, the cities of Byteland were independently governed by proud Mayors, who chose not to integrate too tightly with their neighbours. However, recent opinion polls among Bytelandian computer programmers have shown a number of disturbing trends, including a sudden drop in pizza consumption. Since this had never before happened in Byteland and seemed quite inexplicable, the Mayors sought guidance of the High Council of Wise Men of Byteland. After a long period of deliberation, the Council ruled that the situation was very serious indeed: the economy was in for a long-term depression! Moreover, they claimed that tighter integration was the only way for the Bytelandian cities to survive. Whether they like it or not, the Mayors must now find a way to unite their cities as quickly as possible. However, this is not as easy as it sounds, as there are a number of important constraints which need to be fulfilled: 

 + Initially, each city is an independent State. The process of integration is divided into steps.
 + At each step, due to the limited number of diplomatic envoys available, a State can only be involved in a unification process with at most one other state. At each step two States can unite to form a new State, but only if there exists a road directly connecting some two cities of the uniting States.
 + The unification process is considered to be complete when all the cities belong to the same, global State.
 
#### Input
The first line contains t, the number of test cases (less than 1000). The descriptions of t test cases follow.

Each test case contains the description of the cities of Byteland, given in two lines. The first line contains a single integer k, representing the number of cities in Byteland (2 <= k <= 600); we assume that the cities are numbered 0,...,k-1. The second line contains exactly k-1 integers, and the i-th integer having a value of p represents a road connecting cities having numbers i+1 and p in Byteland.

#### Output
For each test case, output a separate line containing one number, equal to the minimum number of steps required to perform the unification.

#### Example
##### Input:
- 3 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**=>** Test Case Count
- 4 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**=>** How many cities is in **1th** Case
- 0 1 2 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**=>** Roads between **1th** case cities
- 8 
- 0 1 2 0 0 3 3 
- 9 
- 0 1 1 1 1 0 2 2

##### Output:
- 2 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**=>** 1th cases minimum step for unification
- 4 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**=>** 2th ...
- 5 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**=>** 3th ...

### Solution Approach

Used a pojo <code>City</code> for modelling each city. 
Generating cities at bootstrap for each case without roads. Then linking cities with given roads.
And here code snippet : 
<code> 
 - Iterate each city is not unified 
 - find this city's min linked and not unified neighbor
 - if null add this city to next steps array and go to next city of city list
 - merge these cities 
 - in merge process, collect the merged cities neighbors in one city. in that case first city in merge process
 - TODO : complete approach desc.. 


</code>