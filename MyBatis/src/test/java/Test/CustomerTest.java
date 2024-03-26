package Test;

import com.pojo.Customer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import utils.MyBatisUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class CustomerTest {
    String resource = "mybatis-config.xml";

    @Test
    public void selectCustomerByUsernameAndJobs () {
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = sqlSessionFactory.openSession();

            Customer newCustomer = new Customer();

            newCustomer.setUsername("jack");
            newCustomer.setJobs("teacher");

            List<Customer> customerList = session.selectList("selectCustomerByUsernameAndJobs", newCustomer);

            for (Customer customer: customerList) {
                System.out.println(customer.toString());
            }

            session.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void updateCustomerBySet() {
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = sqlSessionFactory.openSession();

            Customer customer = new Customer();

            customer.setId(3);
            customer.setPhone("13125260868");

            int rows = session.update("updateCustomerBySet", customer);

            if (rows > 0) {
                System.out.println("update: " + rows);
            } else {
                System.out.println("error");
            }

            session.commit();

            session.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void findByArray() {

        SqlSession session = MyBatisUtil.getSession();

        int[] ids = {2, 3};

        List<Customer> customerList = session.selectList("selectByArray", ids);

        for (Customer customer: customerList) {
            System.out.println(customer.toString());
        }

        session.close();
    }

    @Test
    public void findByList() {
        SqlSession session = MyBatisUtil.getSession();

        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);

        List<Customer> customerList = session.selectList("selectByList", ids);

        for (Customer customer: customerList) {
            System.out.println(customer.toString());
        }

        session.close();
    }

    @Test
    public void findByMap() {
        SqlSession session = MyBatisUtil.getSession();

        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("id", ids);
        map.put("jobs", "teacher");

        List<Customer> customerList = session.selectList("selectByMap", map);

        for (Customer customer: customerList) {
            System.out.println(customer.toString());
        }

        session.close();
    }
}
