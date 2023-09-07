/*
///////////////////////////////////////////////
Isabela Teixeira e Cerqueira - 202204767
Thiago de Souza Filgueiras - 202200557
///////////////////////////////////////////////
*/

package TSFAbstract;

public class Prova {
    private int qtd_questoes;
    private String questoes[];
    private double nota;
    private String respostas[];

    public Prova(int qtd_questoes) {
        this.qtd_questoes = qtd_questoes;
        this.questoes = new String[qtd_questoes];
        for(int i = 0; i < qtd_questoes; i++) this.questoes[i] = null;
        this.nota = 0;
        this.respostas = new String[qtd_questoes];
        for(int i = 0; i < qtd_questoes; i++) this.respostas[i] = null;
    }

    public int getQtd_questoes() {
        return qtd_questoes;
    }

    public void setQtd_questoes(int qtd_questoes) {
        this.qtd_questoes = qtd_questoes;
    }

    public String getQuestoes(int num) {
        return this.questoes[num-1];
    }

    public void setQuestoes(int num, String questao) {
        this.questoes[num-1] = questao;
    }

    public double getNota() {
        return this.nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getRespostas(int num) {
        return this.respostas[num-1];
    }

    public void setRespostas(int num, String r) {
        this.respostas[num-1] = r;
    }
}
