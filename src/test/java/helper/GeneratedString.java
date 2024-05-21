package helper;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class GeneratedString {
    static Faker faker = new Faker();
    public static String name = "";
    public static String numberPhone = "";
    public static String voucherName = "";
    public static String getVoucherName() {
        return voucherName;
    }

    public static void setVoucherName(String voucherName) {
        GeneratedString.voucherName = voucherName;
    }

    public static String getNumberPhone() {
        return numberPhone;
    }

    public static void setNumberPhone(String numberPhone) {
        GeneratedString.numberPhone = numberPhone;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        GeneratedString.name = name;
    }

    public static String randomPhoneNumber() {
        String generatedString = RandomStringUtils.randomNumeric(9);
        return ("089" + generatedString);
    }

    public static String randomCode() {
        String generatedString = RandomStringUtils.randomNumeric(8);
        return ("SDET" + generatedString);
    }

    public static String randomProducts(String text) {
        String generatedString = RandomStringUtils.randomNumeric(8);
        return (text + " - " + generatedString);
    }

    public static String voucherName(String name) {
        String generatedString = RandomStringUtils.randomNumeric(4);
        String vcName = "Voucher " + name + " " + generatedString;
        setVoucherName(vcName);
        return vcName;
    }

    public static String randomName() {
        return faker.name().fullName();
    }

    @Test
    public void test() {
        voucherName("Test");
        System.out.println(getVoucherName());
    }
}
