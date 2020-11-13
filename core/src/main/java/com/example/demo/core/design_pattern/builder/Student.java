package com.example.demo.core.design_pattern.builder;

import org.apache.commons.lang3.StringUtils;

public class Student {

    private int no;

    private String name;

    private int age;

    private short gender;

    private int type;

    private String nickname;

    private Student() {
    }

    public static class BaseBuilder {

        private int no;

        private String name;

        private int age;

        private short gender;

        private int type;

        private String nickname;


        public Student build() throws Exception {
            throw new Exception("need to implement");
        }

        public BaseBuilder setNo(int no) {
            this.no = no;
            return this;
        }
        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setGender(short gender) {
            this.gender = gender;
        }

        public void setType(int type) {
            this.type = type;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }
    }

    public static class StuBuilder extends BaseBuilder {

        public static StuBuilder builder() {
            return new StuBuilder();
        }

        public Student build() {
            if (StringUtils.isBlank(super.name)) {
                throw new IllegalArgumentException("name required NOT BLANK");
            }

            if (super.no > 10) {
                super.nickname = "jerry";
            }

            Student student = new Student();
            student.no = super.no;

            return student;
        }
    }

    public static class TeacherBuilder extends BaseBuilder {

        public Student build() {
            if (StringUtils.isBlank(super.name)) {
                throw new IllegalArgumentException("name required NOT BLANK");
            }

            if (super.no > 10) {
                super.nickname = "jerry";
            }

            Student student = new Student();
            student.no = super.no;

            return student;
        }
    }

}

class StuTest {
    public static void main(String[] args) throws Exception {
        Student student = Student.StuBuilder.builder()
                .setNo(1)
                .build();
    }
}
