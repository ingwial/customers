package alvarez.wilfredo.customers.service.contract;

import alvarez.wilfredo.customers.service.contract.to.CustomerTO;
import alvarez.wilfredo.customers.service.datasource.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerBinder {
    CustomerBinder CUSTOMER_BINDER = Mappers.getMapper(CustomerBinder.class);

    Customer binder(CustomerTO customerTO);

    CustomerTO binder(Customer customer);

    default Customer binder(Customer customer, CustomerTO customerTO) {
        customer.setFirstName(customerTO.getFirstName());
        customer.setLastName(customerTO.getLastName());
        customer.setEmail(customerTO.getEmail());
        customer.setPhone(customerTO.getPhone());
        return customer;
    }
}
