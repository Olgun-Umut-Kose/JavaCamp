package com.bgouk;

public class Student extends User{


    private int studentNo;

    public Student(User user, int studentNo){
        super(user.getId(),user.getFirtName(),user.getLastName(),user.geteMail(),user.getPass());
        this.studentNo = studentNo;
    }

    public Student() {
    }

    public Student(int id, String firtName, String lastName, String eMail, String pass, int studentNo) {
        super(id, firtName, lastName, eMail, pass);
        this.studentNo = studentNo;
    }

    public int getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }

}
