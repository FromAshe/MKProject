package mkproject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ashenafi
 */
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
public class FileAndDirectoryInfo {
    public static void main(String args[]) throws IOException{
       // Scanner input = new Scanner(System.in);
        System.out.println("insert the file path");
        Path path = Paths.get(Fonts.fontPath);
        
        if(Files.exists(path)){
            System.out.println("I am doing great");
            System.out.println(path.getFileName());
        }
        
        if(Files.isDirectory(path)){
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
            
            for(Path p : directoryStream)
                System.out.println(p);
            
         
        }
    }
}
