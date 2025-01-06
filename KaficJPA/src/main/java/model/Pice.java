package model;

import java.io.Serializable;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the pice database table.
 * 
 */
@Entity
@NamedQuery(name="Pice.findAll", query="SELECT p FROM Pice p")
public class Pice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pice_id")
	private int piceId;

	private double cena;

	private String naziv;

	private String opis;

	private String slika;

	//bi-directional many-to-one association to Detaljiporudbine
	@OneToMany(mappedBy="pice")
	private List<Detaljiporudbine> detaljiporudbines;

	//bi-directional many-to-one association to Magacin
	@OneToMany(mappedBy="pice")
	private List<Magacin> magacins = new ArrayList<Magacin>();

	//bi-directional many-to-one association to Kategorijepica
	@ManyToOne
	@JoinColumn(name="kategorija_id")
	private Kategorijepica kategorijepica;

	public Pice() {
	}

	public int getPiceId() {
		return this.piceId;
	}

	public void setPiceId(int piceId) {
		this.piceId = piceId;
	}

	public double getCena() {
		return this.cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getSlika() {
		return this.slika;
	}

	public void setSlika(String slika) {
		this.slika = slika;
	}

	public List<Detaljiporudbine> getDetaljiporudbines() {
		return this.detaljiporudbines;
	}

	public void setDetaljiporudbines(List<Detaljiporudbine> detaljiporudbines) {
		this.detaljiporudbines = detaljiporudbines;
	}

	public Detaljiporudbine addDetaljiporudbine(Detaljiporudbine detaljiporudbine) {
		getDetaljiporudbines().add(detaljiporudbine);
		detaljiporudbine.setPice(this);

		return detaljiporudbine;
	}

	public Detaljiporudbine removeDetaljiporudbine(Detaljiporudbine detaljiporudbine) {
		getDetaljiporudbines().remove(detaljiporudbine);
		detaljiporudbine.setPice(null);

		return detaljiporudbine;
	}

	public List<Magacin> getMagacins() {
		return this.magacins;
	}

	public void setMagacins(List<Magacin> magacins) {
		this.magacins = magacins;
	}

	public Magacin addMagacin(Magacin magacin) {
		getMagacins().add(magacin);
		magacin.setPice(this);

		return magacin;
	}

	public Magacin removeMagacin(Magacin magacin) {
		getMagacins().remove(magacin);
		magacin.setPice(null);

		return magacin;
	}

	public Kategorijepica getKategorijepica() {
		return this.kategorijepica;
	}

	public void setKategorijepica(Kategorijepica kategorijepica) {
		this.kategorijepica = kategorijepica;
	}

}