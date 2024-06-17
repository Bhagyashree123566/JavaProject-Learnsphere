package com.learnSphere.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnSphere.entities.Course;
//responsible for defining methods to perform crud operation
public interface CourseRepository extends JpaRepository<Course, Integer>{
	Course findByCourseId(int courseId);
}
