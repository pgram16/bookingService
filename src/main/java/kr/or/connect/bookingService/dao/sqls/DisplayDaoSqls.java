package kr.or.connect.bookingService.dao.sqls;

public class DisplayDaoSqls {

	public static final String SELECT_DISPLAY_INFO =     "SELECT t2.category_id"
			                                           + "     , t4.name AS category_name"
			                                           + "     , t1.create_date"
			                                           + "     , t1.id AS display_info_id"
			                                           + "     , t1.email"
			                                           + "     , t1.homepage"
			                                           + "     , t1.modify_date"
			                                           + "     , t1.opening_hours"
			                                           + "     , t1.place_lot"
			                                           + "     , t1.place_name"
			                                           + "     , t1.place_street"
			                                           + "     , t2.content AS product_content"
			                                           + "     , t2.description AS product_description"
			                                           + "     , t2.event AS product_event"
			                                           + "     , t2.id AS product_id"
			                                           + "     , t1.tel AS telephone"
                                                       + " FROM display_info t1"
                                                       + " INNER JOIN product t2 ON t1.product_id = t2.id"
                                                       + " INNER JOIN display_info_image t3 ON t1.id = t3.display_info_id"
                                                       + " INNER JOIN category t4 ON t4.id = t2.category_id"
                                                       + " WHERE t1.id = :displayInfoId";
	
	public static final String SELECT_DISPLAY_INFO_IMAGE = "SELECT t3.content_type"
			                                             + "     , t3.create_date"
			                                             + "     , t3.delete_flag"
			                                             + "     , t1.id AS display_info_id"
			                                             + "     , t2.id AS display_info_image_id"
			                                             + "     , t3.id AS file_id"
			                                             + "     , t3.file_name"
			                                             + "     , t3.modify_date"
			                                             + "     , t3.save_file_name"
			                                             + "     FROM display_info t1"
			                                             + "     INNER JOIN display_info_image t2 ON t1.id = t2.display_info_id"
			                                             + "     INNER JOIN file_info t3 ON t2.file_id = t3.id"
			                                             + "     WHERE t1.id = :displayInfoId";
}
