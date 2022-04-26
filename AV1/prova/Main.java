import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        /* Sucesso: teste para médico clinico */
 
        PlanoSaude planoSaude = new PlanoSaude(true, 
                                               true,
                                               true, 
                                               true, 
                                               20000, 
                                               10000);

        Paciente paciente = new Paciente("Fabio", "A+", 20, 'M', planoSaude);  
              
        Date data = formato.parse("23/11/2015");

        Object acomodacao = new Enfermaria(5);
        Object medico = new MedicoClinicoGeral("1324", "João");
        
        AtendimentoMedicoDiario atendimentoMedico = paciente.getProntuario().criarAtendimento(acomodacao, medico);        

        atendimentoMedico.setDataAtendimento(data);
        
        try {
            atendimentoMedico.addTipoDoenca(new TipoDoenca("virose"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        atendimentoMedico.setDiagnostico("Virose com suspeita de covid");
        atendimentoMedico.setSintomas("Gripe forte");

        try {
            atendimentoMedico.addCirurgia(new CirurgiaMedica("Cirurgia Ginecológica", 3000));
            atendimentoMedico.addExame(new ExameMedico("Ultrassom de Mama", 400));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
                
        try {
            atendimentoMedico.addConsulta(new ConsultaMedica("Consulta Clinico Geral", 200));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        try {
            atendimentoMedico.addProcedimento(new ProcedimentoMedico("Mastectomia", 600));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        

        System.out.println("Deu tudo certo!");
    }        
}