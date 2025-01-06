package model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the narudzbine database table.
 * 
 */
@Entity
@NamedQuery(name = "Narudzbine.findAll", query = "SELECT n FROM Narudzbine n")
public class Narudzbine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "narudzbina_id")
	private int narudzbinaId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datum_narudzbine")
	private LocalDateTime datumNarudzbine;

	// bi-directional many-to-one association to Detaljiporudbine
	@OneToMany(mappedBy = "narudzbine")
	private List<Detaljiporudbine> detaljiporudbines;

	// bi-directional many-to-one association to Stolovi
	@ManyToOne
	@JoinColumn(name = "sto_id")
	private Stolovi stolovi;

	// bi-directional many-to-one association to Zaposleni
	@ManyToOne
	private Zaposleni zaposleni;

	@Column(name = "spremno")
	private boolean spremno;

	public Narudzbine() {
	}

	public boolean isSpremno() {
		return spremno;
	}

	public void setSpremno(boolean spremno) {
		this.spremno = spremno;
	}

	public int getNarudzbinaId() {
		return this.narudzbinaId;
	}

	public void setNarudzbinaId(int narudzbinaId) {
		this.narudzbinaId = narudzbinaId;
	}

	public LocalDateTime getDatumNarudzbine() {
		return this.datumNarudzbine;
	}

	public void setDatumNarudzbine(LocalDateTime datumNarudzbine) {
		this.datumNarudzbine = datumNarudzbine;
	}

	public List<Detaljiporudbine> getDetaljiporudbines() {
		return this.detaljiporudbines;
	}

	public void setDetaljiporudbines(List<Detaljiporudbine> detaljiporudbines) {
		this.detaljiporudbines = detaljiporudbines;
	}

	public Detaljiporudbine addDetaljiporudbine(Detaljiporudbine detaljiporudbine) {
		getDetaljiporudbines().add(detaljiporudbine);
		detaljiporudbine.setNarudzbine(this);

		return detaljiporudbine;
	}

	public Detaljiporudbine removeDetaljiporudbine(Detaljiporudbine detaljiporudbine) {
		getDetaljiporudbines().remove(detaljiporudbine);
		detaljiporudbine.setNarudzbine(null);

		return detaljiporudbine;
	}

	public Stolovi getStolovi() {
		return this.stolovi;
	}

	public void setStolovi(Stolovi stolovi) {
		this.stolovi = stolovi;
	}

	public Zaposleni getZaposleni() {
		return this.zaposleni;
	}

	public void setZaposleni(Zaposleni zaposleni) {
		this.zaposleni = zaposleni;
	}

}