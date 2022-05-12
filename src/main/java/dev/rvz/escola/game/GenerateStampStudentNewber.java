package dev.rvz.escola.game;

import dev.rvz.escola.game.domain.stamp.Stamp;
import dev.rvz.escola.game.domain.stamp.StampRepository;
import dev.rvz.escola.shared.domain.CPF;
import dev.rvz.escola.shared.domain.events.Event;
import dev.rvz.escola.shared.domain.events.Listenner;
import dev.rvz.escola.shared.domain.events.TypeEvent;

import java.util.Map;

public class GenerateStampStudentNewber extends Listenner {

    private final StampRepository stampRepository;

    public GenerateStampStudentNewber(StampRepository stampRepository) {
        this.stampRepository = stampRepository;
    }

    @Override
    protected void reactTo(Event event) {
        Map<String, Object> info = event.getInfo();
        CPF cpf = (CPF) info.get("CPF");
        Stamp stamp = new Stamp(cpf, "Novato");

        this.stampRepository.register(stamp);
    }

    @Override
    protected Boolean shouldProcess(Event event) {
        return event.type() == TypeEvent.STUDENT_MATRICULATED;
    }
}
