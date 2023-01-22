package com.khairenncode.controller;

import com.khairenncode.Exception.ResourceNotFoundException;
import com.khairenncode.model.Customer;
import com.khairenncode.repository.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers(@RequestParam(value = "page", required = false) Integer page) {
        // If no page number is specified (pagination not needed)
        int pageSize = (int) customerRepository.count(); // Get all customer records in one page
        int pageNumber = 0; // Get first page

        // If page number is specified (pagination)
        if (!(page == null)) {
            pageSize = 10;
            pageNumber = page; // Return the page that is specified in parameter
        }
        Pageable paging = PageRequest.of(pageNumber, pageSize);
        return customerRepository.findAll(paging).getContent();
    }

    @GetMapping("/customers/{icNumber}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "icNumber") String customerIC) throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(customerIC).orElseThrow(() ->
                new ResourceNotFoundException("Customer with this IC number. not found :: " + customerIC));
        return ResponseEntity.ok().body(customer);
    }

    @PostMapping("/customers")
    public Customer createCustomer(@Valid @RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @PutMapping("/customers/{icNumber}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "icNumber") String customerIC, @Valid @RequestBody Customer customerDetails) throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(customerIC).orElseThrow(() ->
                new ResourceNotFoundException("Customer with this IC number. not found :: " + customerIC));

        customer.setIcNumber(customerDetails.getIcNumber());
        customer.setLastname(customerDetails.getLastname());
        customer.setFirstname(customerDetails.getFirstname());
        final Customer updatedCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/customers/{icNumber}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "icNumber") String customerIC) throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(customerIC).orElseThrow(() ->
                new ResourceNotFoundException("Customer with this IC number. not found :: " + customerIC));

        customerRepository.delete(customer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}