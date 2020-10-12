package com.pojo;

// Generated Mar 12, 2019 11:57:25 AM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * Booking generated by hbm2java
 */
public class Booking implements java.io.Serializable {

	private Integer bid;
	private Addevent addevent;
	private Registration registration;
	private String bookingtime;
	private Date bookingdate;

	public Booking() {
	}

	public Booking(Addevent addevent, Registration registration, String bookingtime, Date bookingdate) {
		this.addevent = addevent;
		this.registration = registration;
		this.bookingtime = bookingtime;
		this.bookingdate = bookingdate;
	}

	public Integer getBid() {
		return this.bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public Addevent getAddevent() {
		return this.addevent;
	}

	public void setAddevent(Addevent addevent) {
		this.addevent = addevent;
	}

	public Registration getRegistration() {
		return this.registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

	public String getBookingtime() {
		return this.bookingtime;
	}

	public void setBookingtime(String bookingtime) {
		this.bookingtime = bookingtime;
	}

	public Date getBookingdate() {
		return this.bookingdate;
	}

	public void setBookingdate(Date bookingdate) {
		this.bookingdate = bookingdate;
	}

}