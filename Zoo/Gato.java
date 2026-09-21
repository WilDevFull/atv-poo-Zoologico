public class Gato extends Animal {
    public Gato(long id, String nome, int idade, double peso) {
        super(id, nome, idade, peso); 
        this.habilidades.add("agilidade"); 
    }

    @Override 
    public String emitirSom() {
        return "miau";
    }
}