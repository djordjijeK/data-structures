package collections;

import java.util.Objects;

public class Product implements Comparable<Product> {

    private final String name;
    private final Integer age;

    public Product(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Product(" + "name: " + this.name + ", age: " + this.age + ")";
    }

    @Override
    public int compareTo(Product other) {
        int comparison = this.getName().compareTo(other.getName());
        return comparison != 0 ? comparison : this.getAge().compareTo(other.getAge());
    }

    @Override
    public boolean equals(Object other) {

        if (this == other)
            return true;

        if (other == null || this.getClass() != other.getClass())
            return false;

        Product product = (Product) other;

        return this.getName().equals(product.getName()) && this.getAge().equals(product.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), this.getAge());
    }
}
