package ibf2022.paf.day21workshop.respository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import ibf2022.paf.day21workshop.model.Customer;

public class CustomerRowMapper implements RowMapper<Customer>{

    @Override
    @Nullable
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setId(rs.getInt("id"));
        customer.setCompany(rs.getString("company"));
        customer.setLastName(rs.getString("last_name"));
        customer.setFirstName(rs.getString("first_name"));
        return customer;
    }

}
