package com.cbs.model;

public class Cab {

	private Integer cabId;
	private String cabNumber;
	private String driverName;
	private String driverNumber;
	private String cabIsBooked;

	public Cab() {

	}

	public Cab(Integer cabId, String cabNumber, String driverName, String driverNumber, String bookedStatus) {
		super();
		this.cabId = cabId;
		this.cabNumber = cabNumber;
		this.driverName = driverName;
		this.driverNumber = driverNumber;
		this.cabIsBooked = bookedStatus;
	}

	public Integer getCabId() {
		return cabId;
	}

	public void setCabId(Integer cabId) {
		this.cabId = cabId;
	}

	public String getCabNumber() {
		return cabNumber;
	}

	public void setCabNumber(String cabNumber) {
		this.cabNumber = cabNumber;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverNumber() {
		return driverNumber;
	}

	public void setDriverNumber(String driverNumber) {
		this.driverNumber = driverNumber;
	}

	@Override
	public String toString() {
		return "Cab [cabId=" + cabId + ", cabNumber=" + cabNumber + ", driverName=" + driverName + ", driverNumber="
				+ driverNumber + ", cabIsBooked=" + cabIsBooked + "]";
	}

	public String getCabIsBooked() {
		return cabIsBooked;
	}

	public void setCabIsBooked(String cabIsBooked) {
		this.cabIsBooked = cabIsBooked;
	}

}
