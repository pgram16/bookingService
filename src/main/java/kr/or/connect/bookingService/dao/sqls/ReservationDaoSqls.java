package kr.or.connect.bookingService.dao.sqls;

public class ReservationDaoSqls {

	public static final String SELECT_RESERVATION_INFO_BY_EMAIL = 	"SELECT t1.id as reservationInfoId"
			                                              + "     , t1.product_id"
			                                              + "     , t1.display_info_id"
			                                              + "     , t1.reservation_name"
			                                              + "     , t1.reservation_tel"
			                                              + "     , t1.reservation_email"
			                                              + "     , t1.reservation_date"
			                                              + "     , CASE WHEN t1.cancel_flag = 1 THEN 'TRUE'"
			                                              + "            WHEN t1.cancel_flag = 0 THEN 'FALSE'"
			                                              + "       END as cancel_yn"
			                                              + "     , t1.create_date"
			                                              + "     , t1.modify_date"
			                                              + "     , (SELECT  IFNULL(SUM(price*count) ,0)"
			                                              + "          FROM reservation_info_price a1 "
			                                              + "     	 INNER JOIN product_price a2 ON a1.product_price_id = a2.id"
			                                              + "         WHERE a1.reservation_info_id = t1.id"
			                                              + "           AND a2.product_id = t1.product_id) as totalPrice"
			                                              + "     FROM reservation_info t1"
			                                              + "     WHERE t1.reservation_email = :reservationEmail";
	
	public static final String SELECT_RESERVATION_INFO_BY_ID = 	"SELECT t1.id as reservationInfoId"
			                                                  + "     , t1.product_id"
			                                                  + "     , t1.display_info_id"
			                                                  + "     , t1.reservation_name"
			                                                  + "     , t1.reservation_tel"
			                                                  + "     , t1.reservation_email"
			                                                  + "     , t1.reservation_date"
			                                                  + "     , CASE WHEN t1.cancel_flag = 1 THEN 'TRUE'"
			                                                  + "            WHEN t1.cancel_flag = 0 THEN 'FALSE'"
			                                                  + "       END as cancel_yn"
			                                                  + "     , t1.create_date"
			                                                  + "     , t1.modify_date"
			                                                  + "  FROM reservation_info t1"
			                                                  + " WHERE t1.id = :reservationId";
	
	public static final String SELECT_RESERVAION_INFO_PRICE_BY_ID = "SELECT t1.id as reservation_info_price_id"
                                                                   +"	  , t1.count"
                                                                   +"     , t1.reservation_info_id"
                                                                   +"     , t1.product_price_id"
                                                                   +"  FROM reservation_info_price t1"
                                                                   +" WHERE t1.reservation_info_id = :reservationId";
	
	public static final String UPDATE_CANCLE_FLAG = "UPDATE reservation_info "
                                                  + "   SET cancel_flag = 1 "
                                                  + " WHERE id = :reservationId ";
	
	public static final String RESERV_COUNT = "SELECT COUNT(t1.id) FROM reservation_info t1 WHERE t1.reservation_email = :email";
	
}
