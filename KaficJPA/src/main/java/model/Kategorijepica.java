package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the kategorijepica database table.
 * 
 */
@Entity
@NamedQuery(name="Kategorijepica.findAll", query="SELECT k FROM Kategorijepica k")
public class Kategorijepica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="kategorija_id")
	private int kategorijaId;

	private String naziv;

	//bi-directional many-to-one association to Pice
	@OneToMany(mappedBy="kategorijepica")
	private List<Pice> pices;

	public Kategorijepica() {
	}

	public int getKategorijaId() {
		return this.kategorijaId;
	}

	public void setKategorijaId(int kategorijaId) {
		this.kategorijaId = kategorijaId;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Pice> getPices() {
		return this.pices;
	}

	public void setPices(List<Pice> pices) {
		this.pices = pices;
	}

	public Pice addPice(Pice pice) {
		getPices().add(pice);
		pice.setKategorijepica(this);

		return pice;
	}

	public Pice removePice(Pice pice) {
		getPices().remove(pice);
		pice.setKategorijepica(null);

		return pice;
	}

}