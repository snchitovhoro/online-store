package edu.miu.cs545.project.onlinestore.controller;

import edu.miu.cs545.project.onlinestore.domain.Payment;
import edu.miu.cs545.project.onlinestore.domain.Shipping;
import edu.miu.cs545.project.onlinestore.domain.ShoppingCart;
import edu.miu.cs545.project.onlinestore.domain.ShoppingCartLine;
import edu.miu.cs545.project.onlinestore.service.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shoppingcarts")
public class ShoppingCartController {
    @Autowired
    OrderController orderController;

//    @Autowired
//    ModelMapper modelMapper;
    @Autowired
    private IShoppingCartService shoppingCartService;

    @PostMapping()
    public ShoppingCart createShoppingCart(@RequestBody ShoppingCart cart) {
        return shoppingCartService.createShoppingCart(cart);
    }

    @GetMapping("/{cartId}")
    public Optional<ShoppingCart> getShoppingCart(@PathVariable Long cartId) {
        Optional<ShoppingCart> cart = shoppingCartService.getShoppingCart(cartId);
        if (cart.isPresent()) {
            return cart;
        }
        return null;
    }

    @GetMapping("/{cartId}/cartlines")
    public List<ShoppingCartLine> getLinesFromShoppingCart(@PathVariable Long cartId) {
        List<ShoppingCartLine> cartLines = shoppingCartService.getLinesByShoppingCart(cartId);
        return cartLines;
    }

    // add line to shopping cart
    @PostMapping("/{cartId}/cartlines")
    public void addLineToShoppingCart(@PathVariable Long cartId, @RequestBody ShoppingCartLine cartLine) {
        shoppingCartService.addLineToShoppingCart(cartId, cartLine);
    }

    // update line in shopping cart
    @PutMapping("/{cartId}/cartlines")
    public void updateLineInShoppingCart(@PathVariable Long cartId, @RequestBody ShoppingCartLine cartLine) {
        shoppingCartService.updateLineInShoppingCart(cartId, cartLine);
    }

    // update quantity in shopping cart
    @PutMapping("/{cartId}/cartlines/{lineId}")
    public void updateLineInShoppingCart(@PathVariable Long cartId, @PathVariable Long lineId, @RequestBody Integer newQuantity) {
        shoppingCartService.updateQuantityInShoppingCartLine(cartId, lineId, newQuantity);
    }

    // remove line from shopping cart
    @DeleteMapping("/{cartId}/cartlines/{cartLineId}")
    public ResponseEntity<?> removeLineToShoppingCart(@PathVariable Long cartId, @PathVariable Long cartLineId) {
        shoppingCartService.removeLineFromShoppingCart(cartId, cartLineId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


//    @PostMapping("/{cartId}/createorder")
//    public void createOrder(@PathVariable Long cartId, @RequestBody ShippingAndPayment shippingAndPayment) {
//        orderController.createOrderFromCart(cartId, shippingAndPayment.shipping, shippingAndPayment.payment);
////        return orderService.createOrder(order);
//    }   //checked


}

class ShippingAndPayment {
    public Shipping shipping;
    public Payment payment;
}
