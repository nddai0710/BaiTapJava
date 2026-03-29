import java.io.*;

public class Manager {

    public void processFile(String inputFile, String outputFile) {
        StringBuilder content = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    content.append(line).append(" ");
                }
            }
        } catch (IOException e) {
            System.err.println("File not found!");
            return;
        }

        String normalized = normalizeText(content.toString());

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)))) {
            pw.print(normalized);
            System.out.println("Normalize successful!");
        } catch (IOException e) {
            System.err.println("Cannot write to file!");
        }
    }

    public String normalizeText(String source) {
        source = source.trim().toLowerCase();

        source = source.replaceAll("\\s+", " ");

        source = source.replaceAll("\\s*([.,:])\\s*", "$1 ");

        source = source.replaceAll("\"\\s+", "\"");

        source = source.replaceAll("\\s+\"", "\"");

        StringBuilder sb = new StringBuilder(source);

        if (sb.length() > 0) {
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        }

        for (int i = 0; i < sb.length() - 2; i++) {
            if (sb.charAt(i) == '.' && sb.charAt(i+1) == ' ') {
                if (Character.isLetter(sb.charAt(i+2))) {
                    sb.setCharAt(i+2, Character.toUpperCase(sb.charAt(i+2)));
                }
            }
        }

        String result = sb.toString().trim();
        if (!result.endsWith(".")) {
            result += ".";
        }

        return result;
    }
}