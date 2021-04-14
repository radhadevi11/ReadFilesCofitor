import java.io.*;

public class SeparateFiles {
    public static void main(String[] args) throws IOException {
        try(BufferedWriter fileWriter1 = new BufferedWriter(new FileWriter("C:\\Users\\radha\\Documents\\Research\\ml-25m\\ml-25m\\split1.csv"));
            BufferedWriter fileWriter2 = new BufferedWriter(new FileWriter("C:\\Users\\radha\\Documents\\Research\\ml-25m\\ml-25m\\split2.csv"));
            BufferedWriter fileWriter3 = new BufferedWriter(new FileWriter("C:\\Users\\radha\\Documents\\Research\\ml-25m\\ml-25m\\split3.csv"));
            BufferedWriter fileWriter4 = new BufferedWriter(new FileWriter("C:\\Users\\radha\\Documents\\Research\\ml-25m\\ml-25m\\split4.csv"));
            BufferedWriter fileWriter5 = new BufferedWriter(new FileWriter("C:\\Users\\radha\\Documents\\Research\\ml-25m\\ml-25m\\split5.csv"));
            BufferedReader fileReader = new BufferedReader(new FileReader("C:\\Users\\radha\\Documents\\Research\\ml-25m\\ml-25m\\ratings2.csv"))) {
        }
    }

    public void writeOnCorrespondingSet(BufferedWriter writer, String dataSetNo) throws IOException {
        try(BufferedReader fileReader = new BufferedReader
                (new FileReader("C:\\Users\\radha\\Documents\\Research\\ml-25m\\ml-25m\\ratings2.csv"))){
            String line;
            int lineNo = 0;
            while ((line = fileReader.readLine()) != null) {
                String[] split = line.split(",");
                 if(split[4].equals(dataSetNo)) {
                     lineNo++;
                     writer.write(line);
                     writer.write("\n");
                 }

            }
        }

    }

}
