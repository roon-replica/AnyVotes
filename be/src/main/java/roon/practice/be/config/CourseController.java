package roon.practice.be.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import roon.practice.be.SchoolProto.Course;

@RestController
public class CourseController {
	@Autowired
	CourseRepository courseRepo;

	@GetMapping("/courses/{id}")
	Course customer(@PathVariable Integer id) {
		return courseRepo.getCourse(id);
	}
}