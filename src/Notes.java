public abstract class Notes <T> {
    private T author;

    public Notes(T author) {
        this.author = author;
    }

    public T getAuthor() {
        return author;
    }
}
