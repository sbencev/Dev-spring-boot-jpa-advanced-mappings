package com.udemy.cruddemo;

import com.udemy.cruddemo.dao.AppDAO;
import com.udemy.cruddemo.entity.Course;
import com.udemy.cruddemo.entity.Instructor;
import com.udemy.cruddemo.entity.InstructorDetail;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {

        return runner -> {

            deleteCourse(appDAO);

            //deleteInstructor(appDAO);

            //updateCourse(appDAO);

            //updateInstructor(appDAO);

            //findInstructorWithCoursesJoinFetch(appDAO);

            //findCoursesForInstructor(appDAO);

            //findInstructorWithCourses(appDAO);

            //createInstructorWithCourses(appDAO);

            //deleteInstructorDetailById(appDAO);

            //findInstructorDetail(appDAO);

            //deleteInstructor(appDAO);

            //findInstructor(appDAO);

            //createInstructor(appDAO);

        };

    }

    private void deleteCourse(AppDAO appDAO) {

        int theId = 10;

        System.out.println("deleting course id: " + theId);

        appDAO.deleteCourseById(theId);

        System.out.println("Done!");

    }

    private void updateCourse(AppDAO appDAO) {

        int theId = 10;

        System.out.println("Finding course id: " + theId);
        Course tempCourse = appDAO.findCourseById(theId);

        System.out.println("Updating course id: " + theId);
        tempCourse.setTitle("Updated course");

        appDAO.update(tempCourse);

        System.out.println("Done!");

    }

    private void updateInstructor(AppDAO appDAO) {

        int theId = 1;

        System.out.println("Finding instructor id: " + theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("Updating instructor id: " + theId);

        tempInstructor.setLastName("TESTER");

        appDAO.update(tempInstructor);

        System.out.println("Done!");

    }

    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

        int theId = 1;

        System.out.println("Finding instructor id: " + theId);
        Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

        System.out.println("tempInstructor: " + tempInstructor);

        System.out.println("the associated courses: " + tempInstructor.getCourses());

        System.out.println("Done!");

    }

    private void findCoursesForInstructor(AppDAO appDAO) {

        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("tempInstructor: " + tempInstructor);

        System.out.println("Finding courses for instructor id: " + theId);
        List<Course> courses = appDAO.findCoursesByInstructorId(theId);

        tempInstructor.setCourses(courses);

        System.out.println("the associated courses " + tempInstructor.getCourses());

        System.out.println("Done!");

    }

    private void findInstructorWithCourses(AppDAO appDAO) {

        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associated courses: " + tempInstructor.getCourses());

        System.out.println("Done!");

    }

    private void createInstructorWithCourses(AppDAO appDAO) {

        Instructor tempInstructor = new Instructor("Susan", "Patel", "s.patel@gmail.com");

        InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "Video Games");

        tempInstructor.setInstructorDetail(tempInstructorDetail);

        Course tempCourse1 = new Course("Java Course");
        Course tempCourse2 = new Course("Spring Course");

        tempInstructor.add(tempCourse1);
        tempInstructor.add(tempCourse2);

        System.out.println("Saving instructor: " + tempInstructor);
        System.out.println("The courses: " + tempInstructor.getCourses());
        appDAO.save(tempInstructor);

        System.out.println("Done!");

    }

    private void deleteInstructorDetailById(AppDAO appDAO) {

        int theId = 3;

        System.out.println("Deleting instructor detail id: " + theId);

        appDAO.deleteInstructorDetailById(theId);

        System.out.println("Done!");

    }

    private void findInstructorDetail(AppDAO appDAO) {

        int theId = 1;
        System.out.println("Finding instructorDetail id: " + theId);

        InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

        System.out.println("tempInstructorDetail: " + tempInstructorDetail);

        System.out.println("the associate instructorDetail only: " + tempInstructorDetail.getInstructor());

        System.out.println("Done!");

    }

    private void deleteInstructor(AppDAO appDAO) {

        int theId = 1;
        System.out.println("Deleting instructor by id: " + theId);

        appDAO.deleteInstructorById(theId);

        System.out.println("Done!");

    }

    private void findInstructor(AppDAO appDAO) {

        int theId = 2;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associate instructorDetail only: " + tempInstructor.getInstructorDetail());

    }

    private void createInstructor(AppDAO appDAO) {

        /*
        Instructor tempInstructor = new Instructor("Bence", "Sulyok", "sulyokbence@gmail.com");

        InstructorDetail tempInstructorDetail = new InstructorDetail("http://youtube.com", "fishing");

         */

        Instructor tempInstructor = new Instructor("Madhu", "Patel", "mpatel@gmail.com");

        InstructorDetail tempInstructorDetail = new InstructorDetail("http://youtube.com", "Guitar");

        tempInstructor.setInstructorDetail(tempInstructorDetail);

        System.out.println("Saving instructor: " + tempInstructor);
        appDAO.save(tempInstructor);

        System.out.println("Done!");

    }

}
