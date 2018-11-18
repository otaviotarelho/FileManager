package edu.otaviotarelho.manager;

import edu.otaviotarelho.dto.File;
import edu.otaviotarelho.dto.FileCompacted;
import edu.otaviotarelho.dto.FileSuported;
import edu.otaviotarelho.enuns.TypeEnum;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import static java.nio.file.Files.readAllBytes;
import static java.util.Objects.requireNonNull;

public class Management {

    FileCompacted fileCompacted;

    public Management(){

    }

    public void addFile(Path path) throws IOException {
        if(fileCompacted == null){
            fileCompacted = new FileCompacted();
            fileCompacted.setFileSuported( new FileSuported());
            fileCompacted.setListOfFileBytes(new HashMap<>());
        }

        requireNonNull(fileCompacted);

        FileInputStream file = new FileInputStream(path.toString());

        BasicFileAttributes metaData = Files.readAttributes(path, BasicFileAttributes.class);

        int id = getBestId();

        TypeEnum type = getType();

        File fileCreated = new File(id, path.getFileName().toString(), type, path.toAbsolutePath().toString(),
                            0, 0,  metaData.creationTime(), metaData.lastModifiedTime());
        fileCreated.setActivated(true);
    }

    private int getBestId() {
        return 1;
    }

    private TypeEnum getType(){
        return null;
    }

    public void listFiles() {
        if(fileCompacted != null) {
            if(fileCompacted.getFileSuported().getListOfFilesHeaders().isEmpty()){
                System.out.print("No Files to be shown");
            }
            else {
                System.out.print(fileCompacted.getFileSuported().getListOfFilesHeaders().size() + "Files to be shown");
            }
        }
    }

    public void readFile(Path path){
        try (ByteArrayInputStream bis = new ByteArrayInputStream(readAllBytes(path));
             ObjectInputStream ois = new ObjectInputStream(bis);
        ){
            fileCompacted = (FileCompacted) ois.readObject();

            requireNonNull(fileCompacted);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void removeFiles(int idFile){
        requireNonNull(fileCompacted.getFileSuported().getListOfFilesHeaders());

        Iterator<File> iterator = fileCompacted.getFileSuported().getListOfFilesHeaders().iterator();

        while(iterator.hasNext()){
            File fileIterated = iterator.next();
            if(fileIterated.getId() == idFile){
                fileIterated.setActivated(false);
            }
        }
    }

    public void saveFileInDisc(String fileName){
        try {
            FileOutputStream outputStream = new FileOutputStream(fileName + ".piv");
            ObjectOutputStream obj = new ObjectOutputStream(outputStream);

            fileCompacted.getFileSuported().setModifiedDate(LocalDate.now());

            obj.writeObject(fileCompacted);

            obj.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void showFile(byte[] textFile, int end){
        byte[] text = Arrays.copyOf(textFile, end);

        String output = new String(text);

        System.out.print(output);
    }

    public void extractFile(int idArquivo, String pastaDestino) throws IOException {
        if(fileCompacted.getListOfFileBytes().containsKey(idArquivo)){
            Iterator<File> iterator = fileCompacted.getFileSuported().getListOfFilesHeaders().iterator();
            int size = 0;
            TypeEnum extension = null;
            String name = null;

            while(iterator.hasNext()){
                File file = iterator.next();

                if(file.getId() == idArquivo){
                    size = file.getByteSize();
                    extension = file.getType();
                    name = file.getName();
                }
            }

            if(size != 0){
                FileOutputStream fileOutputStream = new FileOutputStream(pastaDestino + name + extension.getExtension());
                byte[] file = Arrays.copyOf(fileCompacted.getListOfFileBytes().get(idArquivo), size - 1);
                fileOutputStream.write(file);
            }
        }
    }

    public void defrag(){

    }
}
