import java.io.*;

public class SplitRatingFile {
    public static void main(String[] args) throws IOException {
        try(BufferedWriter fileWriter1 = new BufferedWriter(new FileWriter("C:\\Users\\radha\\Documents\\Research\\ml-25m\\ml-25m\\split1.csv"));
            BufferedWriter fileWriter2 = new BufferedWriter(new FileWriter("C:\\Users\\radha\\Documents\\Research\\ml-25m\\ml-25m\\split2.csv"));
            BufferedWriter fileWriter3 = new BufferedWriter(new FileWriter("C:\\Users\\radha\\Documents\\Research\\ml-25m\\ml-25m\\split3.csv"));
            BufferedWriter fileWriter4 = new BufferedWriter(new FileWriter("C:\\Users\\radha\\Documents\\Research\\ml-25m\\ml-25m\\split4.csv"));
            BufferedWriter fileWriter5 = new BufferedWriter(new FileWriter("C:\\Users\\radha\\Documents\\Research\\ml-25m\\ml-25m\\split5.csv"));
            BufferedReader fileReader = new BufferedReader(new FileReader("C:\\Users\\radha\\Documents\\Research\\ml-25m\\ml-25m\\ratings.csv"))){
            int lineNo = 1;
            fileReader.readLine();
            String oneLine = null;
            while((oneLine = fileReader.readLine()) != null) {
                lineNo++;
                if(lineNo <= 4000019){
                    fileWriter1.write(oneLine);
                    fileWriter1.write("\n");
                    continue;
                }
                if(lineNo <= 4000019 * 2){
                    fileWriter2.write(oneLine);
                    fileWriter2.write("\n");
                    continue;
                }
                if (lineNo <= 4000019 * 3) {
                    fileWriter3.write(oneLine);
                    fileWriter3.write("\n");
                    continue;
                }
                if (lineNo <= 4000019 * 4) {
                    fileWriter4.write(oneLine);
                    fileWriter4.write("\n");
                    continue;
                }
                if(lineNo <= 4000019 * 5){
                    fileWriter5.write(oneLine);
                    fileWriter5.write("\n");
                }


            }
        }
    }

}
