public class Main {

    public static void main(String[] args) {

        boolean registriert = Benutzer.register(
                "vitalijs",
                "geheim",
                "Vitalijs",
                "Smancers"
        );

        System.out.println("Registrierung erfolgreich: " + registriert);

        Benutzer user = Benutzer.login("vitalijs", "geheim");

        if (user != null) {
            System.out.println("Login erfolgreich!");
            System.out.println("Benutzername: " + user.getBenutzername());
            System.out.println("Vorname: " + user.getVorname());
            System.out.println("Nachname: " + user.getNachname());
        } else {
            System.out.println("Login fehlgeschlagen!");
        }
    }
}
