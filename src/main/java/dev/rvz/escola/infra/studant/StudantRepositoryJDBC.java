package dev.rvz.escola.infra.studant;

import dev.rvz.escola.domain.studant.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudantRepositoryJDBC implements StudantRepository {

    private final Connection connection;

    public StudantRepositoryJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void registration(Studant studant) {
        String sql = "INSERT INTO studants VALUES (?, ?, ?);";
        try {
            Contact contact = studant.getContact();
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, studant.getName());
            preparedStatement.setString(2, studant.getCpf().getValue());
            preparedStatement.setString(3, contact.getEmail().getAddress());
            preparedStatement.execute();

            insertTelephones(contact);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void insertTelephones(Contact contact) throws SQLException {
        String sql = "INSERT INTO telephones VALUES (?, ?)";
        PreparedStatement prepareTelephone = connection.prepareStatement(sql);

        for (Telephone telephone : contact.getTelephones()) {
            prepareTelephone.setString(1, telephone.getDdd());
            prepareTelephone.setString(2, telephone.getNumber());
            prepareTelephone.execute();
        }
    }

    @Override
    public Studant findByCPF(CPF cpf) {
        String sql = "SELECT * FROM studants WHERE cpf = ?;";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, cpf.getValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            Email email = new Email(resultSet.getString("email"));
            String name = resultSet.getString("name");
            Contact contact = new Contact(email, new ArrayList<>());

            return new Studant(cpf, name, contact);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Studant> getAllRegistrations() {
        return null;
    }
}