package Test;

import com.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

public class UserTest {
    @Test
    public void userSelectTest() {
        String resource = "mybatis-config.xml";

        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = sqlSessionFactory.openSession();

            List<User> users =  session.selectList("selectUser");

            for (User user : users) {
                System.out.println(user.toString());
            }

            session.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void userFindByIdTest() {
        String resources = "mybatis-config.xml";
//        创建流
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resources);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        初始化mybatis数据库，创建SqlSessionFactory类的示例
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//        创建sqlSession示例
        SqlSession session = sqlSessionFactory.openSession();
//        传入参数查询，返回结果
        User user = session.selectOne("findById", 1);
//        输出结果
        System.out.println(user.getUname());
//        关闭session
        session.close();
    }

    @Test
    public void userInsertTest() {
        String resources = "mybatis-config.xml";

        try {
            InputStream inputStream = Resources.getResourceAsStream(resources);

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = sqlSessionFactory.openSession();

            User user = new User();
            user.setUname("袁译");
            user.setUage(20);

            session.insert("insertUser", user);

            session.commit();

            session.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void userUpdateTest() {
        String resource = "mybatis-config.xml";

        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = sqlSessionFactory.openSession();

            User user = session.selectOne("findById", 1);

            user.setUage(66);

            session.update("updateUser", user);

            session.commit();

            session.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void userDeleteTest() {
        String resource = "mybatis-config.xml";

        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = sqlSessionFactory.openSession();

            session.delete("deleteUser", 2);

            session.commit();

            session.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
