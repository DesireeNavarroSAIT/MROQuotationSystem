package com.mro.quotation.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Class for the CustomerController. CustomerController provides an API for the frontend system to
 * connect to. Customers are sent and retrieved in JSON format. Class also provides functionality
 * for updating existing customers by passing an ID along with the updated customer information.
 * The @RestController annotation signifies this is a controller to be used by Springboot.
 * The @RequestMapping annotation is the path that the frontend will connect to.
 * For example: (http://localhost:8080/api/customers)
 * The @CrossOrigin annotation is for security purposes.
 *
 * @author Chris Durnan
 */
@RestController
@RequestMapping(path = "api/customers")
@CrossOrigin("*")
public class CustomerController {
    private final CustomerRepository customerRepository;

    /**
     * Instantiates CustomerRepository for database transactions to occur.
     * @param customerRepository
     */
    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * GET method that returns a list of all the customers in the database.
     * GetMapping is the path the frontend connects to (http://localhost:8080/api/customers/getcustomers)
     *
     * @return A List of all the customers in the database.
     */
    @GetMapping("/getcustomers")
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    /**
     * GET method that returns a single customer from the database based on an ID passed to it.
     * GetMapping is the path the frontend connects to, along with an ID for the customer.
     * For example: (http://localhost:8080/api/customers/getcustomer/customer_id)
     *
     * @return A List of all the customers in the database.
     */
    @GetMapping("/getcustomer/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerRepository.getById(id);
    }

    // return ResponseEntity mb?

    /**
     * POST method that will add a customer to the database. Calls the save method within
     * CustomerRepository to save the new customer.
     * PostMapping is the path the customer is sent to. (http://localhost:8080/api/customers/addcustomer)
     *
     * @param customer A customer to be added to the database
     */
    @PostMapping("/addcustomer")
    public void addNewCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
    }

    /**
     * PUT method that will update an existing customer in the database. A customer ID along
     * with the updated customer information will be passed. CustomerRepository will then
     * retrieve a reference to the existing customer and overwrite the existing information
     * with the new.
     * PutMapping is the path the customer is sent to.
     * For example: (http://localhost:8080/api/customers/updatecustomer/customer_id)
     *
     * @param customer The updated customer that will overwrite the existing.
     */
    @PutMapping("/updatecustomer/{id}")
    public void updateCustomer(@RequestBody Customer customer) {
        Customer existing = customerRepository.getById(customer.getId());

        existing.setFirstName(customer.getFirstName());
        existing.setLastName(customer.getLastName());
        existing.setEmail(customer.getEmail());
        existing.setPhone(customer.getPhone());
        existing.setAddress(customer.getAddress());

        customerRepository.save(existing);
    }
}
