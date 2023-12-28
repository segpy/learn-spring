package com.jpatutorial.jpaentity.dependency_injection;

import java.util.List;

public class CustomerRepository {
    public List<String> getCustomerNames() {
        return List.of("John", "Mary", "Max");
    }
}
