package rs.ac.uns.ftn.informatika.validation.domain;

import org.hibernate.validator.constraints.NotEmpty;

import rs.ac.uns.ftn.informatika.validation.validator.CustomAnnotation;

public class Greeting {
	
    private Long id;
    
//    @CustomAnnotation <-validacija. inace:
    @NotEmpty(message = "Poruka je obavezna.")
    private String text;

    public Greeting() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
