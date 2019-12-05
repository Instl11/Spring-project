package home.tacocloud.controllersREST;

import home.tacocloud.Order;
import home.tacocloud.dataJPA.OrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class OrderControllerREST {

    private OrderRepository orderRepo;

    public OrderControllerREST(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @PutMapping("/{orderId}")
    public Order correctOrderByPut(@RequestBody Order orderFromUser, @PathVariable("orderId") Order orderFromDB) {



        BeanUtils.copyProperties(orderFromUser, orderFromDB, "id", "createdAt");
        return orderRepo.save(orderFromDB);
    }

    @PatchMapping("/{orderId}")
    public ResponseEntity<Order> correctOrderByPatch(@PathVariable("orderId") Long orderId, @RequestBody Order patchOrder) {

        Optional<Order> optionalOrder = orderRepo.findById(orderId);
        if (optionalOrder.isPresent()){
            Order order = optionalOrder.get();

            if (patchOrder.getName() != null) {
                order.setName(patchOrder.getName());
            }
            if (patchOrder.getStreet() != null) {
                order.setStreet(patchOrder.getStreet());
            }
            if (patchOrder.getCity() != null) {
                order.setCity(patchOrder.getCity());
            }
            if (patchOrder.getState() != null) {
                order.setState(patchOrder.getState());
            }
            if (patchOrder.getZip() != null) {
                order.setZip(patchOrder.getZip());
            }
            if (patchOrder.getCcNumber() != null) {
                order.setCcNumber(patchOrder.getCcNumber());
            }
            if (patchOrder.getCcExpiration() != null) {
                order.setCcExpiration(patchOrder.getCcExpiration());
            }
            if (patchOrder.getCcCVV() != null) {
                order.setCcCVV(patchOrder.getCcCVV());
            }
            return ResponseEntity.ok(orderRepo.save(order));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("orderId") Long orderId) {
        try {
            orderRepo.deleteById(orderId);
        } catch (EmptyResultDataAccessException e) {
        }
    }

}

