package hash.demo;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-05-21
 * Time:20:42
 * 一万年太久，只争朝夕，加油
 */

public class TestLambda {
    static class Student{
        public String name;
        public int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }
    public static void main(String[] args) {
        Student[] students={
                new Student("张三",16),
                new Student("李四",15),
                new Student("王五",99),
        };
//        Arrays.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.score-o2.score;
//            }
//        });
        Arrays.sort(students,(Student o1,Student o2)->{
                return o1.score-o2.score;
        });
        System.out.println(Arrays.toString(students));
    }
}
