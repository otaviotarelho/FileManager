package edu.otaviotarelho.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

public class FileSuported implements Serializable {

    private long version;
    private LocalDate creationDate;
    private LocalDate modifiedDate;
    private int quantidadeArquivos;
    List<File> listOfFilesHeaders;

    public long getVersion() {
        return version;
    }

    public FileSuported setVersion(long version) {
        this.version = version;
        return this;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public FileSuported setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public FileSuported setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public int getQuantidadeArquivos() {
        return quantidadeArquivos;
    }

    public FileSuported setQuantidadeArquivos(int quantidadeArquivos) {
        this.quantidadeArquivos = quantidadeArquivos;
        return this;
    }

    public List<File> getListOfFilesHeaders() {
        return listOfFilesHeaders;
    }

    public FileSuported setListOfFilesHeaders(List<File> listOfFilesHeaders) {
        this.listOfFilesHeaders = listOfFilesHeaders;
        return this;
    }

    public int getSizeOfActivatedFiles(){
        int i = 0;
        Iterator<File> files = listOfFilesHeaders.iterator();

        while (files.hasNext()){
            File file = files.next();
            if(file.isActivated()){
                i++;
            }
        }

        return i;
    }
}
