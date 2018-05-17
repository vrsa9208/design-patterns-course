package com.vrsa9208.unit1.solid;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class ColorFilter implements Predicate<Product>{
	
	private Color color;
	
	public ColorFilter(Color color) {
		this.color = color;
	}

	@Override
	public boolean test(Product arg0) {
		return arg0.color == color;
	}
	
}

class SizeFilter implements Predicate<Product>{
	
	private Size size;
	
	public SizeFilter(Size size) {
		this.size = size;
	}

	@Override
	public boolean test(Product arg0) {
		return arg0.size == size;
	}
	
}

public class PredicateFilters {
	public static void main(String[] args) {
		Product apple = new Product("apple", Color.GREEN, Size.SMALL);
		Product tree = new Product("tree", Color.GREEN, Size.LARGE);
		Product house = new Product("house", Color.BLUE, Size.LARGE);
		Product cherry = new Product("cherry", Color.RED, Size.SMALL);

		List<Product> products = Arrays.asList(apple, tree, house, cherry);
		
		System.out.println("Green products: ");
		products.stream()
			.filter(new ColorFilter(Color.GREEN))
			.forEach(p -> System.out.println(" - " + p.name + " is green"));
		
		System.out.println("Large blue products: ");
		products.stream()
			.filter(new ColorFilter(Color.BLUE))
			.filter(new SizeFilter(Size.LARGE))
			.forEach(p -> System.out.println(" - " + p.name + " is large and blue"));
		
		System.out.println("Small green products: ");
		products.stream()
			.filter(new ColorFilter(Color.GREEN).and(new SizeFilter(Size.SMALL)))
			.forEach(p -> System.out.println(" - " + p.name + " is small and green"));
		
		System.out.println("Green or blue products: ");
		products.stream()
			.filter(new ColorFilter(Color.GREEN).or(new ColorFilter(Color.BLUE)))
			.forEach(p -> System.out.println(" - " + p.name + " is green or blue"));
		
		System.out.println("Not green or blue products: ");
		products.stream()
			.filter(new ColorFilter(Color.GREEN).negate().and(new ColorFilter(Color.BLUE).negate()))
			.forEach(p -> System.out.println(" - " + p.name + " is not green and not blue"));
	}
}
