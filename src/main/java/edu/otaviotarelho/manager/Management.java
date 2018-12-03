package edu.otaviotarelho.manager;

import edu.otaviotarelho.dto.File;
import edu.otaviotarelho.dto.FileCompacted;
import edu.otaviotarelho.dto.FileSuported;
import edu.otaviotarelho.enuns.TypeEnum;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.util.*;

import static java.nio.file.Files.readAllBytes;
import static java.util.Objects.requireNonNull;

public class Management {

    public FileCompacted fileCompacted;
    private Object[] tableColumns = {
        "id", "name", "type", "path Origem", "byteSize", "blockSize", "criation Date", "modified Date"
    };
    private Object[][] listOfFiles;

    public Management(){

    }

    public void addFile(Path path) throws IOException {
        if(fileCompacted == null){
            addNewFileFromBlackFile(path);
            return;
        }

        addNewFileFromExistingFile(path);
    }

    private void addNewFileFromExistingFile(Path path) throws IOException {
        InputStream file = new FileInputStream(path.toString());
        byte[] bytes = IOUtils.toByteArray(file);
        BasicFileAttributes metaData = Files.readAttributes(path, BasicFileAttributes.class);
        TypeEnum type = getType(path.toAbsolutePath().toString());

        int id = getBestId(bytes.length);

        File fileCreated = null;

        for(File fileS : fileCompacted.getFileSuported().getListOfFilesHeaders()){
            if(fileS.getId() == id){
                fileCreated = fileS;
            }
        }

        if(fileCreated == null){
            fileCreated = new File(id, path.getFileName().toString(), type, path.toAbsolutePath().toString(),
                    bytes.length, bytes.length,  metaData.creationTime().toString(), metaData.lastModifiedTime().toString());
        }
        else{

            fileCreated.setName(path.getFileName().toString());
            fileCreated.setType(type);
            fileCreated.setPathOrigem(path.toAbsolutePath().toString());
            fileCreated.setByteSize(bytes.length);
            fileCreated.setBlockSize(bytes.length);
            fileCreated.setModifiedDate(metaData.creationTime().toString());
            fileCreated.setCriationDate(metaData.lastModifiedTime().toString());
        }

        fileCreated.setActivated(true);
        fileCompacted.getFileSuported().getListOfFilesHeaders().add(fileCreated);
        fileCompacted.getListOfFileBytes().put(id, bytes);
    }

    private void addNewFileFromBlackFile(Path path) throws IOException {
        fileCompacted = new FileCompacted();
        fileCompacted.setFileSuported( new FileSuported());
        fileCompacted.setListOfFileBytes(new HashMap<>());

        InputStream file = new FileInputStream(path.toString());
        byte[] bytes = IOUtils.toByteArray(file);
        BasicFileAttributes metaData = Files.readAttributes(path, BasicFileAttributes.class);

        int id = 1;

        TypeEnum type = getType(path.toAbsolutePath().toString());

        File fileCreated = new File(id, path.getFileName().toString(), type, path.toAbsolutePath().toString(),
                bytes.length, bytes.length,  metaData.creationTime().toString(), metaData.lastModifiedTime().toString());
        fileCreated.setActivated(true);


        List<File> list = new ArrayList<>();
        list.add(fileCreated);
        fileCompacted.getFileSuported().setListOfFilesHeaders(list);
        fileCompacted.getListOfFileBytes().put(id, bytes);
    }

    private int getBestId(int fileSize){
        int bestId = 0;
        int maxSize = 0;
       for(File file : fileCompacted.getFileSuported().getListOfFilesHeaders()) {
           if(!file.isActivated()){
               if(fileSize <= file.getBlockSize() && (file.getBlockSize() - fileSize) < maxSize){
                   maxSize = (file.getBlockSize() - fileSize);
                   bestId = file.getId();
               }
           }
       }

       if(bestId == 0){
           bestId = fileCompacted.getFileSuported().getListOfFilesHeaders().size() + 1;
       }

       return bestId;
    }

    private TypeEnum getType(String path){
        return TypeEnum.getExtensionFromFile(FilenameUtils.getExtension(path));
    }

    public TableModel listFiles() {
        TableModel listModel = new DefaultTableModel();
        listOfFiles = null;

        if(fileCompacted != null) {
            if(!fileCompacted.getFileSuported().getListOfFilesHeaders().isEmpty()){
                listOfFiles = new Object[fileCompacted.getFileSuported().getSizeOfActivatedFiles()][tableColumns.length];
                int linha = 0;
                for(File fileHeaders : fileCompacted.getFileSuported().getListOfFilesHeaders()){
                    if(fileHeaders.isActivated()){
                        listOfFiles[linha][0] = fileHeaders.getId();
                        listOfFiles[linha][1] = fileHeaders.getName();
                        listOfFiles[linha][2] = fileHeaders.getType();
                        listOfFiles[linha][3] = fileHeaders.getPathOrigem();
                        listOfFiles[linha][4] = fileHeaders.getByteSize();
                        listOfFiles[linha][5] = fileHeaders.getBlockSize();
                        listOfFiles[linha][6] = fileHeaders.getCriationDate();
                        listOfFiles[linha][7] = fileHeaders.getModifiedDate();
                        linha++;
                    }
                }
            }
        }

        ((DefaultTableModel) listModel).setDataVector(listOfFiles, tableColumns);

        return listModel;
    }


    public void readFile(Path path) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(readAllBytes(path));
        ObjectInputStream ois = new ObjectInputStream(bis);
        fileCompacted = (FileCompacted) ois.readObject();

        requireNonNull(fileCompacted);

    }

    public void removeFiles(int idFile){
        requireNonNull(fileCompacted.getFileSuported().getListOfFilesHeaders());
        requireNonNull(listOfFiles);

        Iterator<File> iterator = fileCompacted.getFileSuported().getListOfFilesHeaders().iterator();
        int idArquivo = (int) listOfFiles[idFile][0];

        while(iterator.hasNext()){
            File fileIterated = iterator.next();
            if(fileIterated.getId() == idArquivo){
                fileIterated.setActivated(false);
                break;
            }
        }
    }

    public void saveFileInDisc(String fileName) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(fileName + ".piv");
        ObjectOutputStream obj = new ObjectOutputStream(outputStream);

        fileCompacted.getFileSuported().setModifiedDate(LocalDate.now());

        obj.writeObject(fileCompacted);

        obj.close();
    }

    public String saveToOrigem(int idFile) throws IOException {
        Iterator<File> iterator = fileCompacted.getFileSuported().getListOfFilesHeaders().iterator();
        String fullpath = "";
        int idArquivo = (int) listOfFiles[idFile][0];

        while(iterator.hasNext()){
            File file = iterator.next();
            if(file.getId() == idArquivo){
                fullpath = file.getPathOrigem();
                byte[] fileByte = fileCompacted.getListOfFileBytes().get(idArquivo);
                FileUtils.writeByteArrayToFile(new java.io.File(fullpath), fileByte);
                break;
            }
        }

        return fullpath;
    }

    public void showFile(byte[] textFile, int end){
        byte[] text = Arrays.copyOf(textFile, end);

        String output = new String(text);

        System.out.print(output);
    }

    public void extractFile(int idFile, String pastaDestino) throws IOException {
        requireNonNull(fileCompacted.getFileSuported().getListOfFilesHeaders());
        requireNonNull(listOfFiles);

        int idArquivo = (int) listOfFiles[idFile][0];

        if(fileCompacted.getListOfFileBytes().containsKey(idArquivo)){
            Iterator<File> iterator = fileCompacted.getFileSuported().getListOfFilesHeaders().iterator();
            int size = 0;
            String name = null;

            while(iterator.hasNext()){
                File file = iterator.next();

                if(file.getId() == idArquivo){
                    size = file.getByteSize();
                    name = file.getName();
                }
            }

            if(size != 0){
                FileOutputStream fileOutputStream = new FileOutputStream(pastaDestino + "/" + name);
                byte[] file = Arrays.copyOf(fileCompacted.getListOfFileBytes().get(idArquivo), size - 1);
                fileOutputStream.write(file);
            }
        }
    }

    public void defrag(){
        Iterator<File> iterator = fileCompacted.getFileSuported().getListOfFilesHeaders().iterator();

        while(iterator.hasNext()){
            File file = iterator.next();
            if(!file.isActivated()){
                fileCompacted.getListOfFileBytes().remove(file.getId());
                iterator.remove();
            }
        }
    }
}
