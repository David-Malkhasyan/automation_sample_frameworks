package swagger.petStore.helpers;


import swagger.petStore.endpoints.BaseEndpoints;
import swagger.petStore.endpoints.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Helper {
    private static final String DOMAIN = "https://petstore.swagger.io/";
    private static final String DOMAIN_MAIN = "petstore.swagger.io";
    private static final String PROTOCOL = "https://";
    private static final String TEST_ENV = System.getProperty("env");

    public static String baseUrl(Service service) {
        return new StringBuilder
                (BaseEndpoints.PROTOCOL.getValue())
                .append(BaseEndpoints.DOMAIN.getValue())
                .append('/')
                .append(BaseEndpoints.APIV2.getValue())
                .append("/")
                .append(service.getServiceName())
                .append("/")
                .toString();
    }

    public static String randomStringGenerator() {
        return "auto_test_" + LocalDateTime.now();
    }

    public static String getDateNowWithMilliseconds() {
        String formattedDate;
        String currentHostName = System.getProperty("user.name");
        if (currentHostName.equals("root")) {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime plusHours = now.plusHours(4);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            formattedDate = plusHours.format(formatter);
        } else {
            Date date = new Date();
            formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
        }
        return formattedDate;
    }

    public static String getDateNow() {
        Date date = new Date();
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public static String addMonths(Date date, int months) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, months);
        return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
    }

    public static Date getLocalDate(java.sql.Date date) {
        LocalDateTime dateTime = date.toLocalDate().atStartOfDay(ZoneId.systemDefault()).toLocalDateTime();
        return Date.from(dateTime.toInstant(ZoneOffset.UTC));
    }

    public static int getCountOfSpecialCharInText(String text, char symbol) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == symbol) {
                count++;
            }
        }
        return count;
    }

    public static Map<String, String> convertToMap(String text, String firstRegex, String secondRegex) {
        return Arrays.stream(text.trim().split(firstRegex))
                .map(line -> line.split(secondRegex))
                .collect(HashMap::new, (m, parts) -> m.put(parts[0], parts[1]), HashMap::putAll);
    }

    public static int roundingScale(BigDecimal originalValue) {
        boolean secondDigitIsZero = originalValue.remainder(BigDecimal.ONE).movePointRight(2).intValue() % 10 == 0;
        return secondDigitIsZero ? 1 : 2;
    }

}
