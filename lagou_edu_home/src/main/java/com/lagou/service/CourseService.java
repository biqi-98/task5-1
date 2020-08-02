package com.lagou.service;

import com.lagou.pojo.Course;
import com.lagou.pojo.Course_Lesson;

import java.util.List;
import java.util.Map;

/**
 * 课程管理模块 Service层 接口
 * */
public interface CourseService {

    public List<Course> findCourseList();

    public List<Course> findByCourseNameAndStatus(String courseName, String status);

    public String saveCourseSalesInfo(Course course);

    public Course findCourseById(int id);

    public String updateCourseSalesInfo(Course course);

    public Map<String,Integer> updateCourseStatus(Course course);

    //修改课时信息
    public String saveCourseLessonInfo(Course_Lesson courseLesson);

    //根据ID查询课时信息
    public Course_Lesson findCourseLessonById(int id);

    //修改课时信息
    public String updateCourseLessonInfo(Course_Lesson courseLesson);

}
