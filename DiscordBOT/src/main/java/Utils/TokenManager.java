package Utils;

import com.sun.tools.javac.Main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class TokenManager {
    public static String readAllLines(BufferedReader br){
        return br.lines().collect(Collectors.joining(System.lineSeparator()));
    }
    public static String getToken() {
        try(BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/token.yml"))){
            return readAllLines(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
