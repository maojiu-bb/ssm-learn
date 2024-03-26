package Test;

import com.pojo.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class BookTest {
    @Test
    public void bookFindByIdTest() {
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
        Book book = session.selectOne("findByBookId", 1);
//        输出结果
        System.out.println(book.getName());
//        关闭session
        session.close();
    }

    @Test
    public void bookInsertTest() {
        String resources = "mybatis-config.xml";
        Reader reader;

        try {
            reader = Resources.getResourceAsReader(resources);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession session = sqlSessionFactory.openSession();

        Book book = new Book();

        book.setName("SSM");
        book.setCount(8);

        session.insert("insertBook", book);

        session.commit();

        session.close();
    }
}
