package lambdaexpression;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Al-Amin Islam <alaminislam3555@gmail.com>
 */
public class LambdaExpression {
    //Inner Class

    class StudentComparatorByIdAsc implements Comparator<Student> {

        @Override
        public int compare(Student t, Student t1) {
            return (int) (t.getStudentId() - t1.getStudentId());
        }

    }

    class StudentComparatorByIdDesc implements Comparator<Student> {

        @Override
        public int compare(Student t, Student t1) {
            return (int) (t1.getStudentId() - t.getStudentId());
        }

    }

    class StudentComparatorByGPAAsc implements Comparator<Student> {

        @Override
        public int compare(Student t, Student t1) {
            return (int) (t.getGpa() * 100 - t1.getGpa() * 100);
        }

    }

    public void studentSorting() {
        System.out.println("Student Sorting");
        StudentService studentService = new StudentService();
        List<Student> array = studentService.getStudentList();
        System.out.println("Before Sorting");
        for (Student std : array) {
            System.out.println(std);
        }
        System.out.println("After Sorting");
        //Arrays.sort(array,new StudentComparatorByIdAsc());
        //Arrays.sort(array, new StudentComparatorByIdDesc());
        // Arrays.sort(array, new StudentComparatorByGPAAsc());
        //Anonymous Inner Class
        Collections.sort(array, new Comparator<Student>() {
            @Override
            public int compare(Student t, Student t1) {
                return (int) (t1.getGpa() * 100 - t.getGpa() * 100);

            }
        });
        //Lambda Expression (Version 1)
        Collections.sort(array, (Student t, Student t1) -> {
            return (int) (t1.getGpa() * 100 - t.getGpa() * 100);

        }
        );
        //Lambda Expression (Version 2)
        Collections.sort(array, (t, t1) -> {
            return (int) (t1.getGpa() * 100 - t.getGpa() * 100);

        }
        );
        //Lambda Expression (Version 3)
        Collections.sort(array, (t, t1) -> (int) (t1.getGpa() * 100 - t.getGpa() * 100)
        );
        //Lambda Expression (Version 4)
        Collections.sort(array, Comparator.comparing(Student::getGpa).reversed());
//        for (Student std : array) {
//            System.out.println(std);
//        }
        //Short Form of for Each
        //array.forEach(System.out::println);
        //Long Form of for Each
//        array
//            .stream().
//             forEach(student->System.out.println(student));

//        array
//           .stream()
//              //  .filter(student->student.getGpa()<=3)
//                .filter(student->student.getName().endsWith("ul"))
//                . forEach(student->System.out.println(student));
        //Filter and Collect Student
//        List<Student> filteredStudent = array
//                .stream()
//                .filter(student -> student.getName().endsWith("ul"))
//                .collect(Collectors.toList());
//        System.out.println("Size of Filtered List : " + filteredStudent.size());
        
        //printing maximum of lower cgpa holders
        array
                .stream()
                .filter(student->student.getGpa()<=3)
                .filter(student -> student.getName().endsWith("ul"))
                .mapToDouble(student->(student.getGpa()))
                .max()
                .ifPresent(maxCgpa->System.out.println("Max CGPA : "+maxCgpa));
    }

    public LambdaExpression() {
        studentSorting();
    }

    public static void main(String[] args) {
        new LambdaExpression();
    }

}
