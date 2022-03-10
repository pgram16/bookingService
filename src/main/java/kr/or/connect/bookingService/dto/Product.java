package kr.or.connect.bookingService.dto;

public class Product {
	
	private Long   productId;
	private Long   displayInfoId;
	private String fileName;
	private String description;
	private String placeName;
	private String content;
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getDisplayInfoId() {
		return displayInfoId;
	}
	public void setDisplayInfoId(Long displayInfoId) {
		this.displayInfoId = displayInfoId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", displayInfoId=" + displayInfoId + ", fileName=" + fileName
				+ ", description=" + description + ", placeName=" + placeName + ", content=" + content + "]";
	}

	
}
