package ru.job4j.profession;

public class Diagnose extends Doctor {

    private String cold = "Cold";

    private String lupus = "Lupus";

    public void choiceIll() {

        Pacient bob = new Pacient("Bob", 25, 50);
        Diagnose required = new Diagnose();
        required.heal(bob);

    }

}
