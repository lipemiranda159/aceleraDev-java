package br.com.codenation.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;
import br.com.codenation.repository.ProductRepository;
import br.com.codenation.repository.ProductRepositoryImpl;

public class OrderServiceImpl implements OrderService {

	private ProductRepository productRepository = new ProductRepositoryImpl();
	private final double percentSale = 0.2;
	/**
	 * Calculate the sum of all OrderItems
	 */
	@Override
	public Double calculateOrderValue(List<OrderItem> items) {
		return items
				.stream()
				.mapToDouble(this::getProductValue)
				.reduce(0, Double::sum);
	}

	/**
	 * Map from idProduct List to Product Set
	 */
	@Override
	public Set<Product> findProductsById(List<Long> ids) {
		return ids
				.stream()
				.map(id -> GetProductById(id))
				 .filter(product -> product.getId() != Long.MIN_VALUE)
				.collect(Collectors.toSet());
	}

	private Product GetProductById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		return product.isPresent() ? product.get() : new Product(Long.MIN_VALUE,"",Double.MIN_VALUE,false);
	}

	/**
	 * Calculate the sum of all Orders(List<OrderIten>)
	 */
	@Override
	public Double calculateMultipleOrders(List<List<OrderItem>> orders) {
		return orders.stream()
				.mapToDouble(this::calculateOrderValue)
				.reduce(0,Double::sum);
	}

	/**
	 * Group products using isSale attribute as the map key
	 */
	@Override
	public Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds) {
		List<Product> products = productIds
				.stream()
				.map(productId -> GetProductById(productId))
				.filter(product -> product.getId() != Long.MIN_VALUE)
				.collect(Collectors.toList());

		return products.stream().collect(Collectors.groupingByConcurrent(Product::getIsSale));
	}

	private double getProductValue(OrderItem element) {
			Optional<Product> product = productRepository.findById(element.getProductId());
			double value = product != null && product.isPresent() ? getFinalValue(product) : 0;
			return value * element.getQuantity();
	}

	private double getFinalValue(Optional<Product> product) {
		return product.get().getIsSale() ? product.get().getValue() - getPercentSaleValue(product) : product.get().getValue();
	}

	private double getPercentSaleValue(Optional<Product> product) {
		return percentSale * product.get().getValue();
	}



}