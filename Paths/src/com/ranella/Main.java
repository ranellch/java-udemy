package com.ranella;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {

    public static void main(String[] args) {

        try {
//            Path fileToCreate = FileSystems.getDefault().getPath("Examples","file1.txt");
//            Files.createFile(fileToCreate);
//            Path DirToCreate = FileSystems.getDefault().getPath("Examples","Dir2/Dir3/Dir4/Dir5/Dir6");
//            Files.createDirectories(DirToCreate);

            Path filePath = FileSystems.getDefault().getPath("Examples","Dir1/file1.txt");
            long size = Files.size(filePath);
            System.out.println("Size = " + size);
            System.out.println("Last modified = " + Files.getLastModifiedTime(filePath));

            BasicFileAttributes attributes = Files.readAttributes(filePath,BasicFileAttributes.class);
            System.out.println("Size = " + attributes.size());
            System.out.println("Last modified = " + attributes.lastModifiedTime());
            System.out.println("Created = " + attributes.creationTime());

//            Path fileToDelete = FileSystems.getDefault().getPath("Examples","Dir1","file1copy.txt");
//            Files.delete(fileToDelete);

//            Path fileToMove = FileSystems.getDefault().getPath("Examples","file1.txt");
//            Path destination = FileSystems.getDefault().getPath("Examples","file2.txt");
//            Files.move(fileToMove,destination);

//            Path sourceFile = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Path copyFile = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
//            Files.copy(sourceFile,copyFile, StandardCopyOption.REPLACE_EXISTING);
//
//            sourceFile = FileSystems.getDefault().getPath("Examples","Dir1");
//            copyFile = FileSystems.getDefault().getPath("Examples","Dir4");
//            Files.copy(sourceFile,copyFile, StandardCopyOption.REPLACE_EXISTING);

        } catch(IOException e) {
            System.out.println(e.getMessage());
        }

    }
//        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
//        printFile(path);
//
//        Path filePath = FileSystems.getDefault().getPath("files","SubdirectoryFile.txt");
//        printFile(filePath);
//
//        filePath = Paths.get("C:\\Users\\cr737d\\Desktop\\JavaPrograms\\OutThere.txt");
//        printFile(filePath);
//
//        filePath = Paths.get(".");
//        System.out.println(filePath.toAbsolutePath());
//
//        filePath = FileSystems.getDefault().getPath("files");
//        System.out.println("Exists = " + Files.exists(filePath));
//
//    }
//
//    private static void printFile(Path path) {
//        try(BufferedReader fileReader = Files.newBufferedReader(path)) {
//            String line;
//            while((line = fileReader.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//    }
}
