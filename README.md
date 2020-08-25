# jv-tree-set
Implement `getUniqueCharacters(String fileName)` method receiving file name as an argument.  
For this purpose use TreeSet. The file contains letters of the Latin alphabet and punctuation.  

In the method you should sort all letters alphabetically and return a String of 5 different letters without punctuation.  
If a file contains less than 5 unique letters, return them all.  
It is possible that a file with a given name does not exist. In such a case, the method should throw a relevant Exception.  

* Example 1: ur-BvT?^ ra w; p

  Result 1: abprt
 
* Example 2: A _f*c a?F

  Result 2: acf
