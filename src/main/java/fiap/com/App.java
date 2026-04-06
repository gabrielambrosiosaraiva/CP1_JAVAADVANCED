package fiap.com;

import jakarta.persistence.*;
import dao.FuncionarioDAO;
import model.*;
import util.GeradorSQL;

public class App {

    public static void main(String[] args) {

        System.out.println("#$%#$%#$%#$%#$%#$%#$%#$%#$%#$%#$%#$%#$%#$%");
        System.out.println("          JAVA ADVANCED");
        System.out.println("           CHECKPOINT 1");
        System.out.println("#$%#$%#$%#$%#$%#$%#$%#$%#$%#$%#$%#$%#$%#$%\n");

        System.out.println("GABRIEL AMBROSIO SARAIVA - RM 566552 - 2TDSPV-2026");
        System.out.println("JAO VICTOR VENDRAMETO    - RM 563665 - 2TDSPV-2026");

        System.out.println("\n#$%#$%#$%#$%#$%#$%#$%#$%#$%#$%#$%#$%#$%#$%\n");

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("conexao");

        EntityManager em = emf.createEntityManager();

        FuncionarioDAO dao = new FuncionarioDAO(em);

        // Calmaaa => CRIANDO FUNCIONÁRIOS
        FuncionarioJunior j1 = new FuncionarioJunior();
        j1.setNome("Lucas Silva");
        j1.setHorasTrabalhadas(40);
        j1.setValorHora(70);
        dao.salvar(j1);

        FuncionarioJunior j2 = new FuncionarioJunior();
        j2.setNome("Pedro Santos");
        j2.setHorasTrabalhadas(40);
        j2.setValorHora(70);
        dao.salvar(j2);

        FuncionarioJunior j3 = new FuncionarioJunior();
        j3.setNome("Rafael Lima");
        j3.setHorasTrabalhadas(40);
        j3.setValorHora(70);
        dao.salvar(j3);

        FuncionarioFreelancer freelancer = new FuncionarioFreelancer();
        freelancer.setNome("Mariana Costa");
        freelancer.setHorasTrabalhadas(100);
        freelancer.setValorHora(80);

        dao.salvar(freelancer);

        FuncionarioPleno pleno = new FuncionarioPleno();
        pleno.setNome("Ana Souza");
        pleno.setHorasTrabalhadas(40);
        pleno.setValorHora(80);
        dao.salvar(pleno);

        FuncionarioSenior senior = new FuncionarioSenior();
        senior.setNome("Carlos Pereira");
        senior.setHorasTrabalhadas(45);
        senior.setValorHora(90);
        dao.salvar(senior);

        FuncionarioTemporario temp = new FuncionarioTemporario();
        temp.setNome("João Oliveira");
        temp.setHorasTrabalhadas(20);
        temp.setValorHora(70);
        dao.salvar(temp);

        //Tranquilo =>LISTA INICIAL
        System.out.println("ANTES DAS MUDANCAS:");

        em.createQuery("from Funcionario", Funcionario.class)
                .getResultList()
                .forEach(f -> System.out.println(f.mostrarInformacoes()));

        //Tranquiloo PROMOÇÃO (j1 vira pleno)
        FuncionarioPleno promovido = new FuncionarioPleno();
        promovido.setNome(j1.getNome());
        promovido.setHorasTrabalhadas(j1.getHorasTrabalhadas());
        promovido.setValorHora(80);

        dao.deletar(j1);     // remove junior
        dao.salvar(promovido); // cria como pleno

        // Calmaaa => DEMISSÃO (j2)
        dao.deletar(j2);

        // Tranquilooo ==> LISTA FINAL
        System.out.println("\nDEPOIS DAS MUDANCAS:");

        em.createQuery("from Funcionario", Funcionario.class)
                .getResultList()
                .forEach(f -> System.out.println(f.mostrarInformacoes()));

        //Tranquilo =>REFLECTION
        System.out.println("\n" + GeradorSQL.gerarSelect(Funcionario.class));

        em.close();
        emf.close();
    }
}