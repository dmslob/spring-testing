package com.dmslob.data.repos;

import com.dmslob.domain.CustomerContact;
import org.springframework.data.repository.CrudRepository;

public interface CustomerContactRepository extends CrudRepository<CustomerContact, Long> {
    CustomerContact findByEmail(String email);
}
