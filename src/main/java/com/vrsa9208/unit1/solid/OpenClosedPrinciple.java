package com.vrsa9208.unit1.solid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

//Open Close Principle and Specification Pattern

enum Color {
	RED, GREEN, BLUE
}

enum Size {
	SMALL, MEDIUM, LARGE, YUGE
}

class Product {
	public String name;
	public Color color;
	public Size size;

	public Product(String name, Color color, Size size) {
		this.name = name;
		this.color = color;
		this.size = size;
	}

}

class ProductFilter {

	public Stream<Product> filterByColor(List<Product> products, Color color) {
		return products.stream().filter(p -> p.color == color);
	}

	public Stream<Product> filterBySize(List<Product> products, Size size) {
		return products.stream().filter(p -> p.size == size);
	}

	public Stream<Product> filterBySizeAndColor(List<Product> products, Size size, Color color) {
		return products.stream().filter(p -> p.size == size && p.color == color);
	}
}

public class OpenClosedPrinciple {

	public static void main(String[] args) {
		Product apple = new Product("apple", Color.GREEN, Size.SMALL);
		Product tree = new Product("tree", Color.GREEN, Size.LARGE);
		Product house = new Product("house", Color.BLUE, Size.LARGE);

		List<Product> products = Arrays.asList(apple, tree, house);

		ProductFilter pf = new ProductFilter();
		System.out.println("Green products: ");
		pf.filterByColor(products, Color.GREEN).forEach(p -> System.out.println(" - " + p.name + " is green"));
	}
}
