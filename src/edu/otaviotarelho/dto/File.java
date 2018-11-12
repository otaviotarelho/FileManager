package edu.otaviotarelho.dto;

import edu.otaviotarelho.enuns.TypeEnum;

import java.time.LocalDate;

public class File {

    private int id;
    private String name;
    private TypeEnum type;
    private String pathOrigem;
    private int start;
    private int byteSize;
    private int blockSize;
    private LocalDate criationDate;
    private LocalDate modifiedDate;

    public File(int id, String name, TypeEnum type, String pathOrigem, int start, int byteSize, int blockSize, LocalDate criationDate, LocalDate modifiedDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.pathOrigem = pathOrigem;
        this.start = start;
        this.byteSize = byteSize;
        this.blockSize = blockSize;
        this.criationDate = criationDate;
        this.modifiedDate = modifiedDate;
    }

    public int getId() {
        return id;
    }

    public File setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public File setName(String name) {
        this.name = name;
        return this;
    }

    public TypeEnum getType() {
        return type;
    }

    public File setType(TypeEnum type) {
        this.type = type;
        return this;
    }

    public String getPathOrigem() {
        return pathOrigem;
    }

    public File setPathOrigem(String pathOrigem) {
        this.pathOrigem = pathOrigem;
        return this;
    }

    public int getStart() {
        return start;
    }

    public File setStart(int start) {
        this.start = start;
        return this;
    }

    public int getByteSize() {
        return byteSize;
    }

    public File setByteSize(int byteSize) {
        this.byteSize = byteSize;
        return this;
    }

    public int getBlockSize() {
        return blockSize;
    }

    public File setBlockSize(int blockSize) {
        this.blockSize = blockSize;
        return this;
    }

    public LocalDate getCriationDate() {
        return criationDate;
    }

    public File setCriationDate(LocalDate criationDate) {
        this.criationDate = criationDate;
        return this;
    }

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public File setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }
}
