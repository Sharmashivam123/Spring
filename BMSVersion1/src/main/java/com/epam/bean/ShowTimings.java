package com.epam.bean;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "showtiming")
public class ShowTimings {
	@Id
	private int timingId;
	private LocalTime show1;
	private LocalTime show2; 
	private LocalTime show3;
	private LocalTime show4;

	public int getTimingId() {
		return timingId;
	}

	public void setTimingId(int timingId) {
		this.timingId = timingId;
	}

	public LocalTime getShow1() {
		return show1;
	}

	public void setShow1(LocalTime show1) {
		this.show1 = show1;
	}

	public LocalTime getShow2() {
		return show2;
	}

	public void setShow2(LocalTime show2) {
		this.show2 = show2;
	}

	public LocalTime getShow3() {
		return show3;
	}

	public void setShow3(LocalTime show3) {
		this.show3 = show3;
	}

	public LocalTime getShow4() {
		return show4;
	}

	public void setShow4(LocalTime show4) {
		this.show4 = show4;
	}
}
