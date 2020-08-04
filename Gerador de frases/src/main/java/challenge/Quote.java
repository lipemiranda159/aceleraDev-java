package challenge;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "scripts")
@EntityListeners(AuditingEntityListener.class)
public class Quote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="actor")
	@NotNull
	@Size(max = 100)
	private String actor;

	@Column(name = "detail")
	@NotNull
	@Size(max = 500)
	private String Quote;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getActor() {
		return this.actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getQuote() {
		return this.Quote;
	}

	public void setQuote(String quote) {
		this.Quote = quote;
	}

}
