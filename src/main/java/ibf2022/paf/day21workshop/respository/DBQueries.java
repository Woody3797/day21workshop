package ibf2022.paf.day21workshop.respository;

public class DBQueries {
    
    public static final String SELECT_ALL_CUSTOMERS = "SELECT id, company, first_name, last_name FROM customer LIMIT ?, ?";
    public static final String SELECT_CUSTOMER_BY_ID = "SELECT id, company, first_name, last_name FROM customer WHERE id = ?";
    public static final String SELECT_ORDERS_FROM_CUSTOMER = "SELECT c.id AS customer_id, c.company, o.id AS order_id, o.ship_name, o.shipping_fee FROM customer c, orders o WHERE c.id = o.customer_id AND customer_id = ?";
}
