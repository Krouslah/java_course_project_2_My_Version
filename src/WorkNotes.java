import java.util.Map;

public class WorkNotes extends Notes {
    private String title;
    private String body;

    public WorkNotes(String author, String title, String body) {
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
    public static Map<String, WorkNotes> createWorNot(byte i, Map<String, WorkNotes> workMap){
        String title = Interface.scannerTitle();
        while (title.trim().length() == 0) {
            title = Interface.scannerTitle();
        }
        if (workMap.containsKey(title)) {
            System.out.println("Заметка с таким названием уже создана");
        }
        WorkNotes note = new WorkNotes(Role.values()[i - 1].toString(), title, Interface.scannerBody());
        workMap.put(note.getTitle(), note);
        return workMap;
    }
    public static Map<String, WorkNotes> changeNoteTitle(String lookingTitle, Map<String, WorkNotes> workMap){
        String newTitle = Interface.scannerTitle();
        while (newTitle.trim().length() == 0) {
            newTitle = Interface.scannerTitle();
        }
        WorkNotes note = new WorkNotes(workMap.get(lookingTitle).getAuthor().toString(), newTitle, workMap.get(lookingTitle).getBody());
        workMap.put(note.getTitle(), note);
        workMap.remove(lookingTitle);
        return workMap;
    }
    public static Map<String, WorkNotes> changeWordNote(String lookingTitle, Map<String, WorkNotes> workMap){
        String fromWord = Interface.scannerWord();
        while (fromWord.trim().length() == 0) {
            fromWord = Interface.scannerWord();
        }
        String targetWord = Interface.scannerWord();
        while (targetWord.trim().length() == 0) {
            targetWord = Interface.scannerWord();
        }
        WorkNotes note = new WorkNotes(workMap.get(lookingTitle).getAuthor().toString(), workMap.get(lookingTitle).getTitle(), workMap.get(lookingTitle).getBody().replace(fromWord, targetWord));
        workMap.remove(lookingTitle);
        workMap.put(note.getTitle(), note);
        return workMap;
    }
    public static Map<String, WorkNotes>  changeBodyNote(String lookingTitle, Map<String, WorkNotes> workMap){
        String targetBody = Interface.scannerBody();
        while (targetBody.trim().length() == 0) {
            targetBody = Interface.scannerBody();
        }
        WorkNotes note = new WorkNotes(workMap.get(lookingTitle).getAuthor().toString(), workMap.get(lookingTitle).getTitle(), targetBody);
        workMap.remove(lookingTitle);
        workMap.put(note.getTitle(), note);
        return workMap;
    }
    public static Map<String, WorkNotes> deleteNote(String lookingTitle, Map<String, WorkNotes> workMap){
        workMap.remove(lookingTitle);
        return workMap;
    }
}
