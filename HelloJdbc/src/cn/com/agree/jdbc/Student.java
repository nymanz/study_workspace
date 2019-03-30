package cn.com.agree.jdbc;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;

/**
 * @author 赵乾泽
 * @version 1.0
 */

public class Student {
    private Integer age;
    private String name;
    private String sex;
    private Integer sid;

    public Student(){

    }
    public Student(Integer age, String name, String sex, Integer sid) {
        this.age = age;
        this.name = name;
        this.sex = sex;
        this.sid = sid;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
}
