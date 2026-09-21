public class Passaro extends Animal {
    public Passaro(long id, String nome, int idade, double peso) {
        super(id, nome, idade, peso);
        this.habilidades.add("voar");
    }

    @Override
    public String emitirSom() {
        return "piu";
    }
}