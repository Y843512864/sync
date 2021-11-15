
import java.io.InputStream;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dodo.sync.vo.SParts;


public class MybatisTest {
    private final String CYCLE_REP_RST = "不能指定%s零件为%s零件的替代件，会造成循环替代。";
    private final String REP_PART_NOT_EXISTS = "替代件%s不存在。 ";
    private static SqlSession session;

    @Before
    public void init() {
        String resource = "mybatis.xml";
        // 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = MybatisTest.class.getClassLoader().getResourceAsStream(resource);
        // 构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        session = sessionFactory.openSession();/**
                                                * 映射sql的标识字符串，
                                                * com.oumyye.mapping.UserMapping是userMapper.xml文件中mapper标签的namespace属性的值，
                                                * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
                                                */
    }

    @After
    public void close() {
        session.close();
    }

    //@Test
    public void configTest(){
        Object o = session.selectList("mapping.UserMapping.getConfig");
        System.out.println(o);
    }
}