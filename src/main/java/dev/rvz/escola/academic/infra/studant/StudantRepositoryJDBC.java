package dev.rvz.escola.academic.infra.studant;

import dev.rvz.escola.academic.domain.student.CPF;
import dev.rvz.escola.academic.domain.student.Studant;
import dev.rvz.escola.academic.domain.student.StudantRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class StudantRepositoryJDBC implements StudantRepository {

    private final EntityManager entityManager;

    public StudantRepositoryJDBC(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void registration(Studant studant) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(studant);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public Studant findByCPF(CPF cpf) {
        Studant studant = this.entityManager.find(Studant.class, cpf);
        if (studant == null) {
            throw new RuntimeException("Student not found with cpf " + cpf.getValue());
        }

        return studant;
    }

    @Override
    public List<Studant> getAllRegistrations() {
        TypedQuery<Studant> query = this.entityManager.createQuery("SELECT s FROM studant s", Studant.class);
        List<Studant> resultList = query.getResultList();

        return resultList;
    }
}