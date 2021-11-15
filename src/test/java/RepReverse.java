import java.util.ArrayList;
import java.util.List;

public class RepReverse {
    static List<Part> ls = new ArrayList<Part>();
    static {
        Part p = new Part();
        p.setNo("H01");
        p.setRepNo("H02");
        ls.add(p);
        p = new Part();
        p.setNo("H02");
        p.setRepNo("H01");
        ls.add(p);
    }
    static List<Part> ls1 = new ArrayList<Part>();
    static {
        Part p = new Part();
        p.setNo("H01");
        p.setRepNo("H02");
        ls1.add(p);
        p = new Part();
        p.setNo("H02");
        p.setRepNo("H03");
        ls1.add(p);
        p = new Part();
        p.setNo("H03");
        p.setRepNo("H01");
        ls1.add(p);
//        p = new Part();
//        p.setNo("H04");
//        p.setRepNo("H01");
//        ls1.add(p);
    }
    static List<Part> ls2 = new ArrayList<Part>();
    static {
        Part p = new Part();
        p.setNo("H01");
        p.setRepNo("H02");
        ls2.add(p);
        p = new Part();
        p.setNo("H02");
        p.setRepNo("H01");
        ls2.add(p);
        p = new Part();
        p.setNo("H03");
        p.setRepNo("H02");
        ls2.add(p);
    }

    public static void main(String[] args) throws Exception {
        Part p = new Part();
        p.setNo("H03");
        p.setRepNo("H02");

        System.out.println(getRep(p, p, 0));

    }

    static final String rst = "不能设置循环替代关系，必须先解除“%s→%s”的替代关系后才能设置“%s→%s”替代关系。";
    static final String rst0 = "零件不存在 ";

    private static String getRep(Part srcp, Part nextp, int rank) {
        System.out.println(rank);

        // 上层零件，查找替代件是原件的零件
        if (rank == 0 && null == queryPart(nextp.getRepNo())) {
            return rst0;
        }
        Part rP = queryPart(nextp.getNo());
        if (null == rP)
            return "";
        if (rP.getNo().equals(srcp.repNo) || rank > 8)
            return String.format(rst, rP.getNo(), rP.getRepNo(), srcp.getNo(), srcp.getRepNo());
        return getRep(srcp, rP, ++rank);
    }

    static Part queryPart(String no) {
        // 模拟数据库检索
        for (Part p : ls2) {
            if (p.getRepNo().equals(no))
                return p;
        }
        return null;
    }

    public static class Part {
        private String no;
        private String repNo;

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getRepNo() {
            return repNo;
        }

        public void setRepNo(String repNo) {
            this.repNo = repNo;
        }

        @Override
        public String toString() {
            return "Part [no=" + no + ", repNo=" + repNo + "]";
        }

    }

}
