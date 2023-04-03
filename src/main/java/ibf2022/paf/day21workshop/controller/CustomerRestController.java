package ibf2022.paf.day21workshop.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ibf2022.paf.day21workshop.model.Customer;
import ibf2022.paf.day21workshop.respository.CustomerRepository;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;

@RestController
@RequestMapping(path = "/api/customers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerRestController {

    CustomerRepository customerRepository;

    public CustomerRestController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public ResponseEntity<String> getallCustomers(@RequestParam(required = false) String offset, @RequestParam(required = false) String limit) {

        if (Objects.isNull(offset)) {
            offset = "0";
        }
        if (Objects.isNull(limit)) {
            limit = "5";
        }

        List<Customer> customers = customerRepository.getAllCustomers(Integer.parseInt(offset), Integer.parseInt(limit));

        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

        for (Customer c : customers) {
            arrayBuilder.add(c.toJson());
        }
        JsonArray result = arrayBuilder.build();

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(result.toString());
    }
}
