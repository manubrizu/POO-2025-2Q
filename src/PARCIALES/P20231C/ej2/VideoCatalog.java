package PARCIALES.P20231C.ej2;

import java.util.Arrays;

public class VideoCatalog {
    private VideoCatalogElement[] vec;
    private final int BLOCK = 10;
    private int dim;

    VideoCatalog() {
        vec = new VideoCatalogElement[BLOCK];
    }

    public void addElement(VideoCatalogElement vce){
        if(vec.length == dim){
            resize();
        }
    }

    private void resize(){
        vec = Arrays.copyOf(vec, dim + BLOCK);
    }
}
