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
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate(password)
        );
        assertThat(exception.getMessage()).isEqualTo("Длина пароля должна быть от 8 до 32 символов");
    }

    @Test
    public void whenPasswordLengthLong() {
        String password = "ЗPo1_ABJSHqsaio98s___sa!@@dfdsdsd145ASSADfdefeddsfefefe";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate(password)
        );
        assertThat(exception.getMessage()).isEqualTo("Длина пароля должна быть от 8 до 32 символов");
    }

    @Test
    public void whenPasswordDoesNotContainsUpperCaseSymbol() {
        String password = "abgbag89_";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate(password)
        );
        assertThat(exception.getMessage()).isEqualTo("Пароль должен содержать хотя бы один символ в верхнем регистре");
    }

    @Test
    public void whenPasswordDoesNotContainsLowerCaseSymbol() {
        String password = "AOPRTY89_";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate(password)
        );
        assertThat(exception.getMessage()).isEqualTo("Пароль должен содержать хотя бы один символ в нижнем регистре");
    }

    @Test
    public void whenPasswordDoesNotContainsDigit() {
        String password = "AOPRTYaa@_";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate(password)
        );
        assertThat(exception.getMessage()).isEqualTo("Пароль должен содержать хотя бы одну цифру");
    }

    @Test
    public void whenPasswordDoesNotContainsSpecialSymbol() {
        String password = "AOPRTYaa23";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate(password)
        );
        assertThat(exception.getMessage()).isEqualTo("Пароль должен содержать хотя бы один спец. символ");
    }

    @Test
    public void whenPasswordContainsDenyWord() {
        String password = "QwerTy123_";
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate(password)
        );
        assertThat(exception.getMessage()).isEqualTo("Пароль не должен содержать последовательность qwerty");
    }

    @Test
    public void whenPasswordIsOK() {
        String password = "Arty123_)";
        String rsl = PasswordValidator.validate(password);
        assertThat(rsl).isEqualTo("Password is valid");
    }
}