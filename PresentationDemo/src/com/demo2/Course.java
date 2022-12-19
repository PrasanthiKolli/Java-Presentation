package com.demo2;

public class Course {
	private int courseId;
	private String courseName;
	private String teacher;
	private int duration;
	private long totalFee;

	public Course(int courseId, String courseName, String teacher, int duration, long totalFee) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.teacher = teacher;
		this.duration = duration;
		this.totalFee = totalFee;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(long totalFee) {
		this.totalFee = totalFee;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", teacher=" + teacher + ", duration="
				+ duration + ", totalFee=" + totalFee + "]";
	}

	

}

