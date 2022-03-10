package kr.or.connect.bookingService.dao.sqls;

public class CatalogDaoSqls {
	
	
	public static final String SELECT_CATALOG_COUNT = "SELECT count(*)" 
													+ "  FROM display_info t1"
	                                                + " INNER JOIN product t2 ON t1.product_id = t2.id"
	                                                + " WHERE :id = '0' OR t2.category_id = :id";
	
	public static final String SELECT_CATALOG = "SELECT t1.id as product_id, t2.id as display_info_id, t4.file_name, t1.description, t2.place_name, t1.content"
										      + "  FROM product t1"
										      + " INNER JOIN display_info t2 ON t1.id = t2.product_id"
										      + " INNER JOIN product_image t3 ON t1.id = t3.product_id"
										      + " INNER JOIN file_info t4 ON t3.file_id= t4.id"
										      + " WHERE t3.type = 'th'"
										      + "   AND (:id = '0' OR t1.category_id = :id)"
										      + " ORDER BY t1.id"
										      + " LIMIT :start , :end";
	
}
