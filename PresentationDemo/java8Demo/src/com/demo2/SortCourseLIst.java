package com.demo2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortCourseLIst {
	public static void main(String[] args) {
		List<Course> courseList = new ArrayList<Course>();
		courseList.add(new Course(1, "JEE", "Tom", 2, 10000));
		courseList.add(new Course(2, "NEET", "RAM", 1, 15000));
		courseList.add(new Course(3, "CAT", "Clara", 2, 20000));
		courseList.add(new Course(4, "GRE", "Sony", 2, 30000));
		courseList.add(new Course(5, "UPSC", "Sam", 3, 40000));
		courseList.add(new Course(6, "EAMCET", "Sai", 2, 25000));
		courseList.add(new Course(7, "GATE", "Mary", 1, 17000));
		courseList.add(new Course(8, "RRB", "Mani", 1, 25000));
		courseList.add(new Course(9, "XAT", "Latha", 5, 60000));
		courseList.add(new Course(10, "SSC", "Robert", 4, 70000));
		courseList.add(new Course(11, "CLAT", "Karim", 5, 70000));
		courseList.add(new Course(12, "CDS", "Nalini", 3, 30000));
		courseList.add(new Course(13, "LSAT", "Nancy", 6, 80000));
		courseList.add(new Course(14, "NDA", "Krish", 4, 90000));
		courseList.add(new Course(15, "FCI", "Carl", 3, 100000));

//		Collections.sort(courseList, (c1, c2) -> {
//			if (c1.getTotalFee() == c2.getTotalFee()) {
//				return (c1.getDuration() - c2.getDuration());
//			}
//			return (int) (c2.getTotalFee() - c1.getTotalFee());
//		});
		System.out.println(courseList.toString());
		courseList.stream().sorted((c1, c2) -> {
			if (c1.getTotalFee() == c2.getTotalFee()) {
				return (c1.getDuration() - c2.getDuration());
			}
			return (int) (c2.getTotalFee() - c1.getTotalFee());
		}).forEach(System.out::println);

		
	}

}

