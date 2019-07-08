package ru.job4j.profession;

public class Doctor extends Profession {

    private String nameOfClinic;

    public Diagnose heal(Pacient pacient) {

        Diagnose cold = new Diagnose();
        return cold;
    }

}
