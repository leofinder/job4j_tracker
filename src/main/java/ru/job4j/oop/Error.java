package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Активность: " + active);
        System.out.println("Статус: " + status);
        System.out.println("Сообщение: " + message);
    }

    public static void main(String[] args) {
        Error errorDefault = new Error();
        errorDefault.printInfo();
        Error error403 = new Error(false, 403, "403 Forbidden");
        error403.printInfo();
        Error error404 = new Error(true, 404, "404 Not Found");
        error404.printInfo();
        Error error405 = new Error(false, 405, "405 Method Not Allowed");
        error405.printInfo();
    }
}