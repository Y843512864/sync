
public class sqlcount {
	public static void main(String[] args) {
		String sql = "SELECT s.ORDER_NO,s.STATUS_CD,s.USAGE_CD,s.TYPE_CD,s.CUST_NAME,sr.CODE,sr.SERVICE_ADVISOR_NAME,s.SR_ID,s.VIN AS vin,nvl(vehicle.PLATE_NUMBER,s.PLATE_NUMBER) as PLATE_NUMBER,s.REMARK, " +
                "s.ORDER_DT,s.CUST_CELLPHONE,s.SALES_MAN,s.CORPORATION_CODE,s.CORPORATION_NAME,s.DEALER_ID,s.ROWVERSION AS ROW_VERSION,rs.*  " +
                " FROM (SELECT id,VEHICLE_ID,ORDER_NO,PLATE_NUMBER, STATUS_CD, USAGE_CD, TYPE_CD,  CUST_NAME, SR_ID, VIN, REMARK, ORDER_DT, CUST_CELLPHONE, SALES_MAN,\n" +
                "CORPORATION_CODE,CORPORATION_NAME,DEALER_ID, ROWVERSION FROM S_ORDER s WHERE TYPE_CD=1 " +
                //NDMS-2854  优化sql  edit by pactera 2019-08-20 start
                " UNION ALL SELECT id,VEHICLE_ID,ORDER_NO,PLATE_NUMBER, STATUS_CD, USAGE_CD, TYPE_CD,  CUST_NAME, SR_ID, VIN, REMARK, ORDER_DT, CUST_CELLPHONE, SALES_MAN,\n" +
                "CORPORATION_CODE,CORPORATION_NAME,DEALER_ID, ROWVERSION FROM S_ORDER s WHERE TYPE_CD=3 "+
                //NDMS-2854  edit by pactera 2019-08-20 end
                " ) s JOIN " +
                "(SELECT s.id, " +
                //NDMS-2854 只保留订购数、缺货数、明细总数、含税成本价、含税销售价  edit by pactera 2019-08-20
                "NVL(SUM(sd.PLAN_QTY), 0) AS PLAN_QTY, " +
                "NVL(SUM(sd.ORDER_QTY), 0) AS ORDER_QTY , " +
                "NVL(SUM(sd.OUTSTOCK_SCH_QTY), 0) AS OUTSTOCK_SCH_QTY," +
                "NVL(SUM(sd.CANCEL_QTY), 0) AS CANCEL_QTY, " +
                "NVL(SUM(sd.OUTSTOCK_QTY), 0) AS OUTSTOCK_QTY, " + 
                "NVL(SUM(sd.LOCK_QTY), 0) AS LOCK_QTY," +
                "NVL(SUM( bo.BO_Qty ),0) AS BO_Qty,\n"+
                "count(*) AS DTL_QTY," +
                "NVL(SUM(sd.MARKET_PRICE * sd.ORDER_QTY), 0) AS MARKET_PRICE," +
                "NVL(SUM(sd.TAX_COST * sd.ORDER_QTY), 0) AS TAX_COST," +
                "NVL(SUM(sps.ONHAND_QTY), 0) AS ONHAND_QTY," +
                "SUM( CASE WHEN (NVL(sd.ORDER_QTY, 0) - NVL(sd.CANCEL_QTY, 0) - NVL(sd.OUTSTOCK_QTY, 0) - NVL(sd.REP_QTY, 0) - " +
                "NVL(sd.LOCK_QTY, 0))<0 THEN 0 ELSE (NVL(sd.ORDER_QTY, 0) - NVL(sd.CANCEL_QTY, 0) - NVL(sd.OUTSTOCK_QTY, 0) - NVL(sd.REP_QTY, 0) -" +
                "NVL(sd.LOCK_QTY, 0)) END ) AS SUSPLUS_QTY \n" +
                "FROM S_ORDER s " +
                //"NVL(sd.LOCK_QTY, 0) - NVL(sps.ONHAND_QTY, 0)) END ) AS BO_QTY FROM (select s.* from S_ORDER s  where  s.id in (:orderIds) ) s " +
                "JOIN S_ORDER_DTL sd ON sd.ORDER_ID = s.ID JOIN S_PARTS_STOCK sps ON sps.PARTS_ID = sd.PARTS_ID \n" +
                "LEFT JOIN\n" +
                //"VIEW_ORDER_BO bo  \n" +
                "(SELECT BO_Qty, ORDER_ID, PARTS_ID, ID FROM\n" +
                    "(  SELECT CASE WHEN NVL(odtl.ORDER_QTY, 0) - NVL(odtl.OUTSTOCK_QTY, 0) - NVL(odtl.CANCEL_QTY, 0) -\n" +
                    "NVL(ps.ONHAND_QTY, 0) - NVL(ps1.ONHAND_QTY, 0) - NVL(ps2.ONHAND_QTY, 0) - NVL\n" +
                    "(ps3.ONHAND_QTY, 0) - NVL(ps4.ONHAND_QTY, 0) - NVL(ps5.ONHAND_QTY, 0) - NVL\n" +
                    "(odtl.LOCK_QTY, 0) < 0\n" +
                    "THEN 0\n" +
                    "WHEN NVL(odtl.ORDER_QTY, 0) - NVL(odtl.OUTSTOCK_QTY, 0) - NVL(odtl.CANCEL_QTY, 0) -\n" +
                    "NVL(ps.ONHAND_QTY, 0) - NVL(ps1.ONHAND_QTY, 0) - NVL(ps2.ONHAND_QTY, 0) - NVL\n" +
                    "(ps3.ONHAND_QTY, 0) - NVL(ps4.ONHAND_QTY, 0) - NVL(ps5.ONHAND_QTY, 0) - NVL\n" +
                    "(odtl.LOCK_QTY, 0) >= 0\n" +
                    "THEN NVL(odtl.ORDER_QTY, 0) - NVL(odtl.OUTSTOCK_QTY, 0) - NVL(odtl.CANCEL_QTY, 0) -\n" +
                    "NVL(ps.ONHAND_QTY, 0) - NVL(ps1.ONHAND_QTY, 0) - NVL(ps2.ONHAND_QTY, 0) - NVL\n" +
                    "(ps3.ONHAND_QTY, 0) - NVL(ps4.ONHAND_QTY, 0) - NVL(ps5.ONHAND_QTY, 0) - NVL\n" +
                    "(odtl.LOCK_QTY, 0) END AS BO_Qty,\n" +
                    "odtl.ORDER_ID, odtl.PARTS_ID, odtl.ID\n" +
                    "FROM S_ORDER s,  S_ORDER_DTL odtl\n" +
                    "LEFT JOIN      S_PARTS parts   ON     parts.ID = odtl.PARTS_ID\n" +
                    "LEFT JOIN         S_PARTS_STOCK ps   ON    odtl.PARTS_ID = ps.PARTS_ID   AND ps.DEALER_ID = odtl.DEALER_ID\n" +
                    "LEFT JOIN        S_PARTS p1     ON    p1.PARTS_NO = parts.REP_NEW_PARTSNO\n" +
                    "LEFT JOIN      S_PARTS_STOCK ps1    ON     p1.ID = ps1.PARTS_ID    AND ps1.DEALER_ID = odtl.DEALER_ID\n" +
                    "LEFT JOIN         S_PARTS p2       ON        p2.PARTS_NO = p1.REP_NEW_PARTSNO\n" +
                    "LEFT JOIN     S_PARTS_STOCK ps2     ON       p2.ID = ps2.PARTS_ID    AND ps2.DEALER_ID = odtl.DEALER_ID\n" +
                    "LEFT JOIN         S_PARTS p3    ON      p3.PARTS_NO = p2.REP_NEW_PARTSNO\n" +
                    "LEFT JOIN      S_PARTS_STOCK ps3  ON     p3.ID = ps3.PARTS_ID AND ps3.DEALER_ID = odtl.DEALER_ID\n" +
                    "LEFT JOIN      S_PARTS p4    ON      p4.PARTS_NO = p3.REP_NEW_PARTSNO\n" +
                    "LEFT JOIN         S_PARTS_STOCK ps4   ON       p4.ID = ps4.PARTS_ID   AND ps4.DEALER_ID = odtl.DEALER_ID\n" +
                    "LEFT JOIN       S_PARTS p5     ON      p5.PARTS_NO = p4.REP_NEW_PARTSNO\n" +
                    "LEFT JOIN        S_PARTS_STOCK ps5   ON      p5.ID = ps5.PARTS_ID     AND ps5.DEALER_ID = odtl.DEALER_ID\n" +
                    "WHERE        s.ID = odtl.ORDER_ID AND odtl.STATUS_CD <> 5 AND s.TYPE_CD IN (1,3) " +
                    ") WHERE  BO_QTY > 0) bo  \n" +
                "ON bo.ORDER_ID = s.id AND bo.PARTS_ID = sd.PARTS_ID\n"+
                "GROUP BY s.ID ) rs ON rs.id = s.id " +
                "LEFT JOIN S_SR sr ON s.SR_ID = sr.ID " +
                "LEFT JOIN VEHICLE vehicle ON vehicle.id = s.VEHICLE_ID " + //NDMSW-9064 零部件销售-订单，订单的车牌号，根据车辆关联出来，包括相关的查询
                //"where s.TYPE_CD IN (1,3) ";
                "where 1=1 ";
		
		System.out.println(sql);
//		System.out.println(getCountQL(sql));
	}
	private static String getCountQL(String ql) {
        int fromPositionForQl = 0;
        int fromPositionForCurrentSubQl;// 默认取第一个from
        String subQl = ql.toLowerCase();
        boolean flag = false;
        while ((fromPositionForCurrentSubQl = subQl.indexOf("from")) != -1) {
            fromPositionForQl += fromPositionForCurrentSubQl + "from".length();
            if (qlFromOutOfBrackets(subQl)) {
                flag = true;
                break;
            }
            subQl = subQl.substring(fromPositionForCurrentSubQl + "from".length());
        }
        if (fromPositionForQl == 0 || !flag) {
            throw new RuntimeException("Query language error.");
        }
        return "select count(*) from " + ql.substring(fromPositionForQl);
    }
	
	private static boolean qlFromOutOfBrackets(String ql) {
        boolean flag;
        String subQl = ql.substring(ql.toLowerCase().indexOf("from") + "from".length());
        int countA = 0;
        int position;
        String subSubQl = subQl;
        while ((position = subSubQl.indexOf("(")) != -1 && ((subSubQl.substring(0, position + 1).split("'").length - 1) % 2 == 0)) {
            countA++;
            subSubQl = subSubQl.substring(position + "(".length());
        }
        subSubQl = subQl;
        while ((position = subSubQl.indexOf(")")) != -1 && ((subSubQl.substring(0, position + 1).split("'").length - 1) % 2 == 0)) {
            countA--;
            subSubQl = subSubQl.substring(position + ")".length());
        }
        if (countA == 0) {
            // from 在（）之外
            flag = true;
        } else if (countA < 0) {
            // from 在()之内
            flag = false;
        } else {
            // 非法的，from后边的")"应该多于或等于"("
            flag = false;
        }
        return flag;
    }
}
