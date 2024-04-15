package tdd.exercice.Person;

import java.util.ArrayList;
import java.util.List;

import tdd.exercice.Email.Email;

public class PersonDAO {

    public void save(Person p){

    }

    public List<String> isValidToInclude(Person p){
        List<String> errors = new ArrayList<>();

        if(p.getName() == null || !p.getName().matches("[a-zA-Z]+ [a-zA-Z]+")){
            errors.add("O nome deve ser composto por ao menos 2 partes e deve ser composto de letras");
        } else if(p.getAge() < 1 || p.getAge() > 200){
            errors.add("A idade deve estar no intervalo [1, 200]");
        } else if(p.getEmails() == null || p.getEmails().isEmpty()){
            errors.add("O objeto Person deve ter pelo menos um objeto da classe Email associado");
        }
        for (Email email : p.getEmails()) {
            if (!email.getName().matches("[^@]+@[^.]+\\.[^.]+")) {
                errors.add("O email '" + email.getName() + "' não está no formato válido");
            }
        }
        return errors;
    }

}
