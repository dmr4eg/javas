package cz.cvut.fel.pjv;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Logger;

public class FileIO {
    final static Logger LOGGER = Logger.getLogger(FileIO.class.getName());
    final static String IN_FILE_NAME = "input.txt";
    final static String OUT_FILE_NAME = "output.txt";
    public void replaceChar() {
        try (FileReader fr = new FileReader(IN_FILE_NAME);
             FileWriter fw = new FileWriter(OUT_FILE_NAME)
        ){

            int c;
            boolean isSpace = false;
            while ((c = fr.read()) > -1) {
                if(!Character.isWhitespace((char) c)) {
                    fw.write(c);
                    System.out.printf(String.valueOf((char) c));
                    isSpace = false;
                } else {
                    if(!isSpace) {
                        System.out.printf(" ");
                        fw.write(' ');
                        isSpace = true;
                    }
                }
            }
        } catch (FileNotFoundException e){
            LOGGER.severe("File not found" + e.getMessage());
        } catch (IOException e) {
            LOGGER.severe(e.getMessage());
        }
    }

    public void countLines(){
        try (BufferedReader br = new BufferedReader(new FileReader(IN_FILE_NAME));
             BufferedWriter bw = new BufferedWriter(new FileWriter(OUT_FILE_NAME)) )
        {
            String line;
            int count = 0;
            while((line = br.readLine()) != null) {
                System.out.println(line);
                bw.write((count + 1) + line );
                bw.newLine();
                count++;
            }
        } catch (FileNotFoundException e){
            LOGGER.severe("File not found" + e.getMessage());
        } catch (IOException e) {
            LOGGER.severe(e.getMessage());
        }

    }

    public void countWords(){
        int count = 0;
        try (Scanner sc = new Scanner(new File(IN_FILE_NAME));)
        {
            while (sc.hasNext()) {
                System.out.println(sc.next());
                count++;
            }
            System.out.println(count);
        } catch (FileNotFoundException e){
            LOGGER.severe("File not found" + e.getMessage());
        }
    }

    public void writeInteger(){
        try(
                DataOutputStream dos = new DataOutputStream(new FileOutputStream(OUT_FILE_NAME));
                ){
             dos.writeInt(1);
            dos.writeInt(2);
            dos.writeInt(255);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
