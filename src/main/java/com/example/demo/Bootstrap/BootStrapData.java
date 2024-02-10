package com.example.demo.Bootstrap;

import com.example.demo.DAO.CustomerRepository;
import com.example.demo.DAO.DivisionRepository;
import com.example.demo.Entities.Customer;
import com.example.demo.Entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(customerRepository.findAll().size() == 1) {
            Division d1 = new Division();
            d1.setCountry_id(2L);
            d1.setDivision_name("Utopia");

            divisionRepository.save(d1);

            Customer c1 = new Customer();
            c1.setAddress("123 Ave");
            c1.setFirstName("Adam");
            c1.setLastName("Tree");
            c1.setPhone("1234567890");
            c1.setPostal_code("12345");
            c1.setDivision(d1);

            Customer c2 = new Customer();
            c2.setAddress("7869 Ave");
            c2.setFirstName("Eve");
            c2.setLastName("Leaf");
            c2.setPhone("1234567890");
            c2.setPostal_code("12345");
            c2.setDivision(d1);

            Customer c3 = new Customer();
            c3.setAddress("12 Ave");
            c3.setFirstName("Wolf");
            c3.setLastName("Grass");
            c3.setPhone("1234567890");
            c3.setPostal_code("12345");
            c3.setDivision(d1);

            Customer c4 = new Customer();
            c4.setAddress("57 Ave");
            c4.setFirstName("Ant");
            c4.setLastName("Sky");
            c4.setPhone("1234567890");
            c4.setPostal_code("12345");
            c4.setDivision(d1);

            Customer c5 = new Customer();
            c5.setAddress("5 Ave");
            c5.setFirstName("Bear");
            c5.setLastName("Pond");
            c5.setPhone("1234567890");
            c5.setPostal_code("12345");
            c5.setDivision(d1);

            customerRepository.save(c1);
            customerRepository.save(c2);
            customerRepository.save(c3);
            customerRepository.save(c4);
            customerRepository.save(c5);
        }
    }
}
