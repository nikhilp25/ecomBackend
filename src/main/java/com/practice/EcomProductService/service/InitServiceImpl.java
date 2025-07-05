package com.practice.EcomProductService.service;

import com.practice.EcomProductService.demo.Author;
import com.practice.EcomProductService.demo.AuthorRepo;
import com.practice.EcomProductService.demo.Book;
import com.practice.EcomProductService.model.Category;
import com.practice.EcomProductService.model.Order;
import com.practice.EcomProductService.model.Price;
import com.practice.EcomProductService.model.Product;
import com.practice.EcomProductService.repository.CategoryRepository;
import com.practice.EcomProductService.repository.OrderRepository;
import com.practice.EcomProductService.repository.PriceRepository;
import com.practice.EcomProductService.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitServiceImpl implements InitService{
    private ProductRepository productRepository;
    private PriceRepository priceRepository;
    private OrderRepository orderRepository;
    private CategoryRepository categoryRepository;
    private AuthorRepo authorRepo;

    public InitServiceImpl(ProductRepository productRepository, PriceRepository priceRepository, OrderRepository orderRepository, CategoryRepository categoryRepository, AuthorRepo authorRepo){
        this.productRepository = productRepository;
        this.orderRepository=orderRepository;
        this.priceRepository=priceRepository;
        this.categoryRepository=categoryRepository;
        this.authorRepo=authorRepo;
    }

    @Override
    public void initialise(){
        Category electronics = new Category();
        electronics.setCategoryName("Electronics");

        electronics = categoryRepository.save(electronics); // insert and update -> upsert

        Price priceIphone = new Price();
        priceIphone.setCurrency("INR");
        priceIphone.setAmount(100000);
        priceIphone.setDiscount(0);

        Price priceMacbook = new Price();
        priceMacbook.setCurrency("INR");
        priceMacbook.setAmount(200000);
        priceMacbook.setDiscount(0);

        Price priceWatch = new Price();
        priceWatch.setCurrency("INR");
        priceWatch.setAmount(40000);
        priceWatch.setDiscount(0);

        priceIphone = priceRepository.save(priceIphone);
        priceMacbook = priceRepository.save(priceMacbook);
        priceWatch = priceRepository.save(priceWatch);

        Product iphone = new Product();
        iphone.setTitle("IPhone_15_Pro");
        iphone.setDescription("Best Iphone ever");
        iphone.setImage("http://someImageURl");
        iphone.setPrice(priceIphone);
        iphone.setCategory(electronics);
        iphone = productRepository.save(iphone);

        Product macbook = new Product();
        macbook.setTitle("Macbook_Pro_16");
        macbook.setDescription("Best macbook ever");
        macbook.setImage("http://someImageURl");
        macbook.setPrice(priceMacbook);
        macbook.setCategory(electronics);
        macbook = productRepository.save(macbook);

        Product watch = new Product();
        watch.setTitle("Watch_Series_10");
        watch.setDescription("Best watch ever");
        watch.setImage("http://someImageURl");
        watch.setPrice(priceWatch);
        watch.setCategory(electronics);
        watch = productRepository.save(watch);

        Order order = new Order();
        order.setProducts(List.of(iphone, macbook, watch));
        order = orderRepository.save(order);

        Author author = new Author("Ashok Kumar", null);
        Book book1 = new Book("Book1", author);
        Book book2 = new Book("Book1", author);
        Book book3 = new Book("Book1", author);
        author.setBooks(List.of(book1,book2,book3));
        authorRepo.save(author);

        Author savedAuthor = authorRepo.findById(1).get();
        List<Book> books = savedAuthor.getBooks();
        System.out.println(books);
    }
}
