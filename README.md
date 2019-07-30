# BinarySearchTree
JAVA implementation of the binary search tree data structure.

# Project Setup

1) From the project root, run `mvn clean install`


# Initial Project Log

Project Completed on March 13th 2016

------------------------------------------

 My implementation of a binary search tree
  
 Assignment Overview:
 This programming exercise introduces binary search trees. 
 The students must create all the necessary methods for the binary search trees 
 and use the binary search trees in a Java program.
  
  		Edit Log:
  			March 11th - initial edit
  			March 13th - added removal function


# Releasing to Maven Central
## Performing a Release Deployment
*Note: This must occur prior to the Release Deployment!*

Make sure the "release-sign-artifacts" and "ossrh" 
    Maven profiles are active.

1) `mvn clean`
2) `mvn release:prepare -Possrh,release-sign-artifacts`
3) `mvn release:perform -Possrh,release-sign-artifacts`

* await the release process to finish *

4) `git push --tags`
5) `git push origin master`

## Updating the Release Version
1) `mvn versions:set -DnewVersion=1.2.3`