package roon.practice.be.config;

import java.util.Map;
import roon.practice.be.SchoolProto.Course;

public class CourseRepository {
	Map<Integer, Course> courses;

	public CourseRepository (Map<Integer, Course> courses) {
		this.courses = courses;
	}

	public Course getCourse(int id) {
		return courses.get(id);
	}
}