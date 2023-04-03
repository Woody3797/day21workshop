package ibf2022.paf.day21workshop.respository;

public class DBQueries {
    
    public static final String SELECT_ALL_CUSTOMERS = "SELECT id, company, first_name, last_name FROM customers LIMIT ? , ?";
}
