
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

    @Test
    public void configTest(){
        Object o = session.selectList("mapping.UserMapping.getConfig");
        System.out.println(o);
    }

//    @Test
//    public void test() {
//        SParts rPn = new SParts();
//        rPn.setId("123");
//        rPn.setPartsNo("46100THAH05");// 1219121912b
//        rPn.setRepNewPartsno("46100THAH02");// 121912191220
////        System.out.println(getAllPatsTree(rPn, rPn));
//        String rst ="";
//
//        if (null != rPn.getRepNewPartsno() && !"".equals(rPn.getRepNewPartsno())) {
//            SParts repSp = session.selectOne("mapping.UserMapping.getPartsByNo", rPn.getRepNewPartsno());
//            SParts currentSp = session.selectOne("mapping.UserMapping.getPartsByNo", rPn.getPartsNo());
//
//            if (null == repSp && !StringUtils.equals(currentSp.getRepNewPartsno(), rPn.getRepNewPartsno())) {
//                rst = String.format(REP_PART_NOT_EXISTS, rPn.getRepNewPartsno());
//            } else if (StringUtils.equals(rPn.getRepNewPartsno(), rPn.getPartsNo())) {
//                rst =  String.format(CYCLE_REP_RST, rPn.getRepNewPartsno(), rPn.getPartsNo());
//            } else {
//                 rst = getAllPatsTree(rPn, rPn);
////                if (!rst.equals("")) {
////                    return new ClientRequestResult(false, rst, null);
////                }
//            }
//        }
//
//        System.out.println(rst);
//
//
//    }
//
////    private String getAllPatsTree(SParts srcp, SParts nextp) {
////        List<SParts> rP = session.selectList("mapping.UserMapping.getPartsByRepNo", nextp.getPartsNo());
////        for (SParts sp : rP) {
////            if (sp.getPartsNo().equals(srcp.getRepNewPartsno()) && sp.getRepNewPartsno().equals(srcp.getPartsNo())) {
////                return String.format(rst, nextp.getPartsNo(), nextp.getRepNewPartsno(), srcp.getPartsNo(),
////                        srcp.getRepNewPartsno());
////            }
////            System.out.println(sp);
////            return getAllPatsTree(srcp, sp);
////        }
////        return "";
////    }
//    private String getAllPatsTree(SParts srcp, SParts nextp) {
//        List<SParts> rP = session.selectList("mapping.UserMapping.getPartsByRepNo", nextp.getPartsNo());    
//        for (SParts sp : rP) {
//            if (StringUtils.equals(sp.getPartsNo(), srcp.getRepNewPartsno())) {
//                return String.format(CYCLE_REP_RST, srcp.getRepNewPartsno(), srcp.getPartsNo());
//            }
//            return getAllPatsTree(srcp, sp);
//        }
//        return "";
//    }
//    private String getRep(SParts srcp, SParts nextp, int rank) {
////        SParts rP = session.selectOne("mapping.UserMapping.getPartsByNo", nextp.getRepNewPartsno());
//        SParts rP = session.selectOne("mapping.UserMapping.getPartsByRepNo", nextp.getPartsNo());
//        if (rP == null)
//            return "";
//        else if (rP.getRepNewPartsno().equals(srcp.getPartsNo()) || rank > 8)
//            return String.format("", srcp.getPartsNo(), srcp.getRepNewPartsno(), rP.getPartsNo(),
//                    rP.getRepNewPartsno());
//        return getRep(srcp, rP, ++rank);
//    }
}