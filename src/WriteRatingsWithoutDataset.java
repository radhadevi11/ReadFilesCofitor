import java.io.*;

public class WriteRatingsWithoutDataset {
    public static void main(String[] args) throws IOException {
        try(BufferedWriter fileWriter = new BufferedWriter(new FileWriter("C:\\Users\\radha\\Documents\\Research\\ml-25m\\ml-25m\\ratings3.csv"));){
            write(fileWriter);
        }
    }


    private static void write(BufferedWriter fileWriter) throws IOException {
//        File srcFile = new File("C:\\Users\\radha\\Documents\\Research\\ml-25m\\ml-25m\\ratings.csv");
//        Files.lines(srcFile.toPath()).
        try(BufferedReader fileReader = new BufferedReader
                (new FileReader("C:\\Users\\radha\\Documents\\Research\\ml-25m\\ml-25m\\ratings.csv"))){
            String line ;
            int lineNo = 0;
            fileReader.readLine();
            while ((line = fileReader.readLine()) != null && lineNo < 1000) {
                lineNo++;
                fileWriter.write(line);
                fileWriter.write(",");
                fileWriter.write(String.valueOf((int)Math.floor(Math.random()*5)+1));
                fileWriter.write(",");
                fileWriter.write(String.valueOf(Math.random()));
                fileWriter.write("\n");


            }
            System.out.println(lineNo);
        }


    }
}
