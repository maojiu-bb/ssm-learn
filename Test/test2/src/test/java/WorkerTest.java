import com.pojo.Worker;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.MybatisUtil;

public class WorkerTest {
    @Test
    public void selectByIdTest() {
        SqlSession session = MybatisUtil.getSession();
        Worker worker = session.selectOne("findWorkerById", 2);
        System.out.println(worker.toString());
        session.close();
    }

    @Test
    public void updateByIdTest() {
        SqlSession session = MybatisUtil.getSession();
        Worker worker = new Worker();
        worker.setId(1);
        worker.setName("袁译");
        worker.setAge(20);
        worker.setPosition("学生");
        session.update("updateWorkerById", worker);
        session.commit();
        session.close();
    }

    @Test
    public void deleteByIdTest() {
        SqlSession session = MybatisUtil.getSession();
        session.delete("deleteWorkerById", 1);
        session.commit();
        session.close();
    }

    @Test
    public void insertWorkerTest() {
        SqlSession session = MybatisUtil.getSession();
        Worker worker = new Worker();
        worker.setName("袁译");
        worker.setAge(20);
        worker.setPosition("学生");
        session.insert("insertWorkerMapper", worker);
        session.commit();
        session.close();
    }
}
