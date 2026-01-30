import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

public class Benutzer {

    private String benutzername;
    private String vorname;
    private String nachname;

    public Benutzer(String benutzername, String vorname, String nachname) {
        this.benutzername = benutzername;
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public String getBenutzername() {
        return benutzername;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public static boolean register(String benutzername, String passwort, String vorname, String nachname) {
        String sql = "INSERT INTO benutzer (name, passwort, vorname, nachname) VALUES (?, ?, ?, ?)";

        try (Connection conn = MySQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, benutzername);
            stmt.setBytes(2, encode(passwort));
            stmt.setString(3, vorname);
            stmt.setString(4, nachname);

            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public static Benutzer login(String benutzername, String passwort) {
        String sql = "SELECT * FROM benutzer WHERE name = ?";

        try (Connection conn = MySQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, benutzername);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                byte[] gespeichertesPasswort = rs.getBytes("passwort");
                byte[] eingegebenesPasswort = encode(passwort);

                if (Arrays.equals(gespeichertesPasswort, eingegebenesPasswort)) {
                    return new Benutzer(
                            rs.getString("name"),
                            rs.getString("vorname"),
                            rs.getString("nachname")
                    );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static byte[] encode(String passwort) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(passwort.getBytes(StandardCharsets.UTF_8));
    }
}
