package PARCIALES.repaso.ej1;

public class UniqueExam extends Exam {

    UniqueExam(String examName){
        super(examName);
    }

    @Override
    public void enroll(String student) {
        if (!isEnrolled(student)) {
            super.enroll(student);
        }
    }
}
