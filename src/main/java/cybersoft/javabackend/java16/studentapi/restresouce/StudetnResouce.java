package cybersoft.javabackend.java16.studentapi.restresouce;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.java16.model.Student;

@RestController
@RequestMapping("/students")
public class StudetnResouce {
	
	List<Student> students = new ArrayList<Student>();

	@RequestMapping(value = "student", method = RequestMethod.GET)
	@ResponseBody
	public Object indexRequest(@RequestParam String name, @RequestParam int age) {
		Student student = new Student(name, age);
		students.add(student);
		return students;
	}
	
	@RequestMapping(value = "student/{name}/{age}", method = RequestMethod.GET)
	@ResponseBody
	public Object indexPath(@PathVariable("name") String name, @PathVariable("age") int age) {
		Student student = new Student(name, age);
		students.add(student);
		return students;
	}
		
	@GetMapping
	public Object getStudent() {
		return new ResponseEntity<>(students,HttpStatus.OK);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Object saveStudent(@RequestBody Student student) {
		Student entity = new Student();
		entity.setName(student.getName());
		entity.setAge(student.getAge());
		students.add(entity);
		return students;
	}
	
}
