package com.example.PROG3350_Assignment3_API.service;

import com.example.PROG3350_Assignment3_API.exeption.NotFoundException;
import com.example.PROG3350_Assignment3_API.model.entity.Cart;
import com.example.PROG3350_Assignment3_API.model.entity.Shoe;
import com.example.PROG3350_Assignment3_API.repository.ICartRepository;
import com.example.PROG3350_Assignment3_API.repository.IShoeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService implements ICartService {
    private final ICartRepository repository;
    private final IShoeRepository shoeRepository;
    public static final Integer CART_INTEGER = 1;
    public CartService(ICartRepository repository, IShoeRepository shoeRepository) {
        this.repository = repository;
        this.shoeRepository = shoeRepository;
        initCart();
    }

    @Override
    public Cart get(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cart", id));
    }

    @Override
    public void addToCart(Integer id, Integer itemId) {
        var cart = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cart", id));
        var item = shoeRepository.findById(itemId)
                .orElseThrow(() -> new NotFoundException("Item", itemId));

        getShoes(cart).add(item);
        repository.save(cart);
    }

    @Override
    public void emptyCart(Integer id) {
        var cart = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cart", id));

        getShoes(cart).clear();
        repository.save(cart);
    }

    @Override
    public void removeItem(Integer id, Integer itemId) {
        var cart = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cart", id));
        var item = shoeRepository.findById(itemId)
                .orElseThrow(() -> new NotFoundException("Item", itemId));

        getShoes(cart).remove(item);
        repository.save(cart);
    }

    @Override
    public void destroyCart(Integer id) {
        var cart = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cart", id));
        repository.delete(cart);
    }

    private List<Shoe> getShoes(Cart cart) {
        var shoes = cart.getShoes();
        if (shoes == null) {
            return new ArrayList<Shoe>();
        }
        return shoes;
    }

    private void initCart() {
        if (repository.count() == 0) {
            Cart cart = new Cart();
            cart.setShoes(new ArrayList<Shoe>());
            repository.save(cart);
        }
    }
}
