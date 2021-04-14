import java.io.*;
import java.nio.file.Files;

public class WriteFiles {
    public static void main(String[] args) throws IOException {
        try(BufferedWriter fileWriter = new BufferedWriter(new FileWriter("C:\\Users\\radha\\Documents\\Research\\ml-25m\\ml-25m\\first_100_ratings.csv"));
        BufferedWriter fileWriter2 = new BufferedWriter(new FileWriter("C:\\Users\\radha\\Documents\\Research\\ml-25m\\ml-25m\\second_100_ratings.csv"))){
            write(fileWriter,1,500000);
            write(fileWriter2,500000,1000000);
        }

    }

    private static void write(BufferedWriter fileWriter,int startLine, int endLine) throws IOException {
//        File srcFile = new File("C:\\Users\\radha\\Documents\\Research\\ml-25m\\ml-25m\\ratings.csv");
//        Files.lines(srcFile.toPath()).
        try(BufferedReader fileReader = new BufferedReader
                (new FileReader("C:\\Users\\radha\\Documents\\Research\\ml-25m\\ml-25m\\ratings.csv"))){
            String line = null;
            int lineNo = 0;
            while ((line = fileReader.readLine()) != null) {
                lineNo++;
                if(lineNo < startLine){
                    continue;
                }
                fileWriter.write(line);
                fileWriter.write("\n");
                if(lineNo > endLine){
                    break;
                }

            }
        }


    }
}
