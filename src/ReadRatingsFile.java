import java.io.*;

public class ReadRatingsFile {
    public static void main(String[] args) throws IOException {
        try (BufferedReader fileReader = new BufferedReader
                (new FileReader("C:\\Users\\radha\\Documents\\Research\\ml-25m\\ml-25m\\ratings2.csv"))) {
            int minMovieId = Integer.MAX_VALUE;
            int minUserId = Integer.MAX_VALUE;
            int maxMovieId = -10;
            int maxUserId = -10;
//            int lineNo = 0;
//            String line;
//            while ((line = fileReader.readLine()) != null) {
//                lineNo++;
//                if(lineNo > 25000000) {
//                    System.out.println(line);
//                }
//                String[] curLine = fileReader.readLine().split(",");
//                int curMovieId = Integer.parseInt(curLine[1]);
//                int curUserId = Integer.parseInt(curLine[0]);
//                if(curUserId > maxUserId){
//                    maxUserId = curUserId;
//                }
//                if(curUserId < minUserId) {
//                    minUserId = curUserId;
//                }
//                if(curMovieId > maxMovieId) {
//                    maxMovieId = curMovieId;
//                }
//                if(curMovieId < minMovieId) {
//                    minMovieId = curMovieId;
//                }
//            }
//            System.out.println("minMovieId = "+minMovieId + " "+"maxMovieId = "+maxMovieId);
//            System.out.println("minUserId = "+minUserId + " "+"maxUserId = "+maxUserId);
//            System.out.println(lineNo);
           int lineNo = 0;
            while (fileReader.readLine() != null) {
                lineNo++;
            }
            System.out.println(lineNo);
        }

    }


}
