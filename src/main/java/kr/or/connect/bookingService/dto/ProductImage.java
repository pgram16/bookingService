package kr.or.connect.bookingService.dto;

public class ProductImage {

	private String contentType;
	private String createDate;
	private boolean deleteFlag;
	private Long fileInfoId;
	private String modifyDate;
	private Long productId;
	private Long productImageId;
	private String saveFileName;
	private String type;
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public boolean isDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public Long getFileInfoId() {
		return fileInfoId;
	}
	public void setFileInfoId(Long fileInfoId) {
		this.fileInfoId = fileInfoId;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getProductImageId() {
		return productImageId;
	}
	public void setProductImageId(Long productImageId) {
		this.productImageId = productImageId;
	}
	public String getSaveFileName() {
		return saveFileName;
	}
	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "ProductImage [contentType=" + contentType + ", createDate=" + createDate + ", deleteFlag=" + deleteFlag
				+ ", fileInfoId=" + fileInfoId + ", modifyDate=" + modifyDate + ", productId=" + productId
				+ ", productImageId=" + productImageId + ", saveFileName=" + saveFileName + ", type=" + type + "]";
	}
	
	
	
}
