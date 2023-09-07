/*
///////////////////////////////////////////////
Isabela Teixeira e Cerqueira - 202204767
Thiago de Souza Filgueiras - 202200557
///////////////////////////////////////////////
*/

package TSFAbstract;

public abstract class Professor implements FuncionarioAssalariado, Estudante {
    private String nome;
    private int nTurmas;
    private double salario;

    public Professor(String nome, int nTurmas, double salario) {
        this.nome = nome;
        this.nTurmas = nTurmas;
        this.salario = salario;
    }

    public abstract Prova[] elaborarProvas();

    public void estudar() {
        System.out.printf("O(A) professor(a) %s está estudando...\n", this.nome);
    }

    public void receberSalario(int nTurmas) {
        System.out.printf("O(A) professor(a) %s irá receber um salário de %lf\n", this.nome, this.salario + (this.nTurmas * this.salario * 0.05));
    }

    public double corrigirProva(Prova p) {

        double n = 0;
        int qtd_q = p.getQtd_questoes();
        String r;

        for(int i = 1; i <= qtd_q; i++) {
            r = p.getRespostas(i);
            if(r.compareTo("R"+i) == 0) {
                n += 10/qtd_q;
            }
        
        }

        p.setNota(n);
        
        return n;
    }
}
