package CLASES.SharedDrive_v1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SequencedCollection;
import java.util.function.Predicate;

public class SharedDrive {
    private SequencedCollection<SharedFile> files = new ArrayList<>();

    public SharedDrive addFile(String fileName, String workArea) {
        SharedFile aux = new SharedFile(fileName, workArea);
        files.add(aux);
        return this;    // retorno el sharedFile
    }

    public Iterable<SharedFile> getAllFiles(){
        return new ArrayList<>(files);  /// retorno una colleccion nueva en otro espacio de memoria
    }

    public SharedFile getFirstFile(Predicate<SharedFile> predicate){
        for (SharedFile sF : files){
            if(predicate.test(sF)){
                return sF;
            }
        }
        throw new NoSuchElementException();
    }

    public SharedFile getLastFile(){
        return files.getLast(); /// YA TIRA ERROR
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
    }
}
