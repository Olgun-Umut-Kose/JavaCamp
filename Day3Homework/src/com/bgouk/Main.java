package com.bgouk;

public class Main {

    public static void main(String[] args) {

        User user1 = new User(1,"instructor","user1lastname","email1","ughhfgufggh0");
        User user2 = new User(2,"student","user2lastname","email2","ughhdjgetyuyhdf");
        User user3 = new User(3,"user3","user3lastname","email3","ughgfhjfghfd");


        Instructor instructor = new Instructor(user1,1);


        Student student = new Student(user2,1);

        UserManager userManager = new UserManager();

        InstructorManager instructorManager = new InstructorManager();

        StudentManager studentManager = new StudentManager();

        userManager.signIn(user1);
        userManager.signOut(user2);
        userManager.signUp(user3);
        System.out.println("*********************************************************************************");
        instructorManager.signIn(instructor);
        instructorManager.signOut(instructor);
        instructorManager.signUp(instructor);
        instructorManager.signIn(student);// şimdi ne demek istediğimi anlamışsınızdır
        instructorManager.signUp(student);
        instructorManager.signOut(student);
        instructorManager.signIn(user1);
        instructorManager.signUp(user2);
        instructorManager.signOut(user3);
        instructorManager.addCourse(instructor);
        System.out.println("**********************************************************************");
        studentManager.signIn(student);
        studentManager.signOut(student);
        studentManager.signUp(student);
        studentManager.signIn(instructor);// şimdi ne demek istediğimi anlamışsınızdır
        studentManager.signUp(instructor);
        studentManager.signOut(instructor);
        studentManager.signIn(user1);
        studentManager.signUp(user2);
        studentManager.signOut(user3);
        studentManager.registerCourse(student);


    }
}
