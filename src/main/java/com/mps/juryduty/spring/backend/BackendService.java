package com.mps.juryduty.spring.backend;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BackendService {

    private List<Employee> employees;

    {
    // Init dummy data

       }

    public List<Employee> getEmployees() {
        return employees;
    }

}
