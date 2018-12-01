package edu.otaviotarelho.enuns;

import java.io.Serializable;

public enum TypeEnum implements Serializable {
    TEXTO(1),
    WORLD(2),
    EXCEL(3),
    EXECUTAVEL(4),
    OUTROS(5);

    private int codigo;

    TypeEnum(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getExtension() {
        switch (codigo) {
            case 1:
                return ".txt";
            case 2:
                return ".docx";
            case 3:
                return ".xls";
            case 4:
                return ".exe";
        }

        return ".txt";
    }

    public static TypeEnum getExtensionFromFile(String extension) {
        switch (extension) {
            case "txt":
                return TypeEnum.TEXTO;
            case "docx":
            case "doc":
                return TypeEnum.WORLD;
            case "xls":
            case "xlsx":
                return TypeEnum.EXCEL;
            case "exe":
                return TypeEnum.EXECUTAVEL;
        }

        return TypeEnum.OUTROS;
    }
}
