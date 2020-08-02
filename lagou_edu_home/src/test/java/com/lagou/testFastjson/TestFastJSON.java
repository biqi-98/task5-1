package com.lagou.testFastjson;

import com.alibaba.fastjson.JSON;
import com.lagou.utils.DateUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestFastJSON {

    //Java对象转JSON
    @Test
    public void javaBeanToJSON(){

        //创建Person对象
        Person p = new Person("码云",15, DateUtils.getDateFormart());

        //使用JSON对象的 toString方法将对象转换为JOSN数据
        String s = JSON.toJSONString(p);

        System.out.println(s); //{"age":15,"birthday":"2020-07-03 19:54:33","username":"码云"}
    }


    //List集合转Json
    @Test
    public void ListToJSON(){

        //创建Person对象
        Person p1 = new Person("码云",15, DateUtils.getDateFormart());
        Person p2 = new Person("虎子",13, DateUtils.getDateFormart());
        Person p3 = new Person("小斌",18, DateUtils.getDateFormart());

        List<Person> list = new ArrayList<>();

        Collections.addAll(list,p1,p2,p3);

        //使用JSON对象的 toString方法将对象转换为JOSN数据
        String s = JSON.toJSONString(list);

        System.out.println(s);
        //[{"age":15,"birthday":"2020-07-03 19:59:05","username":"码云"},{"age":13,"birthday":"2020-07-03 19:59:05","username":"虎子"},{"age":18,"birthday":"2020-07-03 19:59:05","username":"小斌"}]
    }

    //JSON转Java对象
    @Test
    public void JSONToJavaBean(){

        String json = "{\"age\":15,\"birthday\":\"2020-07-03 19:54:33\",\"username\":\"码云\"}";
        Person person = JSON.parseObject(json, Person.class);
        System.out.println(person);

        //创建Person对象
        String json2 ="[{\"age\":15,\"birthday\":\"2020-07-03 19:59:05\",\"username\":\"码云\"},{\"age\":13,\"birthday\":\"2020-07-03 19:59:05\",\"username\":\"虎子\"},{\"age\":18,\"birthday\":\"2020-07-03 19:59:05\",\"username\":\"小斌\"}]";
        List<Person> list  = JSON.parseArray(json2,Person.class);
        System.out.println(list);

    }
}
