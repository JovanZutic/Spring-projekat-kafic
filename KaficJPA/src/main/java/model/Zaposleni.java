package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the zaposleni database table.
 * 
 */
@Entity
@NamedQuery(name="Zaposleni.findAll", query="SELECT z FROM Zaposleni z")
public class Zaposleni implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="zaposleni_id")
	private int zaposleniId;

	private String ime;

	private String password;

	private String prezime;

	private String uloga;

	private String username;

	//bi-directional many-to-one association to Nabavke
	@OneToMany(mappedBy="zaposleni")
	private List<Nabavke> nabavkes;

	//bi-directional many-to-one association to Narudzbine
	@OneToMany(mappedBy="zaposleni")
	private List<Narudzbine> narudzbines;

	public Zaposleni() {
	}

	public int getZaposleniId() {
		return this.zaposleniId;
	}

	public void setZaposleniId(int zaposleniId) {
		this.zaposleniId = zaposleniId;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getUloga() {
		return this.uloga;
	}

	public void setUloga(String uloga) {
		this.uloga = uloga;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Nabavke> getNabavkes() {
		return this.nabavkes;
	}

	public void setNabavkes(List<Nabavke> nabavkes) {
		this.nabavkes = nabavkes;
	}

	public Nabavke addNabavke(Nabavke nabavke) {
		getNabavkes().add(nabavke);
		nabavke.setZaposleni(this);

		return nabavke;
	}

	public Nabavke removeNabavke(Nabavke nabavke) {
		getNabavkes().remove(nabavke);
		nabavke.setZaposleni(null);

		return nabavke;
	}

	public List<Narudzbine> getNarudzbines() {
		return this.narudzbines;
	}

	public void setNarudzbines(List<Narudzbine> narudzbines) {
		this.narudzbines = narudzbines;
	}

	public Narudzbine addNarudzbine(Narudzbine narudzbine) {
		getNarudzbines().add(narudzbine);
		narudzbine.setZaposleni(this);

		return narudzbine;
	}

	public Narudzbine removeNarudzbine(Narudzbine narudzbine) {
		getNarudzbines().remove(narudzbine);
		narudzbine.setZaposleni(null);

		return narudzbine;
	}

}