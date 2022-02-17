# Data Structures

A **data structure** is a particular way of organizing data in a computer memory so that it can be used effectively.
In other words, it is a collection of data, the relationships among them, and the functions or operations that can be applied to the data.

## [1. Dynamic Array](src/main/java/DynamicArray.java)

**Dynamic Array** is used to store dynamically sized collection of elements. 
Contrary to static arrays that are fixed in size, a dynamic array grows its size automatically when new elements are added to it.
In other words, it grows its size to accommodate new elements and shrinks the size when the elements are removed.
All elements of the array are stored in contiguous memory locations.

|      Operation       | Time Complexity | Space Complexity |                                   Note                                   |
|:--------------------:|:---------------:|:----------------:|:------------------------------------------------------------------------:|
|       Indexing       |      O(1)       |       O(1)       |                          access to the elements                          |
| Insert (@ beginning) |      O(n)       |       O(n)       |                         due to element shifting                          |
|  Insert (@ middle)   |      O(n)       |       O(n)       |                         due to element shifting                          |
|    Insert (@ end)    |      O(1)       |       O(1)       | when resizing is required, this operation takes O(n) time and O(n) space |
| Delete (@ beginning) |      O(n)       |       O(n)       |                         due to element shifting                          |
|  Delete (@ middle)   |      O(n)       |       O(n)       |                         due to element shifting                          |
|    Delete (@ end)    |      O(1)       |       O(1)       |                                    -                                     |
|        Update        |      O(1)       |       O(1)       |                             immediate access                             |

## [2. Linked List](src/main/java/DoublyLinkedList.java)

**LinkedList** is a data structure consisting of a collection of nodes that form a sequence. 
In other words, each node contains a pointer to the next node (it may also include the pointer to the previous node) forming a sequence.
Unlike arrays, the elements in the linked list are not stored in the contiguous memory locations.

<p align="center">
  <img src="https://manikareahome.files.wordpress.com/2020/12/two-way-or-doubly-linked-list.gif" alt="Linked List"/>
</p>

|      Operation       | Time Complexity | Space Complexity |                                                      Note                                                      |
|:--------------------:|:---------------:|:----------------:|:--------------------------------------------------------------------------------------------------------------:|
|       Indexing       |      O(n)       |       O(1)       |                         we need to traverse a linked list in order to index an element                         |
| Insert (@ beginning) |      O(1)       |       O(1)       |                                          due to immediate head access                                          |
|  Insert (@ middle)   |      O(n)       |       O(1)       |                                            due to element shifting                                             |
|    Insert (@ end)    |      O(1)       |       O(1)       | due to immediate tail access. If the list is singly linked, then this operation takes O(n) time and O(1) space |
| Delete (@ beginning) |      O(1)       |       O(1)       |                                          due to immediate head access                                          |
|  Delete (@ middle)   |      O(n)       |       O(1)       |                                            due to element shifting                                             |
|    Delete (@ end)    |      O(1)       |       O(1)       | due to immediate tail access. If the list is singly linked, then this operation takes O(n) time and O(1) space |
|        Update        |      O(n)       |       O(1)       |                        we need to traverse a linked list in order to update an element                         |

## [3. Stack](src/main/java/Stack.java)

**Stack** is a last in, first out (*LIFO*) data structure. The element that was added last will be the one to be removed first. 

<p align="center">
  <img src="https://cdn.programiz.com/sites/tutorial2program/files/stack.png" alt="Stack"/>
</p>

| Operation | Time Complexity | Space Complexity |                           Note                            |
|:---------:|:---------------:|:----------------:|:---------------------------------------------------------:|
|   Push    |      O(1)       |       O(1)       |          puts an element at the top of the stack          |
|    Pop    |      O(1)       |       O(1)       |       removes an element from the top of the stack        |
|   Peek    |      O(1)       |       O(1)       | peeks at the top of the stack without removing an element |

## [4. Queue](src/main/java/Queue.java)

**Queue** is a collection of entities that are maintained in a sequence and can be modified by the addition of entities at one end of the sequence (tail, rear) and the removal of entities from the other end of the sequence (head).
It maintains the first in, first out (*FIFO*) policy.

<p align="center">
  <img src="https://cdn.programiz.com/sites/tutorial2program/files/queue.png" alt="Queue">
</p>

|    Operation    | Time Complexity | Space Complexity |                            Note                             |
|:---------------:|:---------------:|:----------------:|:-----------------------------------------------------------:|
| Enqueue / Offer |      O(1)       |       O(1)       |               adds a new element to the queue               |
| Dequeue / Poll  |      O(1)       |       O(1)       |       removes an element from the front of the queue        |
|      Peek       |      O(1)       |       O(1)       | peeks at the front of the queue without removing an element |

## [5. Hash Table](src/main/java/HashTable.java)

**HashTable** is a data structure that map keys to values. 
A hash table uses a hash function to compute an index (a.k.a hash code) into an array of buckets from which the desired key-value pair can be found. 
During lookup, the key is hashed and the resulting hash indicates where the corresponding key-value is stored.

Ideally, the hash function will assign each key to a unique bucket, but most hash table designs employ an imperfect hash function, which might cause hash collisions where the hash function generates the same index for more than one key.
Such collisions are typically handled using some of the collision resolution protocols (separate chaining, open addressing, double hashing etc.)

<p align="center">
  <img src="https://yourbasic.org/algorithms/hash-table.png" alt="Hash Table">
</p>

| Operation | Time Complexity | Space Complexity |                                   Note                                   |
|:---------:|:---------------:|:----------------:|:------------------------------------------------------------------------:|
|   Index   |      O(1)       |       O(1)       |                          access to the elements                          |
|  Insert   |      O(1)       |       O(1)       | when resizing is required, this operation takes O(n) time and O(n) space |
|  Delete   |      O(1)       |       O(1)       |                                    -                                     |
|  Update   |      O(1)       |       O(1)       |                                    -                                     |

## [6. Binary Search Tree](src/main/java/BinarySearchTree.java)

**Binary Search Tree (BST)** is a rooted binary tree data structure whose internal nodes store a key greater than all the keys in the node’s left subtree and less than those in its right subtree. 
Binary search trees allow binary search for fast lookup, addition and removal of elements.

<p align="center">
  <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/da/Binary_search_tree.svg/1200px-Binary_search_tree.svg.png" width=350 height=300 alt="Binary Search Tree">
</p>

| Operation | Time Complexity | Space Complexity |                                 Note                                  |
|:---------:|:---------------:|:----------------:|:---------------------------------------------------------------------:|
|   Index   |    O(log n)     |     O(log n)     | it can go up to O(n) time and space if BST degenerates to linked list |
|  Insert   |    O(log n)     |     O(log n)     | it can go up to O(n) time and space if BST degenerates to linked list |
|  Delete   |    O(log n)     |     O(log n)     | it can go up to O(n) time and space if BST degenerates to linked list |
|  Update   |    O(log n)     |     O(log n)     | it can go up to O(n) time and space if BST degenerates to linked list |

## [7. Set](src/main/java/HashSet.java)

**Set** is a data structure that can store unique values, without any particular order.

| Operation | Time Complexity | Space Complexity |                                   Note                                   |
|:---------:|:---------------:|:----------------:|:------------------------------------------------------------------------:|
|    Add    |      O(1)       |       O(1)       | when resizing is required, this operation takes O(n) time and O(n) space |
|  Remove   |      O(1)       |       O(1)       |                                    -                                     |
| Contains  |      O(1)       |       O(1)       |                                    -                                     |

## [8. Heap](src/main/java/Heap.java)

**Heap** is a specialized tree-based data structure which is essentially an almost complete tree that satisfies the heap property.
In a max heap, for any given node `C`, if `P` is a parent node of `C`, then the key (the value) of `P` is greater than or equal to the key of `C`.
In a min heap, the key of `P` is less than or equal to the key of `C`.
The node at the top contains either the min or the max value of the heap and is called the root node.

<p align="center">
  <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/c4/Max-Heap-new.svg/800px-Max-Heap-new.svg.png"  width=400 height=450 alt="Binary Search Tree">
</p>

|   Operation    | Time Complexity | Space Complexity |                                         Note                                         |
|:--------------:|:---------------:|:----------------:|:------------------------------------------------------------------------------------:|
|  Find Min/Max  |      O(1)       |       O(1)       |                                   without removing                                   |
| Remove Min/Max |    O(log n)     |       O(1)       |                                          -                                           |
|     Insert     |    O(log n)     |       O(1)       |                                          -                                           |
|     Delete     |      O(n)       |       O(1)       | this can be reduced to O(log n) time complexity using a hash map and indice tracking |
|    Contains    |      O(n)       |       O(1)       |   this can be reduced to O(1) time complexity using a hash map and indice tracking   |

# Java Collections Framework

## A. Collection Interface

The `Collection` interface is the root interface of the Java collections framework.
Usually this interface is not used directly in the code, but rather its extensions.
It provides core methods used while manipulating the collection of elements (`size`, `add`, `remove`, `contains`, `isEmpty`, `clear` etc.)
This contract is extended by the `List`, `Set` and `Queue` interfaces.

```java
  public interface Collection<E> extends Iterable<E>
```

### [A.1 List Interface](src/main/java/collections/ListInterface.java)

The list interface represents an ordered collection of elements that allows us to store and access elements sequentially.

```java
  public interface List<E> extends Collection<E>
```

The most important implementations of this interface are: 

- `java.util.ArrayList` - implements `java.util.List` as a dynamically re-sizing array:

  - In general, the most used implementation of the `List` interface
  - CPU cache friendly

- `java.util.LinkedList` - implements `java.util.List` as a doubly-linked list:

  - The performance of many operations is worse compared to `ArrayList`
  - It performs good when frequent insertions and deletions are required as opposed to `ArrayList` which requires element shifting

- `java.util.Stack` - implements `java.util.List` (if stack is needed better use `Deque` interface)
 
  - Is it used when *LIFO (Last-In-First-Out)* pattern is required

### [A.2 Set Interface](src/main/java/collections/SetInterface.java)

A set models the mathematical set abstraction, and can't contain duplicate elements. 
That being said, it's also worth noting that elements have no specific order within the set.

```java
  public interface Set<E> extends Collection<E>
```

The most important implementations of this interface are:

- `java.util.HashSet` - implements `java.util.Set` using hash map

  - Does not maintain any order
  - It is used when it is important to not have duplicates and order of elements inside the set does not matter

- `java.util.LinkedHashSet` - implements `java.util.Set` using hash map and linked list

  - Maintains insertion order of elements

- `java.util.TreeSet` - implements `java.util.Set` using tree map

  - Maintains inserted elements in the sorted order

### [A.3 Queue and Deque Interface](src/main/java/collections/QueueAndDequeInterface.java)

Queues are collections that are returning elements respecting the *First-In-First-Out (FIFO)* pattern.

```java
  public interface Queue<E> extends Collection<E>
```

The most important implementations of this interface are:

  - `java.util.LinkedList` - implements `java.util.list` and `java.util.Deque`
  - `java.util.PriorityQueue` - implements `java.util.Queue`

Deque stands for **D**ouble **E**nded **Que**ue, which means this is a queue that can be accessed by both ends, and therefore can be used with both FIFO and LIFO patterns.

```java
  public interface Deque<E> extends Queue<E>
```

The most important implementation of this interface is:

 - `java.util.ArrayDeque` - implements `java.util.Deque`

## [B. Map Interface](src/main/java/collections/MapInterface.java)

A map associates items to keys (a.k.a `key` - `value` pairs), allowing us to retrieve items by those keys.

```java
  public interface Map<K, V>
```

The most important implementations of this interface are:

- `java.util.HashMap` - implements `java.util.Map`

  - Does not maintain any order
  - It is used when it is required to use key-value pairs and when the order of elements inside the map does not matter

- `java.util.LinkedHashSet` - implements `java.util.Set` using hash map and linked list

  - Maintains insertion order of elements

- `java.util.TreeSet` - implements `java.util.Set` using tree map

  - Maintains inserted elements in the sorted order
