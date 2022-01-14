import java.util.Scanner;

public interface Interface {
    public static byte mainMenuCycle() {
        System.out.println("""
                1. Вход под другим пользователем
                2. Создать заметку
                3. Поиск заметки.
                0. Выход
                """);
        byte i = byteScanner();
        try {
            if (i < 0 || i > 3)
                throw new MenuException("Введен неверный пункт меню", i);
        }
        catch (MenuException me){
            System.out.println(me.getMessage());
        }
        return i;
    }

    public static String stringScanner() {
        Scanner src = new Scanner(System.in);
        return src.nextLine();
    }

    public static byte byteScanner() {
        Scanner src = new Scanner(System.in);
        System.out.print("Введите нужный пункт меню: ");
        return src.nextByte();
    }

    public static byte subMenuCycle() {
        System.out.println("""
                1. Вывести заметку в консоль
                2. Изменение названия заметки
                3. Замена слова в заметке
                4. Замена тела заметки
                5. Вывести автора заметки
                6. Удалить заметку
                0. Назад
                """);
        byte i = byteScanner();
        try {
            if (i < 0 || i > 6)
                throw new MenuException("Введен неверный пункт меню", i);
        } catch (MenuException me) {
            System.out.println(me.getMessage());
        }
        return i;
    }

    public static String[] entering() {
        System.out.print("Введите логин: ");
        String login = Interface.stringScanner();
        System.out.print("Введите пароль: ");
        String password = Interface.stringScanner();
        String[] array = {login, password};
        return array;
    }

    public static String scannerTitle() {
        System.out.print("Введите название заметки: ");
        String st = stringScanner();
        try {
            if (st.trim().length() == 0)
                throw new EnteringException("Введена пустая строка", st);
        } catch (EnteringException ee) {
            System.out.println(ee.getMessage());
        }
        return st;
    }

    public static String scannerBody() {
        System.out.println("Введите тело заметки");
        return stringScanner();
    }
    public static String scannerWord(){
        Scanner src = new Scanner(System.in);
        String word = src.next();
        try {
            if (word.trim().length() == 0)
                throw new EnteringException("Введено пустая строка", word);
        }
        catch (EnteringException ee){
            System.out.println(ee.getMessage());
        }
        return word;
    }
}

class EnteringException extends RuntimeException {
    private String str;

    public EnteringException(String s, String str) {
        super(s);
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}

class MenuException extends RuntimeException {
    private byte i;

    public MenuException(String message, byte i) {
        super(message);
        this.i = i;
    }
}
