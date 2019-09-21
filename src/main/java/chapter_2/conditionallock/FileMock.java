package chapter_2.conditionallock;

import org.apache.commons.lang3.RandomStringUtils;

public class FileMock {

    private final int size;
    private String[] content;
    private int index;

    public FileMock(int size){
        this.size = size;
        content = new String[size];
        for (int i = 0; i < size; i++) {
            content[i] = "line" + i + ";";
        }
        index = 0;
    }

    public boolean hasNext() {
        return index < size-1;
    }

    public String getLine() {
        return hasNext() ? content[index++] : null;
    }

}
