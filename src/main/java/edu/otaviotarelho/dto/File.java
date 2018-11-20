package edu.otaviotarelho.dto;

import edu.otaviotarelho.enuns.TypeEnum;

import java.io.Serializable;
import java.nio.file.attribute.FileTime;
import java.time.LocalDate;

public class File implements Serializable {

    private int id;
    private String name;
    private TypeEnum type;
    private String pathOrigem;
    private int byteSize;
    private int blockSize;
    private String criationDate;
    private String modifiedDate;
    private boolean activated;

    public File(int id, String name, TypeEnum type, String pathOrigem, int byteSize, int blockSize, String criationDate, String modifiedDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.pathOrigem = pathOrigem;
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

    public String getCriationDate() {
        return criationDate;
    }

    public File setCriationDate(String criationDate) {
        this.criationDate = criationDate;
        return this;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public File setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public boolean isActivated() {
        return activated;
    }

    public File setActivated(boolean activated) {
        this.activated = activated;
        return this;
    }
}
