package TALLER.taller4;

public class PhoneNumber implements Comparable<PhoneNumber>{
    private int areaCode, prefix, lineNumber;

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNumber = lineNumber;
    }

    @Override
    public int compareTo(PhoneNumber phoneNumber){
        int cmp = this.areaCode - phoneNumber.areaCode;
        if(cmp == 0){
            cmp = prefix - phoneNumber.prefix;
            if(cmp == 0){
                cmp = this.lineNumber - phoneNumber.lineNumber;
            }
        }
        return cmp;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public int getPrefix() {
        return prefix;
    }

    public int getLineNumber() {
        return lineNumber;
    }
}
