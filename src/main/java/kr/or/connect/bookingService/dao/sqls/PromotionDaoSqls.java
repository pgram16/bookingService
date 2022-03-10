package kr.or.connect.bookingService.dao.sqls;

public class PromotionDaoSqls {
	
	public static final String SELECT_PROMOTION = "SELECT t2.id, t4.file_name"
			                                    + "  FROM product t1"
			                                    + " INNER JOIN promotion t2 ON t1.id = t2.product_id"
			                                    + " INNER JOIN product_image t3 ON t1.id = t3.product_id"
			                                    + " INNER JOIN file_info t4 ON t3.file_id= t4.id"
			                                    + " WHERE t3.type = 'th'"
			                                    + " ORDER BY t1.description";
	
}
