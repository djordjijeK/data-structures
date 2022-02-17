package collections;

import java.util.Objects;

public class Product implements Comparable<Product> {

    private final String name;
    private final Integer price;

    public Product(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product(" + "name: " + this.name + ", age: " + this.price + ")";
    }

    @Override
    public int compareTo(Product other) {
        int comparison = this.getName().compareTo(other.getName());
        return comparison != 0 ? comparison : this.getPrice().compareTo(other.getPrice());
    }

    @Override
    public boolean equals(Object other) {

        if (this == other)
            return true;

        if (other == null || this.getClass() != other.getClass())
            return false;

        Product product = (Product) other;

        return this.getName().equals(product.getName()) && this.getPrice().equals(product.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), this.getPrice());
    }
}
