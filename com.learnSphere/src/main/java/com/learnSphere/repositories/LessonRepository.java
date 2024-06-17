package com.learnSphere.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnSphere.entities.Lesson;
//responsible for defining methods to perform crud operation
public interface LessonRepository 
			extends JpaRepository<Lesson, Integer>{
		
	//modification
	Lesson findByLessonId(int lessonId);
}
