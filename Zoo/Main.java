import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Zoologico zoologico = new Zoologico();
        int opcao = 0;

        System.out.println("Bem-vindo ao Sistema do Zoológico!");

        
        while (opcao != 6) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Adicionar animal");
            System.out.println("2. Listar todos os animais");
            System.out.println("3. Remover animal");
            System.out.println("4. Emitir som de um animal");
            System.out.println("5. Testar habilidade de um animal");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.println("\nQual tipo de animal?");
                    System.out.println("1. Gato | 2. Cachorro | 3. Passaro");
                    int tipo = scanner.nextInt();
                    
                    System.out.print("ID: ");
                    long id = scanner.nextLong();
                    scanner.nextLine();
                    
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    
                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();
                    
                    System.out.print("Peso: ");
                    double peso = scanner.nextDouble();

                    Animal novoAnimal = null;
                    if (tipo == 1) {
                        novoAnimal = new Gato(id, nome, idade, peso);
                    } else if (tipo == 2) {
                        novoAnimal = new Cachorro(id, nome, idade, peso);
                    } else if (tipo == 3) {
                        novoAnimal = new Passaro(id, nome, idade, peso);
                    } else {
                        System.out.println("Tipo inválido.");
                        break;
                    }

                    if (zoologico.adicionarAnimal(novoAnimal)) {
                        System.out.println("Animal cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro: Já existe um animal com este ID.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- Lista de Animais ---");
                    ArrayList<Animal> lista = zoologico.listarAnimais();
                    if (lista.isEmpty()) {
                        System.out.println("Nenhum animal cadastrado.");
                    } else {
                        for (Animal a : lista) {
                            System.out.println("ID: " + a.getId() + " | Nome: " + a.getNome() + 
                                               " | Idade: " + a.getIdade() + " | Peso: " + a.getPeso());
                        }
                    }
                    break;

                case 3:
                    System.out.print("\nDigite o ID do animal para remover: ");
                    long idRemover = scanner.nextLong();
                    boolean removido = zoologico.removerAnimal(idRemover);
                    System.out.println("Animal removido: " + removido);
                    break;

                case 4:
                    System.out.print("\nDigite o ID do animal para emitir som: ");
                    long idSom = scanner.nextLong();
                    Animal animalSom = zoologico.buscarAnimal(idSom);
                    if (animalSom != null) {
                        System.out.println(animalSom.getNome() + " diz " + animalSom.emitirSom());
                    } else {
                        System.out.println("Animal não encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("\nDigite o ID do animal: ");
                    long idHab = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Digite a habilidade para testar: ");
                    String habilidade = scanner.nextLine();
                    
                    Animal animalHab = zoologico.buscarAnimal(idHab);
                    if (animalHab != null) {
                        System.out.println(animalHab.realizarHabilidade(habilidade));
                    } else {
                        System.out.println("Animal não encontrado.");
                    }
                    break;

                case 6:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }
}