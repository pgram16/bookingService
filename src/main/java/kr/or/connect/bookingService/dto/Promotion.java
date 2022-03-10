package kr.or.connect.bookingService.dto;

public class Promotion {
	private Long id;
	private String fileName;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Override
	public String toString() {
		return "Promotion [id=" + id + ", fileName=" + fileName + "]";
	}
	
	
}
