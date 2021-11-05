# Data Structures

A **data structure** is a particular way of organizing data in a computer memory so that it can be used effectively.
In other words, it is a collection of data, the relationships among them, and the functions or operations that can be applied to the data.

## 1. [Dynamic Array](src/main/java/DynamicArray.java)

**Dynamic Array** is used to store dynamically sized collection of elements. 
Contrary to static arrays that are fixed in size, a dynamic array grows its size automatically when new elements are added to it.
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
| Update | O(1) | O(1) | due to immediate index access |

## 2. [Linked List](src/main/java/DoublyLinkedList.java)

**LinkedList** is a data structure consisting of a collection of nodes that form a sequence. 
In other words, each node contains a pointer to the next node (it may also include the pointer to the previous node) forming a sequence.
Unlike arrays, the elements in the linked list are not stored in the contiguous memory locations.

<p align="center">
  <img src="https://manikareahome.files.wordpress.com/2020/12/two-way-or-doubly-linked-list.gif" alt="Linked List"/>
</p>

| Operation | Time Complexity | Space Complexity | Note |
| :--: | :--: | :--: | :--: |
| Indexing | O(n) | O(1) | we need to traverse a linked list in order to index an element |
| Insert (@ beginning) | O(1) | O(1) | due to immediate head access |
| Insert (@ middle) | O(n) | O(1) | due to element shifting |
| Insert (@ end) | O(1) | O(1) | due to immediate tail access. If the list is singly linked, then this operation takes O(n) time and O(1) space |
| Delete (@ beginning) | O(1) | O(1) | due to immediate head access |
| Delete (@ middle) | O(n) | O(1) | due to element shifting |
| Delete (@ end) | O(1) | O(1) | due to immediate tail access. If the list is singly linked, then this operation takes O(n) time and O(1) space |
| Update | O(n) | O(1) | we need to traverse a linked list in order to update an element |

## 3. Stack

**Stack** is a last in, first out (**LIFO**) data structure. The element that was added last will be the one to be removed first. 

<p align="center">
  <img src="https://cdn.programiz.com/sites/tutorial2program/files/stack.png" alt="Stack"/>
</p>

| Operation | Time Complexity | Space Complexity | Note |
| :--: | :--: | :--: | :--: |
| Push | O(1) | O(1) | puts an element at the top of the stack |
| Pop | O(1) | O(1) | removes an element from the top of the stack |
| Peek | O(1) | O(1) | peeks at the top of the stack without removing an element |

## 4. Queue

**Queue** is a collection of entities that are maintained in a sequence and can be modified by the addition of entities at one end of the sequence (tail, rear) and the removal of entities from the other end of the sequence (head).
It maintains the the first in, first out (**FIFO**) policy.

<p align="center">
  <img src="https://cdn.programiz.com/sites/tutorial2program/files/queue.png" alt="Queue">
</p>

| Operation | Time Complexity | Space Complexity | Note |
| :--: | :--: | :--: | :--: |
| Enqueue / Offer | O(1) | O(1) | adds a new element to the queue |
| Dequeue / Poll | O(1) | O(1) | removes an element from the front of the queue |
| Peek | O(1) | O(1) | peeks at the front of the queue without removing an element |

## 5. Hash Table

## 6. Binary Search Tree

## 7. Set

## 8. Heap
