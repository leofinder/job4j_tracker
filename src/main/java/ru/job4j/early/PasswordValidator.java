package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Пароль не может быть null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Длина пароля должна быть от 8 до 32 символов");
        }
        boolean isUpperChar = false;
        boolean isLowerChar = false;
        boolean isDigit = false;
        boolean isSpecial = false;
        for (char ch : password.toCharArray()) {
           if (Character.isUpperCase(ch)) {
               isUpperChar = true;
           } else if (Character.isLowerCase(ch)) {
               isLowerChar = true;
           } else if (Character.isDigit(ch)) {
               isDigit = true;
           } else {
               isSpecial = true;
           }
           if (isUpperChar && isLowerChar && isDigit && isSpecial) {
               break;
           }
        }
        if (!isUpperChar) {
            throw new IllegalArgumentException("Пароль должен содержать хотя бы один символ в верхнем регистре");
        }
        if (!isLowerChar) {
            throw new IllegalArgumentException("Пароль должен содержать хотя бы один символ в нижнем регистре");
        }
        if (!isDigit) {
            throw new IllegalArgumentException("Пароль должен содержать хотя бы одну цифру");
        }
        if (!isSpecial) {
            throw new IllegalArgumentException("Пароль должен содержать хотя бы один спец. символ");
        }
        String[] denylist = {"qwerty", "12345", "password", "admin", "user"};
        String passwordLowerCase = password.toLowerCase();
        for (String word : denylist) {
            if (passwordLowerCase.contains(word)) {
                throw new IllegalArgumentException("Пароль не должен содержать последовательность " + word);
            }
        }
        return "Password is valid";
    }
}
