/*
///////////////////////////////////////////////
Isabela Teixeira e Cerqueira - 202204767
Thiago de Souza Filgueiras - 202200557
///////////////////////////////////////////////
*/

package TSFAbstract;

public class Aluno implements Estudante{

    private String nome;
    private int nMatricula;

    public Aluno(String nome, int nMatricula) {
        this.nome = nome;
        this.nMatricula = nMatricula;
    }

    public void estudar() {
        System.out.printf("O(A) aluno(a) %s está estudando...\n", this.nome);
    }

    public void fazerProva(Prova p) {
            
        int qtd_q = p.getQtd_questoes();
        int i;

        for(i = 1; i <= qtd_q; i++) {
            p.setRespostas(i, "R"+i);
        }

    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
