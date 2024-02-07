package roon.practice.be.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import roon.practice.be.SchoolProto.Course;
import roon.practice.be.SchoolProto.Student;

@Configuration
public class ProtoConfig {
	@Bean
	ProtobufHttpMessageConverter protobufHttpMessageConverter() {
		return new ProtobufHttpMessageConverter();
	}

	@Bean
	public CourseRepository createTestCourses() {
		Map<Integer, Course> courses = new HashMap<>();
		Course course1 = Course.newBuilder()
				.setId(1)
				.setCourseName("REST with Spring")
				.addAllStudent(List.of(Student.newBuilder().setId(123).build()))
				.build();
		Course course2 = Course.newBuilder()
				.setId(2)
				.setCourseName("Learn Spring Security")
				.addAllStudent(new ArrayList<Student>())
				.build();
		courses.put(course1.getId(), course1);
		courses.put(course2.getId(), course2);
		return new CourseRepository(courses);
	}

}
