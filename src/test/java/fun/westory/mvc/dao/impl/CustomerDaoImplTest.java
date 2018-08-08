package fun.westory.mvc.dao.impl;

import fun.westory.mvc.dao.CriteriaCustomer;
import fun.westory.mvc.dao.CustomerDAO;
import fun.westory.mvc.pojo.Customer;
import org.junit.Test;

import java.util.List;

public class CustomerDaoImplTest {

    private CustomerDAO customerDAO = new CustomerDaoImpl();

    @Test
    public void testGetForListWithCriteriaCustomer() {
        CriteriaCustomer criteriaCustomer = new CriteriaCustomer("a","d","3");
        List<Customer> forListWithCriteriaCustomer = customerDAO.getForListWithCriteriaCustomer(criteriaCustomer);
        forListWithCriteriaCustomer.forEach(System.out::println);
}

    @Test
    public void getForListWithCriteriaCustomer() {
        
    }

    @Test
    public void getAll() {
        customerDAO.getAll().forEach(System.out::println);
    }

    @Test
    public void save() {
        Customer customer = new Customer();
        customer.setAddress("ShangHai");
        customer.setName("Jerry");
        customer.setPhone("13720998654");

        customerDAO.save(customer);
    }

    @Test
    public void get() {
        Customer customer = customerDAO.get(12);
        System.out.println(customer);
    }

    @Test
    public void delete() {
        customerDAO.delete(12);
    }

    @Test
    public void update() {
    }

    @Test
    public void getCountWithName() {
        long count = customerDAO.getCountWithName("Jam");
        System.out.println(count);
    }

}