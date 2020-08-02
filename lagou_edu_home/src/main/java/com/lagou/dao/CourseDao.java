package com.lagou.dao;

import com.lagou.pojo.Course;
import com.lagou.pojo.Course_Lesson;

import java.util.List;

/**
 * 课程模块 DAO层接口
 * */
public interface CourseDao {

    //查询课程列表信息
    public List<Course> findCourseList();

    //根据条件查询课程信息
    public List<Course> findByCourseNameAndStatus(String courseName, String status);

    //保存课程营销信息
    public int saveCourseSalesInfo(Course course);

    //根据ID查询课程信息
    public Course findCourseById(int id);

    //修改课程营销信息
    public int updateCourseSalesInfo(Course course);

    //修改课程状态
    int updateCourseStatus(Course course);

    //修改课时信息
    public int saveCourseLessonInfo(Course_Lesson courseLesson);

    //根据ID查询课时信息
    public Course_Lesson findCourseLessonById(int id);

    //修改课时信息
    public int updateCourseLessonInfo(Course_Lesson courseLesson);

}
