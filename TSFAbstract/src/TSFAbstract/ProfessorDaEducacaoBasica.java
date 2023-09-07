/*
///////////////////////////////////////////////
Isabela Teixeira e Cerqueira - 202204767
Thiago de Souza Filgueiras - 202200557
///////////////////////////////////////////////
*/

package TSFAbstract;

public class ProfessorDaEducacaoBasica extends Professor {

    public ProfessorDaEducacaoBasica(String nome, int nTurmas, double salario) {
        super(nome, nTurmas, salario);
    }

    public Prova[] elaborarProvas() {
        Prova p[];
        p = new Prova[4];

        for(int i = 0; i < 4; i++) p[i] = new Prova(5);

        for(int i = 0; i < 4; i++) {
            for(int j = 1; j <= 5; j++) {
                p[i].setQuestoes(j, "P"+(i+1)+"Q"+j);
            }
        
        }

        return p;
    }
    
}
