import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;

public class Main {
    static class User {
        public final String surname;        // Фамилия
        public final String name;           // Имя
        public final String patronymic;     // Отчество
        public final String birthDate;      // Дата рождения
        public final int phone;             // Номер телефона
        public final char sex;              // Пол
 // Конструктор по умолчанию
        public User(String surname, String name, String patronymic,
                    String birthDate, int phone, char sex) {
            this.surname = surname;
            this.name = name;
            this.patronymic = patronymic;
            this.birthDate = birthDate;
            this.phone = phone;
            this.sex = sex;
        }

    // Конструктор, который парсит входную строку
        public User(String inputString) throws Exception {
            // Разбиваем строку по пробелу
            String[] parsedArray = inputString.split(" ");
            // Проверяем распаршенный массив на соответствие размерам
            if (parsedArray.length < 6) {
                throw new Exception("Пользователь ввёл меньше данных, чем требовалось");
            }
            if (parsedArray.length > 6) {
                throw new Exception("Пользователь ввёл больше данных, чем требовалось");
            }
            // Проверяем формат даты рождения
            // Метод matches проверяет строку по регулярному выражению
            // ^ - признак начала строки
            // далее идут цифры для дня первая от 0 до 3, вторая от 0 до 9
            // потом идёт точка
            // далее идут цифры для месяца первая от 0 до 1, вторая от 0 до 9
            // потом снова идёт точка
            // в конце идут цифры для года от 0 до 9 - 4 штуки
            // $ - признак конца строки
            if (!parsedArray[3].matches("^[0-3][0-9]\\.[0-1][0-9]\\.[0-9]{4}$")) {
                throw new Exception("Формат даты рождения не соответствует dd.mm.yyyy");
            }
            // Проверка номера телефона
            // Метод matches проверяет строку по регулярному выражению
            // ^ - признак начала строки
            // строка должна содержать только цифры от 0 до 9
            // + - таких цифр должна быть хотя бы одна
            // $ - признак конца строки
            if (!parsedArray[4].matches("^[0-9]+$")) {
                throw new Exception("Неправильно введён телефонный номер");
            }
            // Проверка пола
            // Метод matches проверяет строку по регулярному выражению
            // ^ - признак начала строки
            // набор символов для этой строки ограничен символами f и m
            // $ - признак конца строки
            if (!parsedArray[5].matches("^[fm]$")) {
                throw new Exception("Неправильно введён пол");
            }
            // Присваиваем распаршенные значения полям класса
            this.surname = parsedArray[0];
            this.name = parsedArray[1];
            this.patronymic = parsedArray[2];
            this.birthDate = parsedArray[3];
            this.phone = Integer.parseInt(parsedArray[4]);
            this.sex = parsedArray[5].charAt(0);
        }
        // Метод по преобразованию объекта класса к строке
        @Override
        public String toString() {
            return surname + " " + name + " " + patronymic + " " +
                    birthDate + " " + phone + " " + sex + "\n";
        }
    }
    public static void main(String[] args) {
        String pathToFile = "E:\\";     // Путь к папке, в которую будут сохраняться файлы
        // Ридер для чтения из консоли
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Введите пользователя: ");
            // Чтение из консоли и сразу парсинг пользователя
            User user = new User(br.readLine());
            // В случае успешного парсинга - составление имени нового файла
            String fileFullName = pathToFile + user.surname + ".txt";
            // Запись в файл пользователя
            Files.write(
                    Paths.get(fileFullName),                        // Путь к файлу для записи
                     Collections.singletonList(user.toString()),     // Информацию о пользователе кладём в массив строк для записи
                    Charset.forName("Windows-1251")      // Сохраняем всё в кодировки Windows-1251
            );
            System.out.println("Файл с пользователем сохранён по пути: " + fileFullName);
        } catch (IOException e) {
            // В случае ошибки чтение с консоли выводим соответсвующее сообщение
            e.printStackTrace();
        } catch (Exception e) {
            // В случае ошибок инициализации выводим сообщения о них
            System.out.println(e.getMessage());
        }
    }
}