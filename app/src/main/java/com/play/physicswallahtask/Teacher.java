package com.play.physicswallahtask;

public class Teacher {

    String name, subject, qualification, profilePic;

    public Teacher(String name, String subject, String qualification, String profilePic) {
        this.name = name;
        this.subject = subject;
        this.qualification = qualification;
        this.profilePic = profilePic;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public String getQualification() {
        return qualification;
    }

    public String getProfilePic() {
        return profilePic;
    }
}
