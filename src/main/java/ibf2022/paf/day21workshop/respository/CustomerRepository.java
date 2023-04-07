package ibf2022.paf.day21workshop.respository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import ibf2022.paf.day21workshop.model.Customer;
import ibf2022.paf.day21workshop.model.Order;

@Repository
public class CustomerRepository {

    @Autowired
    JdbcTemplate template;
    
    public List<Customer> getAllCustomers(Integer offset, Integer limit) {
        List<Customer> customers = new ArrayList<>();
        SqlRowSet rs = template.queryForRowSet(DBQueries.SELECT_ALL_CUSTOMERS, offset, limit);

        while (rs.next()) {
            customers.add(Customer.create(rs));
        }
        return customers;
    }

    // fetch customer using id
    public Customer findCustomerById(Integer id) {
        SqlRowSet rs = template.queryForRowSet(DBQueries.SELECT_CUSTOMER_BY_ID, id);
        if (rs.first()) {
            Customer customer = Customer.create(rs);
            return customer;
        }
        return null;
    }

    // fetch orders from customer
    public List<Order> getCustomerOrders(Integer id) {
        List<Order> orders = new ArrayList<>();
        SqlRowSet rs = template.queryForRowSet(DBQueries.SELECT_ORDERS_FROM_CUSTOMER, id);

        while (rs.next()) {
            orders.add(Order.create(rs));
        }
        return orders;
    }

}
