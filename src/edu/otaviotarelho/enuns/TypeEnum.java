package edu.otaviotarelho.enuns;

public enum TypeEnum {
    TEXTO(1),
    WORLD(2),
    EXCEL(3),
    EXECUTAVEL(4);

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
}
