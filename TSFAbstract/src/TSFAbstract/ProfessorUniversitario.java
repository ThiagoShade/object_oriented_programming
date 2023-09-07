/*
///////////////////////////////////////////////
Isabela Teixeira e Cerqueira - 202204767
Thiago de Souza Filgueiras - 202200557
///////////////////////////////////////////////
*/

package TSFAbstract;

public class ProfessorUniversitario extends Professor {

    public ProfessorUniversitario(String nome, int nTurmas, double salario) {
        super(nome, nTurmas, salario);
    }
    
    public Prova[] elaborarProvas() {
        Prova p[];

        p = new Prova[3];

        for (int i = 0; i < 3; i++) p[i] = new Prova(2);

        for(int i = 0; i < 3; i++) {
            for(int j = 1; j <= 2; j++) {
                p[i].setQuestoes(j, "P"+(i+1)+"Q"+j);
            }
        
        }

        return p;
    }
}
