package Test;

import com.pojo.Person;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.MyBatisUtil;

public class MyBatisTest {
    @Test
    public void findPersonByIdTest() {
        SqlSession session = MyBatisUtil.getSession();
        Person person = session.selectOne("findPersonById", 1);
        System.out.println(person.toString());
        session.close();
    }
}
