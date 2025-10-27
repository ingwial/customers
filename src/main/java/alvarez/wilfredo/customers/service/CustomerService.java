package alvarez.wilfredo.customers.service;

import alvarez.wilfredo.customers.service.contract.to.CustomerTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {
    Mono<CustomerTO> createCustomer(CustomerTO customerTO);
    Mono<CustomerTO> updateCustomer(Long id, CustomerTO customerTO);
    Mono<Void> deleteCustomer(Long id);
    Mono<CustomerTO> getCustomer(Long id);
    Flux<CustomerTO> getCustomers();
}
