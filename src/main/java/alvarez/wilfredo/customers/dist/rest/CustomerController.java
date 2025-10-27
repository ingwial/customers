package alvarez.wilfredo.customers.dist.rest;

import alvarez.wilfredo.customers.service.CustomerService;
import alvarez.wilfredo.customers.service.contract.to.CustomerTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Mono<CustomerTO>> createCustomer(@RequestBody CustomerTO customerTO) {
        return ResponseEntity.ok(this.customerService.createCustomer(customerTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Mono<CustomerTO>> updateCustomer(@PathVariable Long id, @RequestBody CustomerTO customerTO) {
        return ResponseEntity.ok(this.customerService.updateCustomer(id, customerTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Mono<Void>> deleteCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(this.customerService.deleteCustomer(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<CustomerTO>> findCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(this.customerService.getCustomer(id));
    }

    @GetMapping
    public ResponseEntity<Flux<CustomerTO>> findAllCustomers() {
        return ResponseEntity.ok(this.customerService.getCustomers());
    }
}
