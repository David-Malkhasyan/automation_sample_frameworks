package utils;

import io.qameta.allure.Allure;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHelper {
    public static void clearFile(String fileName) {
        try {
            FileWriter fw = new FileWriter(fileName, false);
            PrintWriter pw = new PrintWriter(fw, false);
            pw.flush();
            pw.close();
            fw.close();
        } catch (Exception exception) {
            System.out.println("Exception have been caught");
        }
    }

    public static void addLogsToAllure() {
        String methodLogsFilePath = "target/logs/logs.log";
        String logs = null;
        try {
            logs = Files.readString(Paths.get(methodLogsFilePath));
        } catch (IOException ignored) {
        }
        Allure.addAttachment("Logs", logs);
        clearFile(methodLogsFilePath);
    }
}
