package alvarez.wilfredo.customers.service.datasource.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Random;

@Table
public class Customer implements Persistable<Long> {
    @Id
    private Long id;

    @Column(value = "first_name")
    private String firstName;

    @Column(value = "last_name")
    private String lastName;

    @Column
    private String email;

    @Column
    private String phone;

    public Long getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        if (this.id == null) {
            var randomId = new Random().nextLong(99999999);
            this.setId(randomId);
            return true;
        }
        return false;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
