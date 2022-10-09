package ru.job4j.early;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PasswordValidatorTest {
    @Test
    public void whenPasswordIsNull() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate(null)
        );
        assertThat(exception.getMessage()).isEqualTo("Пароль не может быть null");
    }

    @Test
    public void whenPasswordLengthShort() {
        String password = "ЗPo1_";
        String rsl = PasswordValidator.validate(password);
        String expected = "Длина пароля должна быть от 8 до 32 символов";
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    public void whenPasswordLengthLong() {
        String password = "ЗPo1_ABJSHqsaio98s___sa!@@dfdsdsd145ASSADfdefeddsfefefe";
        String rsl = PasswordValidator.validate(password);
        String expected = "Длина пароля должна быть от 8 до 32 символов";
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    public void whenPasswordDoesNotContainsUpperCaseSymbol() {
        String password = "abgbag89_";
        String rsl = PasswordValidator.validate(password);
        assertThat(rsl).isEqualTo("Пароль должен содержать хотя бы один символ в верхнем регистре");
    }

    @Test
    public void whenPasswordDoesNotContainsLowerCaseSymbol() {
        String password = "AOPRTY89_";
        String rsl = PasswordValidator.validate(password);
        assertThat(rsl).isEqualTo("Пароль должен содержать хотя бы один символ в нижнем регистре");
    }

    @Test
    public void whenPasswordDoesNotContainsDigit() {
        String password = "AOPRTYaa@_";
        String rsl = PasswordValidator.validate(password);
        assertThat(rsl).isEqualTo("Пароль должен содержать хотя бы одну цифру");
    }

    @Test
    public void whenPasswordDoesNotContainsSpecialSymbol() {
        String password = "AOPRTYaa23";
        String rsl = PasswordValidator.validate(password);
        assertThat(rsl).isEqualTo("Пароль должен содержать хотя бы один спец. символ");
    }

    @Test
    public void whenPasswordContainsDenyWord() {
        String password = "QwerTy123_";
        String rsl = PasswordValidator.validate(password);
        assertThat(rsl).isEqualTo("Пароль не должен содержать последовательность qwerty");
    }

    @Test
    public void whenPasswordIsOK() {
        String password = "Arty123_)";
        String rsl = PasswordValidator.validate(password);
        assertThat(rsl).isEqualTo("Ok");
    }
}