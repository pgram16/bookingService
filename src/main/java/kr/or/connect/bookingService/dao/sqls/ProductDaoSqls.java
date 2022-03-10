package kr.or.connect.bookingService.dao.sqls;

public class ProductDaoSqls {

	public static final String SELECT_PRODUCT_IMAGE =   "SELECT t4.content_type"
			                                          + "     , t4.create_date"
			                                          + "     , t4.delete_flag"
			                                          + "     , t4.id AS file_info_id"
			                                          + "     , t4.file_name"
			                                          + "     , t4.modify_date"
			                                          + "     , t1.id AS product_id"
			                                          + "     , t3.id AS product_image_id"
			                                          + "     , t4.save_file_name"
			                                          + "     , t3.type"
			                                          + "     FROM product t1"
			                                          + "     INNER JOIN display_info t2  ON t1.id      = t2.product_id"
			                                          + "     INNER JOIN product_image t3 ON t1.id      = t3.product_id"
			                                          + "     INNER JOIN file_info t4     ON t3.file_id = t4.id"
			                                          + "     WHERE t2.id    = :displayInfoId"
			                                          + "     AND t3.type != 'th'"
			                                          + "     AND (:type IS NULL OR (t3.type = 'ma' OR t3.type = 'et'))"
			                                          + "     ORDER BY product_image_id";
			                                          
	
	
	public static final String SELECT_PRODUCT_PRICE =   "SELECT t3.create_date"
			                                          + "     , t3.discount_rate"
			                                          + "     , t3.modify_date"
			                                          + "     , t3.price"
			                                          + "     , t3.price_type_name"
			                                          + "     , t3.product_id"
			                                          + "     , t3.id AS product_price_id"
			                                          + "     FROM display_info t1"
			                                          + "     INNER JOIN product t2 ON t1.product_id = t2.id"
			                                          + "     INNER JOIN product_price t3 ON t3.product_id = t2.id"
			                                          + "     WHERE t1.id = :displayInfoId"
			                                          + "     ORDER BY price";
			



	
	
}


