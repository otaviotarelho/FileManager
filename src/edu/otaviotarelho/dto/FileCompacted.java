package edu.otaviotarelho.dto;

import java.io.Serializable;
import java.util.Map;

public class FileCompacted implements Serializable {

    private FileSuported fileSuported;
    Map<Integer, byte[]> listOfFileBytes;

    public FileSuported getFileSuported() {
        return fileSuported;
    }

    public FileCompacted setFileSuported(FileSuported fileSuported) {
        this.fileSuported = fileSuported;
        return this;
    }

    public Map<Integer, byte[]> getListOfFileBytes() {
        return listOfFileBytes;
    }

    public FileCompacted setListOfFileBytes(Map<Integer, byte[]> listOfFileBytes) {
        this.listOfFileBytes = listOfFileBytes;
        return this;
    }
}
