package ibf2022.paf.day21workshop.respository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import ibf2022.paf.day21workshop.model.Customer;

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
        return null;
    }
}
