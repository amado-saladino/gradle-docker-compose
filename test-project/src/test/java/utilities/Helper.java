package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class Helper {
    private static Random random = new Random();

    public static void takeScreenshot(WebDriver driver, String imageFile) {
        System.out.println("Taking screenshot...");
        Path path = Paths.get("screenshots",imageFile+ createDateTimeStamp() +".png");
        try {
            Files.createDirectories((path.getParent()));
            FileOutputStream fileOutputStream = new FileOutputStream(path.toString());
            fileOutputStream.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES) ) ;
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String createDateTimeStamp() {
        return new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    }

    public static String generateProductKeyword(String product) {
        int length = product.length();
        int startIndex, endIndex;
        String keyword;

        while(true) {
            startIndex = random.nextInt(length -1) + 0;
            endIndex = random.nextInt(length - 1);

            if (endIndex - startIndex >= 5) {
                keyword = product.substring(startIndex, endIndex);
                break;
            }
        }
        return keyword;
    }
}
