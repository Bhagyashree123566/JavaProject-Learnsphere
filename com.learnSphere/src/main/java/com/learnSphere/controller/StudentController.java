package com.learnSphere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnSphere.entities.Course;
import com.learnSphere.entities.Lesson;
import com.learnSphere.entities.Users;
import com.learnSphere.services.StudentService;
import com.learnSphere.services.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {
	@Autowired
	StudentService sservice;
	
	//modification
	@Autowired
	UsersService uservice;
	
	@GetMapping("/purchase")
	public String purchase(Model model) {
		//fetch course list
		List<Course> courseList=sservice.fetchCourseList();
		//add course list to model object
		model.addAttribute("courseList", courseList);
		return "purchaseCourse";
	}
	
	
	//modification
	@GetMapping("/myCourses")
	public String myCourses(Model model, HttpSession session) {
		
		Users loggedUser=(Users) session.getAttribute("loggedInUser");
		
		String email=loggedUser.getEmail();
		// retrieve the user object based on email address		
		Users user=uservice.findUserByEmail(email);
			
		List<Course> courseList=user.getCourseList();
		model.addAttribute("courseList",courseList);
		return "myCourses";
	}
	
	@GetMapping("/viewLesson")
	public String viewLesson(@RequestParam("lessonId")int lessonId,
							Model model,HttpSession session) {
	
		
		
		Lesson lesson = sservice.getLesson(lessonId);
		//Retrieves the YouTube URL from the lesson object.
	    String youtubeUrl = lesson.getLessonLink();
	    // Extracts the video ID from the YouTube URL. This assumes the URL is in the format.
	    //Sets the lesson link to the extracted video ID.
	    String videoId = youtubeUrl.substring(youtubeUrl.indexOf("=") + 1);
	    lesson.setLessonLink(videoId);
		
		
		model.addAttribute("lesson",lesson);
		
		
		return "myLesson";
	}
}
