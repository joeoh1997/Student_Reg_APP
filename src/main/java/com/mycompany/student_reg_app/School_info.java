
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.student_reg_app;
import com.mycompany.student_registration_system.Course;
import com.mycompany.student_registration_system.Module;
import com.mycompany.student_registration_system.Student;
import java.util.ArrayList;
/**
 *
 * @author Joe
 */
public class School_info {
    public static void main(String args[]){
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Module> modules = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();
        
        // ECE
        students.add(new Student("John", "14/05/1995", "14352788", 23));
        students.add(new Student("Bill", "15/06/1996", "14352788", 22));
        students.add(new Student("Jim", "1/09/1995", "14352788", 23));
        // Computer Science
        students.add(new Student("Harry", "24/02/1996", "14352788", 22));
        students.add(new Student("Sam", "21/08/1994", "14352788", 24));
        students.add(new Student("Edward", "06/07/1995", "14352788", 23));
        
        // Just an ECE Module
        modules.add(new Module("Signals and Systems", "EC333"));
        // Computer Science and ECE module
        modules.add(new Module("Fun Electronics", "EC111"));
        modules.add(new Module("Programming", "CT222"));  
        // Just Computer Science module
        modules.add(new Module("Databases", "CT323"));
        
        courses.add(new Course("Electronic Engineering" , 2018, 9, 3, 2019, 4,
                26));
        courses.add(new Course("Computer Science" , 2018, 9, 3, 2019, 4,
                26));
        
        // adding students and courses to modules 
        int i, j, k = 0;
        for( i=0; i<modules.size(); i++){
            if (i == 0){
                // just add ECE students to EC333
                 for ( j=0; j<3; j++){
                     modules.get(i).addStudent(students.get(j));
                 }
                 // just add ECE as the course for this module
                 modules.get(i).addCourse(courses.get(0));
            }
            else if (i>0 && i<3){
                // add all students to EC11 and CT222
                for ( j=0; j<students.size(); j++){
                    modules.get(i).addStudent(students.get(j));
                }
                // add ECE and CS as the courses for this module
                 modules.get(i).addCourse(courses.get(0));
                 modules.get(i).addCourse(courses.get(1));
            }
            else{
                // add only computer science studnets to CT323
                for ( j=3; j<students.size(); j++){
                    modules.get(i).addStudent(students.get(j));
                }
                // add just CS as the course for this module
                modules.get(i).addCourse(courses.get(1));
            }
        }
        
        
        int p, t;
        // adding students and modules to courses 
        // first 3 modules are in ECE and first 3 students are in ECE
        for(p=0; p<3; p++){
            courses.get(0).addModule(modules.get(p));
            courses.get(0).addStudent(students.get(p));
        }
        // last three modules are in CS and last 3 students are in CS
        for(t=1; t<4; t++){
            courses.get(1).addModule(modules.get(t));
            courses.get(1).addStudent(students.get(t));
        }
        
        
        
        int n;
        // adding modules and course to students
        for( n=0; n<6; n++) {
            int m = 0;
            // first three students are ECE
            if(n < 3){
                students.get(n).addCourse(courses.get(0));
                // add the 3 ECE modules to this student
                for(m=0; m<3; m++){
                    students.get(n).addModule(modules.get(m));
                }
            // last 3 are CS
            }else{
                 students.get(n).addCourse(courses.get(1));
                // add the last 3 CS modules to this student
                for(m=1; m<4; m++){
                    students.get(n).addModule(modules.get(m));
                }   
            }
        }
        
        
        
        
        int y,h;
        // looping over the 2 modules
        for(y=0; y<2; y++){
            Course course = courses.get(y);
            //ArrayList<Modules> this_courses_modules = course.getModules();
            int num_modules = course.getModules().size();
            System.out.printf("Course : %s ::\n\t Modules of this Course:\n", course.getName());
            for(h=0; h<num_modules; h++){
                System.out.printf("\t %s \n", course.getModules().get(h).getName());
            }
             System.out.println("\n");

        }
        
        for(i=0; i<6; i++){
            Student student = students.get(i);
            System.out.printf("Student %d: %s::\n\t Modules:\n", i, student.getName());
            int num_modules = student.getModules().size();
            for(h=0; h<num_modules; h++){
                System.out.printf("\t %s \n", student.getModules().get(h).getName());
            } 
            System.out.printf("\tCourse: \n\t%s\n", student.getCourses().get(0).getName());
            System.out.println("\n");        
        }
        
        
        
        
        
        
    }
    
    
    
    
    
    
}


