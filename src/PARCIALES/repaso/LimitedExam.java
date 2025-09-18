package PARCIALES.repaso;

import java.util.Arrays;

public class LimitedExam extends UniqueExam {
    private String[] waitingList;
    private int BLOCK = 10;
    private int waitDim;
    private int limit;

    LimitedExam(String examName, int limit){
        super(examName);
        this.waitingList = new String[BLOCK];
        this.limit = limit;
    }

    @Override
    public void enroll(String student) {
        if(super.getEnrolledCount() < limit){
             super.enroll(student);
        }
        else{
            if(waitingList.length == waitDim){
                resize();
            }
            waitingList[waitDim++] = student;
        }
    }

    @Override
    public void unenroll(String student) {
        if(removeFromPending(student)){
            return;
        }
        int previousDim = super.getEnrolledCount();
        super.unenroll(student);
        if(waitDim != 0 && getEnrolledCount() < previousDim){
            super.enroll(waitingList[0]);
            removeFromPending(waitingList[0]);
        }
    }

    private void resize(){
        waitingList = Arrays.copyOf(waitingList, waitingList.length + BLOCK);
    }

    public String[] getPendingStudents() {
        return Arrays.copyOf(waitingList, waitDim);
    }

    private boolean removeFromPending(String student) {
        for (int i = 0; i < waitDim; i++) {
            if (waitingList[i].equals(student)) {
                System.arraycopy(waitingList, i + 1, waitingList, i, waitDim - 1 - i);
                waitDim--;
                return true;
            }
        }
        return false;
    }
}
