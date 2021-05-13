package com.example.externalpractical;

public class Student {

    private String sId;
    private String sEmail;
    private String sName;
    private String sBook;
    private String sPass;

    public Student(String sId, String sName, String sEmail, String sPass, String sBook) {
        this.sId = sId;
        this.sEmail = sEmail;
        this.sName = sName;
        this.sBook = sBook;
        this.sPass = sPass;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsBook() {
        return sBook;
    }

    public void setsBook(String sBook) {
        this.sBook = sBook;
    }

    public String getsPass() {
        return sPass;
    }

    public void setsPass(String sPass) {
        this.sPass = sPass;
    }
}
