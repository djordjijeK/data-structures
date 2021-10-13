# Data Structures

## 1. `ArrayList` Data Structure

`ArrayList` in `Java` is used to store dynamically sized collection of elements. 
Contrary to arrays that are fixed in size, an `ArrayList` grows its size automatically when new elements are added to it.

- An `ArrayList` is a re-sizable array, also called a dynamic array. 
It grows its size to accommodate new elements and shrinks the size when the elements are removed.

- Just like arrays, it allows you to retrieve the elements by their index. 

- `ArrayList` allows duplicate and `null` values.

- `ArrayList` is not synchronized. 
If multiple threads try to modify an `ArrayList` at the same time, then the final outcome will be non-deterministic.

Introduction:

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

Inserting, Updating and Indexing:

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

Removing: 

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

Iterating:

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
// here, we start from the end of the list and traverse backwards.
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

Searching:

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

Sorting Part I:

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

Sorting Part II:

```java
// create an ArrayList of strings and add elements to it
List<String> names = new ArrayList<>();
names.add("Lisa");
names.add("Jennifer");
names.add("Mark");
names.add("David");

System.out.println("Names : " + names);

// sort an ArrayList using its sort() method. You must pass a Comparator to the ArrayList.sort() method.
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

Output

```
Names : [Lisa, Jennifer, Mark, David]
Sorted Names : [David, Jennifer, Lisa, Mark]
```

**Note**: One plausible implementation of generic dynamic array data structure can be found @[DynamicArray](src/main/java/DynamicArray.java).