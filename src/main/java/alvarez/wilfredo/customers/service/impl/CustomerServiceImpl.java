package alvarez.wilfredo.customers.service.impl;

import alvarez.wilfredo.customers.service.CustomerService;
import alvarez.wilfredo.customers.service.contract.to.CustomerTO;
import alvarez.wilfredo.customers.service.datasource.CustomerRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static alvarez.wilfredo.customers.service.contract.CustomerBinder.CUSTOMER_BINDER;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public Mono<CustomerTO> createCustomer(CustomerTO customerTO) {
        var customer = CUSTOMER_BINDER.binder(customerTO);
        return this.customerRepository.save(customer)
                .map(CUSTOMER_BINDER::binder);
    }

    @Override
    public Mono<CustomerTO> updateCustomer(Long id, CustomerTO customerTO) {
        return this.customerRepository.findById(id)
                .flatMap(customer -> this.customerRepository.save(CUSTOMER_BINDER.binder(customer, customerTO)))
                .map(CUSTOMER_BINDER::binder);
    }

    @Override
    public Mono<Void> deleteCustomer(Long id) {
        return this.customerRepository.deleteById(id)
                .then();
    }

    @Override
    public Mono<CustomerTO> getCustomer(Long id) {
        return this.customerRepository.findById(id)
                .map(CUSTOMER_BINDER::binder);
    }

    @Override
    public Flux<CustomerTO> getCustomers() {
        return this.customerRepository.findAll()
                .map(CUSTOMER_BINDER::binder);
    }
}
