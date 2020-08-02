package com.lagou.web.servlet;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.lagou.base.BaseServlet;
import com.lagou.pojo.Course;
import com.lagou.pojo.Course_Lesson;
import com.lagou.service.CourseService;
import com.lagou.service.impl.CourseServiceImpl;
import com.lagou.utils.DateUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/courseContent")
public class CourseLessonServlet extends BaseServlet {


    //根据课程id 查询课程信息
    public void findCourseLessonById(HttpServletRequest request, HttpServletResponse response) {

        try {
            //1.接收参数
            String id = request.getParameter("id");

            //2.业务处理
            CourseService cs = new CourseServiceImpl();
            Course_Lesson courseLesson = cs.findCourseLessonById(Integer.parseInt(id));

            //3.返回结果
            SimplePropertyPreFilter filter = new SimplePropertyPreFilter(Course.class, "id", "course_id", "section_id", "theme", "duration", "is_free", "orderNum");

            String result = JSON.toJSONString(courseLesson, filter);
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(result);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //修改课程状态
    public void saveOrUpdateCourseLesson(HttpServletRequest request, HttpServletResponse response) {

        try {
            //1.获取参数
            String id = request.getParameter("id");

            //2.业务处理
            CourseService cs = new CourseServiceImpl();

            //3.获取参数赋值
            Course_Lesson courseLesson = new Course_Lesson();
            courseLesson.setCourse_id(Integer.parseInt(request.getParameter("course_id")));
            courseLesson.setSection_id(Integer.parseInt(request.getParameter("section_id")));
            courseLesson.setTheme(request.getParameter("theme"));
            courseLesson.setDuration(Integer.parseInt(request.getParameter("duration")));
            courseLesson.setIs_free(Integer.parseInt(request.getParameter("is_free")));
            courseLesson.setOrderNum(Integer.parseInt(request.getParameter("orderNum")));

            //4.设置更新时间
            courseLesson.setCreate_time(DateUtils.getDateFormart());
            courseLesson.setUpdate_time(DateUtils.getDateFormart());

            //5.响应结果(判断调用参数)
            String result = "";
            if (id == null) {
                result = cs.saveCourseLessonInfo(courseLesson);
            } else {
                courseLesson.setId(Integer.parseInt(id));
                result = cs.updateCourseLessonInfo(courseLesson);
            }
            response.getWriter().print(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
