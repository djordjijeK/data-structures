# Data Structures

A **data structure** is a particular way of organizing data in a computer memory so that it can be used effectively.
In other words, it is a collection of data, the relationships among them, and the functions or operations that can be applied to the data.

## 1. [Dynamic Array](src/main/java/DynamicArray.java)

**Dynamic Array** is used to store dynamically sized collection of elements. 
Contrary to static arrays (`int[] array = new int[5]`) that are fixed in size, a dynamic array grows its size automatically when new elements are added to it.
In other words, it grows its size to accommodate new elements and shrinks the size when the elements are removed.
All elements of the array are stored in contiguous memory locations.

| Operation | Time Complexity | Space Complexity | Note |
| :----: | :--: | :--: | :---: |
| Indexing | O(1) | O(1) | the cost of access to the elements |
| Insert (@ beginning) | O(n) | O(n) | due to element shifting |
| Insert (@ middle) | O(n) | O(n) | due to element shifting |
| Insert (@ end) | O(1) | O(1) | when resizing is required, this operation takes O(n) time and O(n) space |
| Delete (@ beginning) | O(n) | O(n) | due to element shifting |
| Delete (@ middle) | O(n) | O(n) | due to element shifting |
| Delete (@ end) | O(1) | O(1) | - |
| Update | O(1) | O(1) | - |

## 2. [Linked List](src/main/java/DoublyLinkedList.java)

**LinkedList** is a data structure consisting of a collection of nodes that form a sequence. 
In other words, each node contains a pointer to the next node (it may also include the pointer to the previous node) forming a sequence.
Unlike arrays, the elements in the linked list are not stored in the contiguous memory locations.

![Doubly Linked List](https://manikareahome.files.wordpress.com/2020/12/two-way-or-doubly-linked-list.gif)

| Operation | Time Complexity | Space Complexity | Note |
| :--: | :--: | :--: | :---: |
| Indexing | O(1) | O(1) | the cost of access to the elements |
| Insert (@ beginning) | O(n) | O(n) | due to element shifting |
| Insert (@ middle) | O(n) | O(n) | due to element shifting |
| Insert (@ end) | O(1) | O(1) | when resizing is required, this operation takes O(n) time and O(n) space |
| Delete (@ beginning) | O(n) | O(n) | due to element shifting |
| Delete (@ middle) | O(n) | O(n) | due to element shifting |
| Delete (@ end) | O(1) | O(1) | - |
| Update | O(1) | O(1) | - |

## 3. Stack

## 4. Queue

## 5. Hash Table

## 6. Binary Search Tree

## 7. Set

## 8. Heap
