package kr.or.connect.bookingService.dto;

import java.util.Date;
import java.util.List;

public class ReservationInfo {

	private Integer reservationInfoId;
	private Integer productId;
	private Integer displayInfoId;
	private String reservationName;
	private String reservationTel;
	private String reservationEmail;
	private String reservationDate;
	private List<ReservationInfoPrice> prices;
	private Integer cancelFlag;
	private Boolean cancelYn;
	private Date createDate;
	private Date modifyDate;
	private String reservationYearMonthDay;
	private int totalPrice;
	private Display displayInfo;
	

	public Integer getReservationInfoId() {
		return reservationInfoId;
	}

	public void setReservationInfoId(Integer reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getDisplayInfoId() {
		return displayInfoId;
	}

	public void setDisplayInfoId(Integer displayInfoId) {
		this.displayInfoId = displayInfoId;
	}

	public String getReservationName() {
		return reservationName;
	}

	public void setReservationName(String reservationName) {
		this.reservationName = reservationName;
	}

	public String getReservationTel() {
		return reservationTel;
	}

	public void setReservationTel(String reservationTel) {
		this.reservationTel = reservationTel;
	}

	public String getReservationEmail() {
		return reservationEmail;
	}

	public void setReservationEmail(String reservationEmail) {
		this.reservationEmail = reservationEmail;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}



	public Integer getCancelFlag() {
		return cancelFlag;
	}

	public void setCancelFlag(Integer cancelFlag) {
		this.cancelFlag = cancelFlag;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public List<ReservationInfoPrice> getPrices() {
		return prices;
	}

	public void setPrices(List<ReservationInfoPrice> prices) {
		this.prices = prices;
	}

	public String getReservationYearMonthDay() {
		return reservationYearMonthDay;
	}

	public void setReservationYearMonthDay(String reservationYearMonthDay) {
		this.reservationYearMonthDay = reservationYearMonthDay;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Display getDisplayInfo() {
		return displayInfo;
	}

	public void setDisplayInfo(Display displayInfo) {
		this.displayInfo = displayInfo;
	}

	public Boolean getCancelYn() {
		return cancelYn;
	}

	public void setCancelYn(Boolean cancelYn) {
		this.cancelYn = cancelYn;
	}

	@Override
	public String toString() {
		return "ReservationInfo [reservationInfoId=" + reservationInfoId + ", productId=" + productId
				+ ", displayInfoId=" + displayInfoId + ", reservationName=" + reservationName + ", reservationTel="
				+ reservationTel + ", reservationEmail=" + reservationEmail + ", reservationDate=" + reservationDate
				+ ", prices=" + prices + ", cancelFlag=" + cancelFlag + ", cancelYn=" + cancelYn + ", createDate="
				+ createDate + ", modifyDate=" + modifyDate + ", reservationYearMonthDay=" + reservationYearMonthDay
				+ ", totalPrice=" + totalPrice + ", displayInfo=" + displayInfo + "]";
	}



	

}
