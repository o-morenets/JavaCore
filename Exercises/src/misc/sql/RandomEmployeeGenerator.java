package misc.sql;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

public class RandomEmployeeGenerator {
    private static final String host = "jdbc:mysql://localhost/hibernate";
    private static final String username = "root";
    private static final String password = "root";
    private static final int numberOfInstitutions = 5;

    @SuppressWarnings("serial")
    private static final ArrayList<String> names = new ArrayList<String>() {{
        add("James");
        add("Mary");
        add("Patricia");
        add("John");
        add("Jennifer");
        add("Robert");
        add("Linda");
        add("Elizabeth");
        add("William");
        add("David");
    }};

    @SuppressWarnings("serial")
    private static final ArrayList<String> surnames = new ArrayList<String>() {{
        add("Smith");
        add("Johnson");
        add("Williams");
        add("Jones");
        add("Brown");
        add("Davis");
        add("Miller");
        add("Willson");
        add("Moore");
        add("Taylor");
    }};

    @SuppressWarnings("serial")
    private static final ArrayList<String> institutionNames = new ArrayList<String>() {{
        add("La Habra East");
        add("La Habra West");
        add("La Habra North");
        add("La Habra South");
        add("La Habra Central");
    }};

    //Building Info
    @SuppressWarnings("serial")
    private static final ArrayList<String> buildingName = new ArrayList<String>() {{
        add("Building AA");
        add("Building AB");
        add("Building BA");
        add("Building BB");
        add("Building AAA");
    }};

    @SuppressWarnings("serial")
    private static final ArrayList<String> buildingTown = new ArrayList<String>() {{
        add("Los Angele");
        add("Houston");
        add("Miami");
        add("Springfiel");
        add("Boston");
        add("Cleveland");
        add("Salem");
        add("New York");
    }};
    private static final String charactersBig = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String charactersSmall = "qwertzuiopasdfghjklyxcvbnm";
    Random rand = new Random();
    private int numberOfEmployees = 0;
    private ArrayList<Integer> institutionIds = null;
    private Connection conn = null;
    private Statement statement = null;
    private ResultSet result = null;
    private int numberOfBuildings = 0;

    public RandomEmployeeGenerator(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
        this.numberOfBuildings = numberOfEmployees;
        institutionIds = new ArrayList<Integer>();
        try {
            conn = DriverManager.getConnection(host, username, password);
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        addRandomInstitution();
//        addRandomBuilding();
//        addRandomEmployees();

//		findInstitutionIds();

        try {
            queryUserGroupId("admin");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new RandomEmployeeGenerator(50);
    }

    public ResultSet queryUserGroupId(String username) throws SQLException {
        PreparedStatement st = conn.prepareStatement("SELECT usergroupid FROM fglad_user WHERE username = ?;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        st.setString(1, username);
        ResultSet rs = st.executeQuery();

//        conn.commit();

        return rs;
    }

    private void findInstitutionIds() {
        try {
            result = statement.executeQuery("SELECT * FROM Institution");
            while (result.next()) {
                institutionIds.add(result.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Employee
    public void addRandomEmployees() {
        for (int i = 0; i < numberOfEmployees; ++i) {
            try {
                statement.executeUpdate("INSERT INTO Employee(Name, Surname, InstitutionID) VALUES ('" + names.get(rand.nextInt(names.size())) +
                        "', '" + surnames.get(rand.nextInt(surnames.size())) + "', " + institutionIds.get(rand.nextInt(institutionIds.size())) + ")");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //Institution
    public void addRandomInstitution() {
        for (int i = 0; i < numberOfInstitutions; ++i) {
            try {
                statement.executeUpdate("INSERT INTO Institution(Name) VALUES ('" + institutionNames.get(rand.nextInt(institutionNames.size())) + "')");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //Building
    private String generateStreetName(int length) {
        StringBuilder sb = new StringBuilder(length);
        sb.append(charactersBig.charAt(rand.nextInt(charactersBig.length())));
        for (int i = 0; i < length - 1; i++) {
            sb.append(charactersSmall.charAt(rand.nextInt(charactersSmall.length())));
        }

        return sb.toString();

    }

    public void addRandomBuilding() {
        for (int i = 0; i < numberOfBuildings; ++i) {
            try {
                statement.executeUpdate("INSERT INTO Building(Name, Zipcode, Street,Hausnr ,Town, InstitutionID) VALUES ('" + buildingName.get(rand.nextInt(buildingName.size())) + "', " + rand.nextInt(100000000) + ", '" +
                        generateStreetName(rand.nextInt((7 - 3) + 1) + 3) + " Street', " + rand.nextInt(10000) + ",'" + buildingTown.get(rand.nextInt(buildingTown.size())) + "'," + institutionIds.get(rand.nextInt(institutionIds.size())) + ")");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void close() {
        try {
            statement.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}