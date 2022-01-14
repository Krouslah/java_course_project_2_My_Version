public class User {
    private final String login;
    private final String password;
    private final Role role;

    public User(String login, String password, Role role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
    public static byte authorizationMark(String login, String password, User admin, User moder, User user) {
        if (login.equals(admin.getLogin()) && password.equals(admin.getPassword())) return 1;
        if (login.equals(moder.getLogin()) && password.equals(moder.getPassword())) return 2;
        if (login.equals(user.getLogin()) && password.equals(user.getPassword())) return 3;
        else System.out.println("Веден неверный логин или пароль");
        return 0;
    }
}
