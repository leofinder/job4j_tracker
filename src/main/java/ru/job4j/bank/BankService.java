package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковской системы
 * @author leofinder
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение списка пользователей с реквизитами банковского счета осуществляется в Map
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет его в список пользователей.
     * @param user пользователь, который добавляется в список
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает на вход паспорт пользователя и новый банковский счета.
     * Добавляет новый банковский счет к пользователю.
     * @param passport номер паспорта пользователя
     * @param account банковский счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта
     * @param passport номер паспорта пользователя
     * @return возвращает пользователя или null если пользователь не найден
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод ищет счет пользователя по реквизитам
     * @param passport номер паспорта пользователя
     * @param requisite реквизиты банковского счета
     * @return возвращает счет пользователя или null если пользователь или счет не найдены
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод предназначен для перечисления денег с одного счёта на другой счёт
     * @param srcPassport номер паспорта пользователя, с которого будут перечислены деньги
     * @param srcRequisite реквизиты банковского счета, с которого будут перечислены деньги
     * @param destPassport номер паспорта пользователя, на который будут перечислены деньги
     * @param destRequisite реквизиты банковского счета, на который будут перечислены деньги
     * @param amount количество денег для перевода
     * @return возвращает true если перевод произведен,
     *         возвращает false если счёт не найден или не хватает денег на счёте с которого переводят
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
