/*
///////////////////////////////////////////////
Isabela Teixeira e Cerqueira - 202204767
Thiago de Souza Filgueiras - 202200557
///////////////////////////////////////////////
*/

package TSFAbstract;

public class Principal {
    public static void main(String args[]) {
        
        Professor maria = new ProfessorUniversitario("Maria", 2, 3000);
        Professor jose = new ProfessorDaEducacaoBasica("Jose", 3, 2000);
        Aluno thiago = new Aluno("Thiago", 202200557);
        Aluno isabela = new Aluno("Isabela", 202204767);

        Estudante[] pessoasQueEstudam = new Estudante[4];
        pessoasQueEstudam[0] = maria;
        pessoasQueEstudam[1] = jose;
        pessoasQueEstudam[2] = thiago;
        pessoasQueEstudam[3] = isabela;

        for(Estudante estudante: pessoasQueEstudam) estudante.estudar();

        Prova[] provasDaFaculdade = maria.elaborarProvas();

        thiago.fazerProva(provasDaFaculdade[0]);
        maria.corrigirProva(provasDaFaculdade[0]);
        
        isabela.fazerProva(provasDaFaculdade[1]);
        maria.corrigirProva(provasDaFaculdade[1]);

        System.out.printf("O(A) aluno(a) %s tirou %.2f na prova\n", thiago.getNome(), provasDaFaculdade[0].getNota());
        System.out.printf("O(A) aluno(a) %s tirou %.2f na prova\n", isabela.getNome(), provasDaFaculdade[1].getNota());
    }
}
