import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User admin = new User("admin", "wfc2432", Role.ADMIN);
        User moder = new User("moder", "qwelu78", Role.MODER);
        User user = new User("user", "user123", Role.USER);
        String[] array = Interface.entering();
        Map<String, EveryDayNotes> everyDayMap = new HashMap<>();
        Map<String, WorkNotes> workMap = new HashMap<>();
        byte i = User.authorizationMark(array[0], array[1], admin, moder, user);
        if (i == 0) System.exit(403);
        byte j = 1;
        while (j != 0) {
            j = Interface.mainMenuCycle();
            while (j < 0 || j > 3) {
                j = Interface.mainMenuCycle();
            }
            switch (j) {
                case 1:
                    String[] array2 = Interface.entering();
                    i = User.authorizationMark(array2[0], array2[1], admin, moder, user);
                    if (i == 0) System.exit(403);
                    break;
                case 2:
//                    создание заметки
                    if (i != 3) {
                        System.out.print("Какую заметку нужно создать?(Повседневная или Рабочая): ");
                        String type = Interface.stringScanner();
                        if (type.equals("Повседневная")) {
                            EveryDayNotes.createEvNot(i, everyDayMap);
                            break;
                        }
                        if (type.equals("Рабочая")) {
                            WorkNotes.createWorNot(i, workMap);
                            break;
                        } else System.out.println("При вводе была допущена ошибка");
                        break;
                    } else System.out.println("Нет доступа");
                    break;
                case 3:
//                    поиск заметки для дальнейшей работы
                        boolean flag1;
                        boolean flag2;
                        String lookingTitle = Interface.scannerTitle();
                        while (lookingTitle.trim().length() == 0) {
                            lookingTitle = Interface.scannerTitle();
                        }
                        try {
                            if (everyDayMap.size() == 0) {
                                throw new MapException("В текущий момент заметок нет", null);
                            }
                            if (workMap.size() == 0) {
                                throw new MapException("В текущий момент заметок нет", null);
                            }
                        }
                        catch (MapException me){
                            System.out.println(me.getMessage());
                            break;
                        }
                        flag1 = everyDayMap.containsKey(lookingTitle);
                        flag2 = workMap.containsKey(lookingTitle);
                        if (flag1 || flag2) System.out.println("Есть такая");
                        else {
                            System.out.println("Такой нет");
                            break;
                        }
                    byte k = 1;
                    while (k != 0) {
                        k = Interface.subMenuCycle();
                        while (k < 0 || k > 6) {
                            k = Interface.subMenuCycle();
                        }
                        switch (k) {
                            case 1:
//                                вывод текущей заметки в консоль
                                if (flag1) {
                                    System.out.println(everyDayMap.get(lookingTitle).getBody());
                                    break;
                                }
                                if (flag2) {
                                    System.out.println(workMap.get(lookingTitle).getBody());
                                    break;
                                }
                            case 2:
//                                изменение названия текущей заметки
                                if (i == 3){
                                    System.out.println("Нет доступа");
                                    break;
                                }
                                if (flag1) {
                                    Map <String, EveryDayNotes> temporaryMap = new HashMap<>();
                                    temporaryMap.putAll(EveryDayNotes.changeNoteTitle(lookingTitle, everyDayMap));
                                    everyDayMap.clear();
                                    everyDayMap.putAll(temporaryMap);
                                    break;
                                }
                                if (flag2) {
                                    Map <String, WorkNotes> temporaryMap = new HashMap<>();
                                     temporaryMap.putAll(WorkNotes.changeNoteTitle(lookingTitle, workMap));
                                     workMap.clear();
                                     workMap.putAll(temporaryMap);
                                    break;
                                }
                            case 3:
//                                замена слова в текущей заметке
                                if (i == 3) {
                                    System.out.println("Нет доступа");
                                    break;
                                }
                                if (flag1) {
                                    Map <String, EveryDayNotes> temporaryMap = new HashMap<>();
                                    temporaryMap.putAll(EveryDayNotes.changeWordNote(lookingTitle, everyDayMap));
                                    everyDayMap.clear();
                                    everyDayMap.putAll(temporaryMap);
                                    break;
                                }
                                if (flag2) {
                                    Map <String, WorkNotes> temporaryMap = new HashMap<>();
                                    temporaryMap.putAll(WorkNotes.changeWordNote(lookingTitle, workMap));
                                    workMap.clear();
                                    workMap.putAll(temporaryMap);
                                    break;
                                }
                            case 4:
//                                замена тела текущей заметки
                                if (i == 3) {
                                    System.out.println("Нет доступа");
                                    break;
                                }
                                if (flag1) {
                                    Map <String, EveryDayNotes> temporaryMap = new HashMap<>();
                                    temporaryMap.putAll(EveryDayNotes.changeBodyNote(lookingTitle, everyDayMap));
                                    everyDayMap.clear();
                                    everyDayMap.putAll(temporaryMap);
                                    break;
                                }
                                if (flag2) {
                                    Map <String, WorkNotes> temporaryMap = new HashMap<>();
                                    temporaryMap.putAll(WorkNotes.changeBodyNote(lookingTitle, workMap));
                                    workMap.clear();
                                    workMap.putAll(temporaryMap);
                                    break;
                                }
                            case 5:
//                                вывод автора текущей заметки
                                if (i == 3) {
                                    System.out.println("Нет доступа");
                                    break;
                                }
                                if (flag1) {
                                    System.out.println(everyDayMap.get(lookingTitle).getAuthor());
                                    break;
                                }
                                if (flag2) {
                                    System.out.println(workMap.get(lookingTitle).getAuthor());
                                    break;
                                }
                            case 6:
                                if (i == 3) {
                                    System.out.println("Нет доступа");
                                    break;
                                }
                                if (flag1) {
                                    Map <String, EveryDayNotes> temporaryMap = new HashMap<>();
                                    temporaryMap.putAll(EveryDayNotes.deleteNote(lookingTitle, everyDayMap));
                                    everyDayMap.clear();
                                    everyDayMap.putAll(temporaryMap);
                                    break;
                                }
                                if (flag2) {
                                    Map <String, WorkNotes> temporaryMap = new HashMap<>();
                                    temporaryMap.putAll(WorkNotes.deleteNote(lookingTitle, workMap));
                                    workMap.clear();
                                    workMap.putAll(temporaryMap);
                                    break;
                                }
                        }
                    }
            }
        }
    }
}
class MapException extends RuntimeException{
    private String st;

    public MapException(String message, String st) {
        super(message);
        this.st = st;
    }
}
