import com.dao.WorkerMapper;
import com.pojo.Worker;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.MybatisUtil;

public class WorkerDaoTest {
    @Test
    public void selectTest() {
        SqlSession session = MybatisUtil.getSession();
        WorkerMapper workerMapper = session.getMapper(WorkerMapper.class);
        Worker worker = workerMapper.selectWorker(4);
        System.out.println(worker.toString());
        session.close();
    }

    @Test
    public void updateTest() {
        SqlSession session = MybatisUtil.getSession();
        Worker worker = new Worker();
        worker.setId(2);
        worker.setName("艾杰");
        worker.setAge(19);
        worker.setPosition("学生");
        WorkerMapper workerMapper = session.getMapper(WorkerMapper.class);
        workerMapper.updateWorker(worker);
        session.commit();
        session.close();
    }

    @Test
    public void deleteTest() {
        SqlSession session = MybatisUtil.getSession();
        WorkerMapper workerMapper = session.getMapper(WorkerMapper.class);
        workerMapper.deleteWorker(3);
        session.commit();
        session.close();
    }

    @Test
    public void insertTest() {
        SqlSession session = MybatisUtil.getSession();
        Worker worker = new Worker();
        worker.setName("刘纯阳");
        worker.setAge(18);
        worker.setPosition("老师");
        WorkerMapper workerMapper = session.getMapper(WorkerMapper.class);
        workerMapper.insertWorker(worker);
        session.commit();
        session.close();
    }
}
