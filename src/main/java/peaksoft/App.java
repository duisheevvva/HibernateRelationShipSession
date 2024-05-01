package peaksoft;

import peaksoft.config.HibernateConfig;
import peaksoft.service.CourseService;
import peaksoft.service.serviceImpl.CourseServiceImpl;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        System.out.println(HibernateConfig.getEntityManagerFactory());
        CourseService courseService = new CourseServiceImpl();
        System.out.println("Count of students: " );
        System.out.println(courseService.countStudentsFromCourse(1L));
    }
}
