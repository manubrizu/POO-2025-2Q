package CLASES.SharedDrive_v2;

import java.util.*;
import java.util.function.Predicate;

public class SharedDrive {
    private Set<SharedFile> files = new HashSet<>();

    private SharedFile build(String fileName, String workArea){
        return new SharedFile(fileName, workArea);
    }

    public SharedDrive addFile(String fileName, String workArea) {
        SharedFile aux = build(fileName, workArea);
        files.add(aux);
        return this;    // retorno el sharedFile
    }

    public int filesCount(Predicate<SharedFile> predicate){
        int count = 0;
        for (SharedFile sF : files){
            if(predicate.test(sF)){
                count++;
            }
        }
        return count;
    }

    public void renameFile(String oldFileName, String workArea, String newFileName) {
        SharedFile oldFile = build(oldFileName, workArea);
        if(files.remove(oldFile)){
            addFile(newFileName, workArea);
            return;
        }
        throw new NoSuchElementException();
    }

    public boolean fileExists(String fileName, String workArea){
        return files.contains(build(fileName, workArea));
    }

    public static class SharedFile{
        private String fileName, workArea;

        public SharedFile(String fileName, String workArea) {
            this.fileName = fileName;
            this.workArea = workArea;
        }

        public String getFileName(){
            return fileName;
        }

        @Override
        public String toString(){
            return "File %s in work area %s".formatted(fileName, workArea);
        }

        @Override
        public boolean equals(Object o){
            return o instanceof SharedFile sF && fileName.equals(sF.fileName) && workArea.equals(sF.workArea);
        }

        @Override
        public int hashCode(){
            return Objects.hash(fileName, workArea);
        }
    }
}
