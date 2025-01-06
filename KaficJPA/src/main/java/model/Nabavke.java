package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the nabavke database table.
 * 
 */
@Entity
@NamedQuery(name="Nabavke.findAll", query="SELECT n FROM Nabavke n")
public class Nabavke implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="nabavka_id")
	private int nabavkaId;

	private double cena;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="datum_nabavke")
	private Date datumNabavke;

	private int kolicina;

	//bi-directional many-to-one association to Zaposleni
	@ManyToOne
	private Zaposleni zaposleni;

	public Nabavke() {
	}

	public int getNabavkaId() {
		return this.nabavkaId;
	}

	public void setNabavkaId(int nabavkaId) {
		this.nabavkaId = nabavkaId;
	}

	public double getCena() {
		return this.cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public Date getDatumNabavke() {
		return this.datumNabavke;
	}

	public void setDatumNabavke(Date datumNabavke) {
		this.datumNabavke = datumNabavke;
	}

	public int getKolicina() {
		return this.kolicina;
	}

	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}

	public Zaposleni getZaposleni() {
		return this.zaposleni;
	}

	public void setZaposleni(Zaposleni zaposleni) {
		this.zaposleni = zaposleni;
	}

}