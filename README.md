# Data Structures

A **data structure** is a particular way of organizing data in a computer memory so that it can be used effectively.
In other words, it is a collection of data, the relationships among them, and the functions or operations that can be applied to the data.

## 1. Dynamic Array - `ArrayList`

`ArrayList` &#8594; `List`(interface) &#8594; `Collection`(interface) &#8594; `Iterable`(interface)

`ArrayList` in `Java` is used to store dynamically sized collection of elements. 
Contrary to arrays that are fixed in size, an `ArrayList` grows its size automatically when new elements are added to it.

- An `ArrayList` is a re-sizable array, also called a dynamic array. 
It grows its size to accommodate new elements and shrinks the size when the elements are removed.

- Just like arrays, it allows you to retrieve the elements by their index. 

- `ArrayList` allows duplicate and `null` values.

- `ArrayList` is not synchronized. 
If multiple threads try to modify an `ArrayList` at the same time, then the final outcome will be non-deterministic.

a) Introduction:

```java
// create an ArrayList of strings
List<String> animals = new ArrayList<>();

// add new elements to the ArrayList
animals.add("Lion");
animals.add("Tiger");
animals.add("Cat");
animals.add("Dog");

// print content of an ArrayList
System.out.println(animals);

// add an element at a particular index in an ArrayList
animals.add(2, "Elephant");

// print content of an ArrayList
System.out.println(animals);
```

Output:

```
[Lion, Tiger, Cat, Dog]
[Lion, Tiger, Elephant, Cat, Dog]
```

b) Inserting, Updating and Indexing:

```java
// create an ArrayList of strings
List<String> topCompanies = new ArrayList<>();

// check if an ArrayList is empty
System.out.println("Is the topCompanies list empty? : " + topCompanies.isEmpty());

// add new elements to the ArrayList
topCompanies.add("Google");
topCompanies.add("Apple");
topCompanies.add("Microsoft");
topCompanies.add("Amazon");
topCompanies.add("Facebook");

// find the size of an ArrayList
System.out.println("Here are the top " + topCompanies.size() + " companies in the world");
System.out.println(topCompanies);

// retrieve the element at a given index
String bestCompany = topCompanies.get(0);
String secondBestCompany = topCompanies.get(1);
String lastCompany = topCompanies.get(topCompanies.size() - 1);

System.out.println("Best Company: " + bestCompany);
System.out.println("Second Best Company: " + secondBestCompany);
System.out.println("Last Company in the list: " + lastCompany);

// modify the element at a given index
topCompanies.set(4, "Walmart");
System.out.println("Modified top companies list: " + topCompanies);
```

Output:

```
Is the topCompanies list empty? : true
Here are the top 5 companies in the world
[Google, Apple, Microsoft, Amazon, Facebook]
Best Company: Google
Second Best Company: Apple
Last Company in the list: Facebook
Modified top companies list: [Google, Apple, Microsoft, Amazon, Walmart]
```

c) Removing: 

```java
// create an ArrayList of strings and add elements to it
List<String> programmingLanguages = new ArrayList<>();
programmingLanguages.add("C");
programmingLanguages.add("C++");
programmingLanguages.add("Java");
programmingLanguages.add("Kotlin");
programmingLanguages.add("Python");
programmingLanguages.add("Perl");
programmingLanguages.add("Ruby");

System.out.println("Initial List: " + programmingLanguages);

// remove the element at index `5`
programmingLanguages.remove(5);
System.out.println("After remove(5): " + programmingLanguages);

// remove the first occurrence of the given element from the ArrayList
// (the remove() method returns false if the element does not exist in the ArrayList)
boolean isRemoved = programmingLanguages.remove("Kotlin");
System.out.println("After remove(\"Kotlin\"): " + programmingLanguages);

// remove all the elements that exist in a given collection
List<String> scriptingLanguages = new ArrayList<>();
scriptingLanguages.add("Python");
scriptingLanguages.add("Ruby");
scriptingLanguages.add("Perl");

programmingLanguages.removeAll(scriptingLanguages);
System.out.println("After removeAll(scriptingLanguages): " + programmingLanguages);

// remove all the elements that satisfy the given predicate
// the below removeIf() call can also be written using lambda expression like this - programmingLanguages.removeIf(s -> s.startsWith("C"))
programmingLanguages.removeIf(new Predicate<String>() {
    @Override
    public boolean test(String s) {
        return s.startsWith("C");
    }
});

System.out.println("After removing all elements that start with \"C\": " + programmingLanguages);

// remove all elements from the ArrayList
programmingLanguages.clear();
System.out.println("After clear(): " + programmingLanguages);
```

Output:

```
Initial List: [C, C++, Java, Kotlin, Python, Perl, Ruby]
After remove(5): [C, C++, Java, Kotlin, Python, Ruby]
After remove("Kotlin"): [C, C++, Java, Python, Ruby]
After removeAll(scriptingLanguages): [C, C++, Java]
After removing all elements that start with "C": [Java]
After clear(): []
```

d) Iterating:

```java
// create an ArrayList of strings and add elements to it
List<String> tvShows = new ArrayList<>();
tvShows.add("Breaking Bad");
tvShows.add("Game Of Thrones");
tvShows.add("Friends");
tvShows.add("Prison break");

System.out.println("=== Iterate using forEach and lambda ===");
tvShows.forEach(tvShow -> {
    System.out.println(tvShow);
});

System.out.println("\n=== Iterate using an iterator() ===");
Iterator<String> tvShowIterator = tvShows.iterator();
while (tvShowIterator.hasNext()) {
    String tvShow = tvShowIterator.next();
    System.out.println(tvShow);
}

System.out.println("\n=== Iterate using a listIterator() to traverse in both directions ===");
// here, we start from the end of the list and traverse backwards
ListIterator<String> tvShowListIterator = tvShows.listIterator(tvShows.size());
while (tvShowListIterator.hasPrevious()) {
    String tvShow = tvShowListIterator.previous();
    System.out.println(tvShow);
}

System.out.println("\n=== Iterate using simple for-each loop ===");
for(String tvShow: tvShows) {
    System.out.println(tvShow);
}

System.out.println("\n=== Iterate using for loop with index ===");
for(int i = 0; i < tvShows.size(); i++) {
    System.out.println(tvShows.get(i));
}
```

Output:

```
=== Iterate using forEach and lambda ===
Breaking Bad
Game Of Thrones
Friends
Prison break

=== Iterate using an iterator() ===
Breaking Bad
Game Of Thrones
Friends
Prison break

=== Iterate using a listIterator() to traverse in both directions ===
Prison break
Friends
Game Of Thrones
Breaking Bad

=== Iterate using simple for-each loop ===
Breaking Bad
Game Of Thrones
Friends
Prison break

=== Iterate using for loop with index ===
Breaking Bad
Game Of Thrones
Friends
Prison break
```

e) Searching:

```java
// create an ArrayList of strings and add elements to it
List<String> names = new ArrayList<>();
names.add("John");
names.add("Alice");
names.add("Bob");
names.add("Steve");
names.add("John");
names.add("Steve");
names.add("Maria");

// check if an ArrayList contains a given element
System.out.println("Does names array contain \"Bob\"? : " + names.contains("Bob"));

// find the index of the first occurrence of an element in an ArrayList
System.out.println("indexOf \"Steve\": " + names.indexOf("Steve"));
System.out.println("indexOf \"Mark\": " + names.indexOf("Mark"));

// find the index of the last occurrence of an element in an ArrayList
System.out.println("lastIndexOf \"John\" : " + names.lastIndexOf("John"));
System.out.println("lastIndexOf \"Bill\" : " + names.lastIndexOf("Bill"));
```

Output:

```
Does names array contain "Bob"? : true
indexOf "Steve": 3
indexOf "Mark": -1
lastIndexOf "John" : 4
lastIndexOf "Bill" : -1
```

f) Sorting Part I:

```java
// create an ArrayList of numbers and add elements to it
List<Integer> numbers = new ArrayList<>();
numbers.add(13);
numbers.add(7);
numbers.add(18);
numbers.add(5);
numbers.add(2);

System.out.println("Before : " + numbers);

// sorting an ArrayList using Collections.sort() method
Collections.sort(numbers);

System.out.println("After : " + numbers);
```

Output:

```
Before : [13, 7, 18, 5, 2]
After : [2, 5, 7, 13, 18]
```

g) Sorting Part II:

```java
// create an ArrayList of strings and add elements to it
List<String> names = new ArrayList<>();
names.add("Lisa");
names.add("Jennifer");
names.add("Mark");
names.add("David");

System.out.println("Names : " + names);

// sort an ArrayList using its sort() method. You must pass a Comparator to the ArrayList.sort() method
names.sort(new Comparator<String>() {
    @Override
    public int compare(String name1, String name2) {
        return name1.compareTo(name2);
    }
});

// The above sort() method call can also be written simply using lambda expression
// names.sort((name1, name2) -> name1.compareTo(name2));
System.out.println("Sorted Names : " + names);
```

Output:

```
Names : [Lisa, Jennifer, Mark, David]
Sorted Names : [David, Jennifer, Lisa, Mark]
```

**Note**: One plausible implementation of generic dynamic array data structure can be found @[DynamicArray](src/main/java/DynamicArray.java).

## 2. Linked List - `LinkedList`

`LinkedList` &#8594; `List`(interface), [`Deque`(interface) &#8594; `Queue`(interface)] &#8594; `Collection`(interface) &#8594; `Iterable`(interface)

`LinkedList` in `Java` is implemented as a doubly linked list.

- `LinkedList` maintains the insertion order of the elements.

- `LinkedList` can have duplicate and null values. 

- `LinkedList` is not thread-safe. You must explicitly synchronize concurrent modifications to the `LinkedList` in a multi-threaded environment.

An `ArrayList` stores the elements sequentially based on their index. 
However, a `LinkedList` uses a doubly-linked list to store its elements.
You can access an element in an `ArrayList` in `O(1)` time. 
But it takes `O(n)` time to access an element in a `LinkedList` because it needs to traverse to the desired element by following the `next/prev` references.

![Array vs LinkedList](https://www.callicoder.com/static/ffb4ab89e6cfc7e840b8da297b169550/ea544/java-linkedlist-vs-arraylist.jpg)

a) Introduction:

```java
// creating a LinkedList
LinkedList<String> friends = new LinkedList<>();

// adding new elements to the end of the LinkedList using add() method
friends.add("Rajeev");
friends.add("John");
friends.add("David");
friends.add("Chris");

System.out.println("Initial LinkedList : " + friends);

// adding an element at the specified position in the LinkedList
friends.add(3, "Lisa");
System.out.println("After add(3, \"Lisa\") : " + friends);

// adding an element at the beginning of the LinkedList
friends.addFirst("Steve");
System.out.println("After addFirst(\"Steve\") : " + friends);

// adding an element at the end of the LinkedList (this method is equivalent to the add() method)
friends.addLast("Jennifer");
System.out.println("After addLast(\"Jennifer\") : " + friends);

// adding all the elements from an existing collection to the end of the LinkedList
List<String> familyFriends = new ArrayList<>();
familyFriends.add("Jesse");
familyFriends.add("Walt");

friends.addAll(familyFriends);
System.out.println("After addAll(familyFriends) : " + friends);
```

Output:

```
Initial LinkedList : [Rajeev, John, David, Chris]
After add(3, "Lisa") : [Rajeev, John, David, Lisa, Chris]
After addFirst("Steve") : [Steve, Rajeev, John, David, Lisa, Chris]
After addLast("Jennifer") : [Steve, Rajeev, John, David, Lisa, Chris, Jennifer]
After addAll(familyFriends) : [Steve, Rajeev, John, David, Lisa, Chris, Jennifer, Jesse, Walt]
```

b) Inserting and Indexing:

```java
// a LinkedList containing stock prices of a company for the last 6 days
LinkedList<Double> stockPrices = new LinkedList<>();

// inserting new elements to the end of the LinkedList using add() method
stockPrices.add(45.00);
stockPrices.add(1, 51.00);
stockPrices.add(62.50);
stockPrices.add(42.75);
stockPrices.add(36.80);
stockPrices.add(5, 68.40);

// getting the first element in the LinkedList using getFirst()
// the getFirst() method throws NoSuchElementException if the LinkedList is empty
Double firstElement = stockPrices.getFirst();
System.out.println("Initial Stock Price : " + firstElement);

// getting the last element in the LinkedList using getLast()
// the getLast() method throws NoSuchElementException if the LinkedList is empty
Double lastElement = stockPrices.getLast();
System.out.println("Current Stock Price : " + lastElement);

// getting the element at a given position in the LinkedList
Double stockPriceOn3rdDay = stockPrices.get(2);
System.out.println("Stock Price on 3rd Day : " + stockPriceOn3rdDay);
```

Output:

```
Initial Stock Price : 45.0
Current Stock Price : 68.4
Stock Price on 3rd Day : 62.5
```

c) Removing:

```java
LinkedList<String> programmingLanguages = new LinkedList<>();

programmingLanguages.add("Assembly");
programmingLanguages.add("Fortran");
programmingLanguages.add("Pascal");
programmingLanguages.add("C");
programmingLanguages.add("C++");
programmingLanguages.add("Java");
programmingLanguages.add("C#");
programmingLanguages.add("Kotlin");

System.out.println("Initial LinkedList = " + programmingLanguages);

// remove the first element in the LinkedList
// throws NoSuchElementException if the LinkedList is empty
String element = programmingLanguages.removeFirst();
System.out.println("Removed the first element " + element + " => " + programmingLanguages);

// remove the last element in the LinkedList
// throws NoSuchElementException if the LinkedList is empty
element = programmingLanguages.removeLast();
System.out.println("Removed the last element " + element + " => " + programmingLanguages);

// remove the first occurrence of the specified element from the LinkedList
boolean isRemoved = programmingLanguages.remove("C#");
if(isRemoved) 
{
    System.out.println("Removed C# => " + programmingLanguages);
}

// remove all the elements that satisfy the given predicate
programmingLanguages.removeIf(programmingLanguage -> programmingLanguage.startsWith("C"));
System.out.println("Removed elements starting with C => " + programmingLanguages);

// clear the LinkedList by removing all elements
programmingLanguages.clear();
System.out.println("Cleared the LinkedList => " + programmingLanguages);
```

Output:

```
Initial LinkedList = [Assembly, Fortran, Pascal, C, C++, Java, C#, Kotlin]
Removed the first element Assembly => [Fortran, Pascal, C, C++, Java, C#, Kotlin]
Removed the last element Kotlin => [Fortran, Pascal, C, C++, Java, C#]
Removed C# => [Fortran, Pascal, C, C++, Java]
Removed elements starting with C => [Fortran, Pascal, Java]
Cleared the LinkedList => []
```

d) Iterating:

```java
LinkedList<String> humanSpecies = new LinkedList<>();

humanSpecies.add("Homo Sapiens");
humanSpecies.add("Homo Neanderthalensis");
humanSpecies.add("Homo Erectus");
humanSpecies.add("Home Habilis");

System.out.println("=== Iterate over a LinkedList using Java forEach and lambda ===");
humanSpecies.forEach(name -> {
    System.out.println(name);
});

System.out.println("\n=== Iterate over a LinkedList using iterator() ===");
Iterator<String> humanSpeciesIterator = humanSpecies.iterator();
while (humanSpeciesIterator.hasNext()) {
    String speciesName = humanSpeciesIterator.next();
    System.out.println(speciesName);
}

System.out.println("\n=== Iterate over a LinkedList using iterator() and Java forEachRemaining() method ===");
humanSpeciesIterator = humanSpecies.iterator();
humanSpeciesIterator.forEachRemaining(speciesName -> {
    System.out.println(speciesName);
});

System.out.println("\n=== Iterate over a LinkedList using descendingIterator() ===");
Iterator<String> descendingHumanSpeciesIterator = humanSpecies.descendingIterator();
while (descendingHumanSpeciesIterator.hasNext()) {
    String speciesName = descendingHumanSpeciesIterator.next();
    System.out.println(speciesName);
}


System.out.println("\n=== Iterate over a LinkedList using listIterator() ===");
// ListIterator can be used to iterate over the LinkedList in both forward and backward directions
// in this example, we start from the end of the list and traverse backwards
ListIterator<String> humanSpeciesListIterator = humanSpecies.listIterator(humanSpecies.size());
while (humanSpeciesListIterator.hasPrevious()) {
    String speciesName = humanSpeciesListIterator.previous();
    System.out.println(speciesName);
}

System.out.println("\n=== Iterate over a LinkedList using simple for-each loop ===");
for(String speciesName: humanSpecies) {
    System.out.println(speciesName);
}
```

Output:

```
=== Iterate over a LinkedList using Java forEach and lambda ===
Homo Sapiens
Homo Neanderthalensis
Homo Erectus
Home Habilis

=== Iterate over a LinkedList using iterator() ===
Homo Sapiens
Homo Neanderthalensis
Homo Erectus
Home Habilis

=== Iterate over a LinkedList using iterator() and Java 8 forEachRemaining() method ===
Homo Sapiens
Homo Neanderthalensis
Homo Erectus
Home Habilis

=== Iterate over a LinkedList using descendingIterator() ===
Home Habilis
Homo Erectus
Homo Neanderthalensis
Homo Sapiens

=== Iterate over a LinkedList using listIterator() ===
Home Habilis
Homo Erectus
Homo Neanderthalensis
Homo Sapiens

=== Iterate over a LinkedList using simple for-each loop ===
Homo Sapiens
Homo Neanderthalensis
Homo Erectus
Home Habilis
```


e) Searching:

```java
LinkedList<String> employees = new LinkedList<>();

employees.add("John");
employees.add("David");
employees.add("Lara");
employees.add("Chris");
employees.add("Steve");
employees.add("David");

// check if the LinkedList contains an element
System.out.println("Does Employees LinkedList contain \"Lara\"? : " + employees.contains("Lara"));

// find the index of the first occurrence of an element in the LinkedList
System.out.println("indexOf \"Steve\" : " + employees.indexOf("Steve"));
System.out.println("indexOf \"Mark\" : " + employees.indexOf("Mark"));

// find the index of the last occurrence of an element in the LinkedList
System.out.println("lastIndexOf \"David\" : " + employees.lastIndexOf("David"));
System.out.println("lastIndexOf \"Bob\" : " + employees.lastIndexOf("Bob"));
```

Output:

```
Does Employees LinkedList contain "Lara"? : true
indexOf "Steve" : 4
indexOf "Mark" : -1
lastIndexOf "David" : 5
lastIndexOf "Bob" : -1
```

**Note**: One plausible implementation of a generic doubly linked list data structure can be found @[DoublyLinkedList](src/main/java/DoublyLinkedList.java)

## 3. Stack - `Stack`

`Stack` &#8594; `Vector` &#8594; `List`(interface) &#8594; `Collection`(interface) &#8594; `Iterable`(interface)

A `Stack` is a Last In First Out (LIFO) data structure. 
It supports two basic operations called `push` and `pop`. 
The `push` operation adds an element at the top of the stack, and the `pop` operation removes an element from the top of the stack.

a) Basic Operations:

```java
// creating a Stack
Stack<String> stackOfCards = new Stack<>();

// pushing new items to the Stack
stackOfCards.push("Jack");
stackOfCards.push("Queen");
stackOfCards.push("King");
stackOfCards.push("Ace");

System.out.println("Stack => " + stackOfCards);
System.out.println();

// popping items from the Stack
String cardAtTop = stackOfCards.pop();  // throws EmptyStackException if the stack is empty
System.out.println("Stack.pop() => " + cardAtTop);
System.out.println("Current Stack => " + stackOfCards);
System.out.println();

// get the item at the top of the stack without removing it
cardAtTop = stackOfCards.peek();
System.out.println("Stack.peek() => " + cardAtTop);
System.out.println("Current Stack => " + stackOfCards);
```

```
Stack => [Jack, Queen, King, Ace]
Stack.pop() => Ace
Current Stack => [Jack, Queen, King]
Stack.peek() => King
Current Stack => [Jack, Queen, King]
```

b) Other Operations:

```java
Stack<String> stackOfCards = new Stack<>();

stackOfCards.push("Jack");
stackOfCards.push("Queen");
stackOfCards.push("King");
stackOfCards.push("Ace");

System.out.println("Stack : " + stackOfCards);

// check if the Stack is empty
System.out.println("Is Stack empty? : " + stackOfCards.isEmpty());

// find the size of Stack
System.out.println("Size of Stack : " + stackOfCards.size());

// search for an element
// the search() method returns the 1-based position of the element from the top of the stack
// it returns -1 if the element was not found in the stack
int position = stackOfCards.search("Queen");

if(position != -1) {
    System.out.println("Found the element \"Queen\" at position : " + position);
} else {
    System.out.println("Element not found");
}
```

```
Stack : [Jack, Queen, King, Ace]
Is Stack empty? : false
Size of Stack : 4
Found the element "Queen" at position : 3
```

**Note**: One plausible implementation of a generic stack data structure can be found @[Stack](src/main/java/Stack.java)

## 4. Queue - `Queue`

`Queue`(Interface) &#8594; `Collection`(interface) &#8594; `Iterable`(interface)

A `Queue` is a First In First Out (FIFO) data structure. 
It models a queue in real-life.
Just like queues in real life, new elements in a `Queue` data structure are added at the back and removed from the front.

a) Basic Operations:

A `Queue` in `Java` is just an interface. 
We need a concrete implementation of the `Queue` interface to work with, in our programs.

```java
// create and initialize a Queue using a LinkedList
Queue<String> waitingQueue = new LinkedList<>();

// adding new elements to the Queue (The Enqueue operation)
waitingQueue.add("Petar");
waitingQueue.add("Chris");
waitingQueue.add("John");
waitingQueue.add("Mark");
waitingQueue.add("Steven");

System.out.println("WaitingQueue : " + waitingQueue);

// removing an element from the Queue using remove() (the dequeue operation)
// the remove() method throws NoSuchElementException if the Queue is empty
String name = waitingQueue.remove();
System.out.println("Removed from WaitingQueue : " + name + " | New WaitingQueue : " + waitingQueue);

// removing an element from the Queue using poll()
// the poll() method is similar to remove() except that it returns null if the Queue is empty.
name = waitingQueue.poll();
System.out.println("Removed from WaitingQueue : " + name + " | New WaitingQueue : " + waitingQueue);
```

```
WaitingQueue : [Petar, Chris, John, Mark, Steven]
Removed from WaitingQueue : Petar | New WaitingQueue : [Chris, John, Mark, Steven]
Removed from WaitingQueue : Chris | New WaitingQueue : [John, Mark, Steven]
```

b) Other Operations:

```java
Queue<String> waitingQueue = new LinkedList<>();

waitingQueue.add("Jennifer");
waitingQueue.add("Angelina");
waitingQueue.add("Johnny");
waitingQueue.add("Sachin");

System.out.println("WaitingQueue : " + waitingQueue);

// check if a Queue is empty
System.out.println("is waitingQueue empty? : " + waitingQueue.isEmpty());

// find the size of the Queue
System.out.println("Size of waitingQueue : " + waitingQueue.size());

// check if the Queue contains an element
String name = "Johnny";
if(waitingQueue.contains(name)) {
    System.out.println("WaitingQueue contains " + name);
} else {
    System.out.println("Waiting Queue doesn't contain " + name);
}

// get the element at the front of the Queue without removing it using element()
// the element() method throws NoSuchElementException if the Queue is empty
String firstPersonInTheWaitingQueue =  waitingQueue.element();
System.out.println("First Person in the Waiting Queue (element()) : " + firstPersonInTheWaitingQueue);

// get the element at the front of the Queue without removing it using peek()
// the peek() method is similar to element() except that it returns null if the Queue is empty
firstPersonInTheWaitingQueue = waitingQueue.peek();
System.out.println("First Person in the Waiting Queue : " + firstPersonInTheWaitingQueue);
```

```
WaitingQueue : [Jennifer, Angelina, Johnny, Sachin]
is waitingQueue empty? : false
Size of waitingQueue : 4
WaitingQueue contains Johnny
First Person in the Waiting Queue (element()) : Jennifer
First Person in the Waiting Queue : Jennifer
```

**Note**: One plausible implementation of a generic queue data structure can be found @[Queue](src/main/java/Queue.java)

## 5. Hash Table - `HashTable`
