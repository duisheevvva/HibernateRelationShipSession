package peaksoft.service.serviceImpl;

import peaksoft.dao.CourseDao;
import peaksoft.dao.daoImpl.CourseDaoImpl;
import peaksoft.service.CourseService;

public class CourseServiceImpl implements CourseService {
    CourseDao courseDao = new CourseDaoImpl();
    @Override
    public int countStudentsFromCourse(Long courseId) {
        return courseDao.countStudentsFromCourse(courseId);
    }
}
