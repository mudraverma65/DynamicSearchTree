# Dynamic Search Tree
Implemented a data structure from basic objects

This is Assignment 2 for course CSCI-3901.

Write a class called “SearchTree” that accepts data values and then lets you search the list to
see if a value is in the list. The key part of the class is in the data structure that it uses to store
the data.

At its core, the SearchTree is an unbalanced binary search tree. New values are added to the
bottom of the tree. Values should only be stored in the tree once.

The important feature to the tree is in the search method. In addition to searching for an item
in the tree, we store the number of times that an item has been searched for previously. When
find the item, we compare the number of searches for the item with the number of searches
for the parent. If the item is searched for more than its parent then we move that item up one
level in the tree and the parent goes down a level. We elaborate on this action later in this
assignment.

The set of methods are as follows:
1. SearchTree( ) – constructor
2. boolean add( String key ) – add the key to the tree. Return true if added. Return false if
   already in the tree or some problem occurs.
3. int find( String key ) – search for “key” in the tree. If found, return the depth of the
   node in the tree (with the root as depth 1). If not found or if some error happens,
   return 0.
4. void reset( ) – change all of the counters for searches in the tree to 0.
5. String printTree( ) – create a string of the tree’s content. For each key in the tree
   (reported in sorted order), print the key, a space, and then the depth of the node in the
   tree. Separate each key with a carriage return (\n). Return a null string if any error
   occurs.
