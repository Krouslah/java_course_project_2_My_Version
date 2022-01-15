import java.util.Map;

public class EveryDayNotes extends Notes{
    private String title;
    private String body;

    public EveryDayNotes(String author, String title, String body) {
        super(author);
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    public static Map<String, EveryDayNotes> createEvNot(byte i, Map <String, EveryDayNotes> everyDayMap){
        String title = Interface.scannerTitle();
        while (title.trim().length() == 0) {
            title = Interface.scannerTitle();
        }
        if (everyDayMap.containsKey(title)) {
            System.out.println("Заметка с таким названием уже создана");
        }
        EveryDayNotes note = new EveryDayNotes(Role.values()[i - 1].toString(), title, Interface.scannerBody());
        everyDayMap.put(note.getTitle(), note);
        return everyDayMap;
    }
    public static Map<String, EveryDayNotes> changeNoteTitle (String lookingTitle, Map <String, EveryDayNotes> everyDayMap){
        String newTitle = Interface.scannerTitle();
        while (newTitle.trim().length() == 0) {
            newTitle = Interface.scannerTitle();
        }
        EveryDayNotes note = new EveryDayNotes(everyDayMap.get(lookingTitle).getAuthor().toString(), newTitle, everyDayMap.get(lookingTitle).getBody());
        everyDayMap.put(note.getTitle(), note);
        everyDayMap.remove(lookingTitle);
        return everyDayMap;
    }
    public static Map<String, EveryDayNotes> changeWordNote(String lookingTitle, Map <String, EveryDayNotes> everyDayMap){
        System.out.print("Какое слово заменить: ");
        String fromWord = Interface.scannerWord();
        while (fromWord.trim().length() == 0) {
            fromWord = Interface.scannerWord();
        }
        System.out.print("На какое слово заменить: ");
        String targetWord = Interface.scannerWord();
        while (targetWord.trim().length() == 0) {
            targetWord = Interface.scannerWord();
        }
        EveryDayNotes note = new EveryDayNotes(everyDayMap.get(lookingTitle).getAuthor().toString(), everyDayMap.get(lookingTitle).getTitle(), everyDayMap.get(lookingTitle).getBody().replace(fromWord, targetWord));
        everyDayMap.remove(lookingTitle);
        everyDayMap.put(note.getTitle(), note);
        return everyDayMap;
    }
    public static Map<String, EveryDayNotes> changeBodyNote(String lookingTitle, Map <String, EveryDayNotes> everyDayMap){
        String targetBody = Interface.scannerBody();
        while (targetBody.trim().length() == 0) {
            targetBody = Interface.scannerBody();
        }
        EveryDayNotes note = new EveryDayNotes(everyDayMap.get(lookingTitle).getAuthor().toString(), everyDayMap.get(lookingTitle).getTitle(), targetBody);
        everyDayMap.remove(lookingTitle);
        everyDayMap.put(note.getTitle(), note);
        return everyDayMap;
    }
    public static Map<String, EveryDayNotes> deleteNote(String lookingTitle, Map <String, EveryDayNotes> everyDayMap){
        everyDayMap.remove(lookingTitle);
        return everyDayMap;
    }
}
