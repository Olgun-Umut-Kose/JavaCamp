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

        userManager.commonOperationOne(user1);
        userManager.commonOperationTwo(user2);
        userManager.commonOperationThree(user3);
        System.out.println("*********************************************************************************");
        instructorManager.commonOperationOne(instructor);
        instructorManager.commonOperationTwo(instructor);
        instructorManager.commonOperationThree(instructor);
        instructorManager.commonOperationOne(student);// şimdi ne demek istediğimi anlamışsınızdır
        instructorManager.commonOperationTwo(student);
        instructorManager.commonOperationThree(student);
        instructorManager.commonOperationOne(user1);
        instructorManager.commonOperationTwo(user2);
        instructorManager.commonOperationThree(user3);
        instructorManager.specificOperation(instructor);
        System.out.println("**********************************************************************");
        studentManager.commonOperationOne(student);
        studentManager.commonOperationTwo(student);
        studentManager.commonOperationThree(student);
        studentManager.commonOperationOne(instructor);// şimdi ne demek istediğimi anlamışsınızdır
        studentManager.commonOperationTwo(instructor);
        studentManager.commonOperationThree(instructor);
        studentManager.commonOperationOne(user1);
        studentManager.commonOperationTwo(user2);
        studentManager.commonOperationThree(user3);
        studentManager.specificOperation(student);


    }
}
