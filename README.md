# Data Structures

A **data structure** is a particular way of organizing data in a computer memory so that it can be used effectively.
In other words, it is a collection of data, the relationships among them, and the functions or operations that can be applied to the data.

## 1. [Dynamic Array](src/main/java/DynamicArray.java)

**Dynamic Array** is used to store dynamically sized collection of elements. 
Contrary to static arrays (`int[] array = new int[5]`) that are fixed in size, a dynamic array grows its size automatically when new elements are added to it.
In other words, it grows its size to accommodate new elements and shrinks the size when the elements are removed.
All elements of the array are stored in contiguous memory locations.

| Operation | Time Complexity | Space Complexity | Note |
| :--: | :--: | :--: | :---: |
| Indexing | O(1) | O(1) | the cost of access to the elements |
| Insert (at beginning) | O(n) | O(n) | due to element shifting |
| Delete (at beginning) | O(n) | O(n) | due to element shifting |
| Insert (at end) | O(1) | O(1) | when resizing is required, this operation takes O(n) time and O(n) space |
| IndexOf | O(n) | O(1) | searches the element index |

## 2. Linked List

## 3. Stack

## 4. Queue

## 5. Hash Table

## 6. Binary Search Tree

## 7. Set

## 8. Heap
