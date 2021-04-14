import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.*;

public class ReadMovies {
    public static void main(String[] args) throws IOException {
        try(BufferedWriter movieInfoWriter = new BufferedWriter(new FileWriter
                ("C:\\Users\\radha\\Documents\\Research\\ml-25m\\ml-25m\\movie_info.csv"));BufferedWriter
                genreWriter = new BufferedWriter(new FileWriter
                ("C:\\Users\\radha\\Documents\\Research\\ml-25m\\ml-25m\\genre.csv"))){
            write(movieInfoWriter,genreWriter);
        }
    }

    private static void write(BufferedWriter movieInfoWriter, BufferedWriter genreWriter) throws IOException {
        try(BufferedReader movieReader = new BufferedReader(new FileReader
                ("C:\\Users\\radha\\Documents\\Research\\ml-25m\\ml-25m\\movies.csv"))) {
            Set<String> genres = new HashSet<>();
            AtomicInteger lineNo = new AtomicInteger();
            movieReader.lines()
                    .skip(1)
                    .forEach(line ->
                    {processLine(line, movieInfoWriter, genres);
                        lineNo.getAndIncrement();
                        System.out.println(lineNo);
                    });
            genres.forEach(genre -> {
                        try {
                            genreWriter.write(genre);
                            genreWriter.newLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

        }
    }

    private static void processLine(String line, BufferedWriter movieInfoWriter, Set<String> genres) {
        String regex = "(\\d+),(.*),(.*)";
        String nameAndYearRegex = "(.*) ((\\(\\d+\\))?)";
        Pattern pattern = Pattern.compile(regex);
        Pattern nameAndYearPattern = Pattern.compile(nameAndYearRegex);
        Matcher matcher = pattern.matcher(line);

        //String[] splitLine = line.split(",");

        try {
            if(matcher.find()) {
                String movieId = matcher.group(1);
                if(movieId.equals("52118")) {
                    System.out.println("reached");
                }
                String nameAndYear = matcher.group(2).replaceAll("\"+|\"+$", "");
//            System.out.println("SplitLine[1] "+splitLine[1]);
                Matcher nameAndYearMatcher = nameAndYearPattern.matcher(nameAndYear);
                if(nameAndYearMatcher.find()) {
                    String movieName = nameAndYearMatcher.group(1) .replaceAll(",","");
                    String year = nameAndYearMatcher.group(2);
                    if(!year.isEmpty()){
                        year = year.trim().substring(1, year.length()-1);
                    }
                    else {
                        year = "0";
                    }
                    String genresString = matcher.group(3);
                    String[] splitGenres = genresString.split("\\|");
                    for (String genre : splitGenres) {
                        movieInfoWriter.write(String.format("%s,%s,%s,%s", movieId, movieName, year, genre));
                        movieInfoWriter.newLine();
                    }
                    genres.addAll(Arrays.asList(splitGenres));
                }

            }
            else {
                System.out.println("Match not found");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main2(String[] args) {
        String regex = "(\\d+),(.*),(.*)";
        String group2 = "(\\(\\d+\\))";
        String orgroup2 = "";
        String regex2 = "(.*) ((\\(\\d+\\))?)";
        String input = "138120,The Expedition,(no genres listed)";
        //String input2 = "The Expedition";
        String input2 = "R.S.V.P. (2002) ";


        //Creating a pattern object
        Pattern pattern = Pattern.compile(regex);
        Pattern pattern2 = Pattern.compile(regex2);
        //Matching the compiled pattern in the String
        Matcher matcher = pattern.matcher(input);
        Matcher matcher2 = pattern2.matcher(input2.trim());
        if(matcher.find()) {
            System.out.println("match: "+matcher.group(0));
            System.out.println("First group match: "+ matcher.group(1));
            System.out.println("Second group match: "+matcher.group(2).replaceAll("^\"+|\"+$", ""));
            System.out.println("Third group match: "+matcher.group(3));
        }
        if(matcher2.find()) {
            System.out.println("match: "+matcher2.group(0));
            System.out.println("First group match: "+ matcher2.group(1));
            System.out.println("Second group match: "+matcher2.group(2));
            if(matcher2.group(2).isEmpty()) {
                System.out.println("Empty");
            }
        }
        String test = "\"City of Lost Children, The (Cité des enfants perdus, La) (1995)\"";
        System.out.println(test.replaceAll("\"+|\"+$", ""));

    }
}
