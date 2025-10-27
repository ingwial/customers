package alvarez.wilfredo.customers.service.datasource;

import alvarez.wilfredo.customers.service.datasource.entity.Customer;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends R2dbcRepository<Customer, Long> {
}
