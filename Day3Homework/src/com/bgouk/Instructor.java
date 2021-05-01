package com.bgouk;


public class Instructor extends User {



    private int instructorNo;

    public Instructor(User user, int instructorNo){
        super(user.getId(),user.getFirtName(),user.getLastName(),user.geteMail(),user.getPass());
        this.instructorNo = instructorNo;
    }

    public Instructor() {

    }

    public Instructor(int id, String firtName, String lastName, String eMail, String pass, int instructorNo) {
        super(id, firtName, lastName, eMail, pass);
        this.instructorNo = instructorNo;
    }


    public int getInstructorNo() {
        return instructorNo;
    }

    public void setInstructorNo(int instructorNo) {
        this.instructorNo = instructorNo;
    }
}
