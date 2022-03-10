package kr.or.connect.bookingService.dao.sqls;

public class ReservationCommentDaoSqls {
	
	public static final String SELECT_COMMENT_ALL  =  "SELECT t2.comment"
			                                        + "     , t2.id AS comment_id"
			                                        + "     , t2.create_date"
			                                        + "     , t2.modify_date"
			                                        + "     , t2.product_id"
			                                        + "     , t1.reservation_date"
			                                        + "     , t1.reservation_email"
			                                        + "     , t2.reservation_info_id"
			                                        + "     , t1.reservation_name"
			                                        + "     , t1.reservation_tel AS reservation_telephone"
			                                        + "     , t2.score"
			                                        + "     FROM reservation_info t1"
			                                        + "     INNER JOIN reservation_user_comment t2 ON t1.id = t2.reservation_info_id"
			                                        + "     WHERE t1.display_info_id = :displayInfoId";
	
	
	public static final String SELECT_SCORE_AVG = "SELECT ROUND(IFNULL(AVG(t2.score), 0), 1)"
												+ " FROM reservation_info t1"
												+ " INNER JOIN reservation_user_comment t2 ON t1.id = t2.reservation_info_id"
												+ " WHERE t1.display_info_id = :displayInfoId";
	
	public static final String SELECT_COMMENT_IMAGES = "SELECT t2.content_type"
			                                         + "     , t2.create_date"
			                                         + "     , t2.delete_flag"
			                                         + "     , t1.file_id"
			                                         + "     , t2.file_name"
			                                         + "     , t1.id AS image_id"
			                                         + "     , t2.modify_date"
			                                         + "     , t1.reservation_info_id"
			                                         + "     , t1.reservation_user_comment_id"
			                                         + "     , t2.save_file_name"
			                                         + "     FROM reservation_user_comment_image t1"
			                                         + "     INNER JOIN file_info t2 ON t1.file_id = t2.id"
			                                         + "     WHERE t1.reservation_info_id = :reservationInfoId"
			                                         + "     AND t1.reservation_user_comment_id = :commentId";

}
        

