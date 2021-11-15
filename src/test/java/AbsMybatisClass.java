import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public abstract class AbsMybatisClass {
    static SqlSession session;

    public abstract void execute();
    public void init() {
        String resource = "mybatis.xml";
        // 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = MybatisTest.class.getClassLoader().getResourceAsStream(resource);
        // 构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        /**
         * 映射sql的标识字符串，
         * com.oumyye.mapping.UserMapping是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        session = sessionFactory.openSession();
    }

    public void close() {
        session.close();
    }
}
