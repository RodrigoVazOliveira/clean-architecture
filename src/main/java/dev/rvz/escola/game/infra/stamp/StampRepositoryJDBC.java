package dev.rvz.escola.game.infra.stamp;

import dev.rvz.escola.game.domain.stamp.Stamp;
import dev.rvz.escola.game.domain.stamp.StampRepository;
import dev.rvz.escola.academic.domain.student.CPF;

import javax.persistence.EntityManager;

public class StampRepositoryJDBC implements StampRepository {

    private final EntityManager entityManager;

    public StampRepositoryJDBC(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Stamp register(Stamp stamp) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(stamp);
        this.entityManager.getTransaction().commit();

        return stamp;
    }

    @Override
    public Stamp findByCPF(CPF cpf) {
        Stamp stamp = this.entityManager.find(Stamp.class, cpf);

        return stamp;
    }
}
