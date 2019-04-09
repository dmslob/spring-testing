package com.dmslob.testing.data.repos;

import com.dmslob.testing.domain.CustomerContact;
import org.springframework.data.repository.CrudRepository;

public interface CustomerContactRepository extends CrudRepository<CustomerContact, Long> {
    public CustomerContact findByEmail(String email);
}
