package model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the detaljiporudbine database table.
 * 
 */
@Entity
@NamedQuery(name="Detaljiporudbine.findAll", query="SELECT d FROM Detaljiporudbine d")
public class Detaljiporudbine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int detaljiPorudbine_id;

	private int kolicina;

	//bi-directional many-to-one association to Narudzbine
	@ManyToOne
	private Narudzbine narudzbine;

	//bi-directional many-to-one association to Pice
	@ManyToOne
	private Pice pice;

	public Detaljiporudbine() {
	}

	public int getDetaljiPorudbine_id() {
		return this.detaljiPorudbine_id;
	}

	public void setDetaljiPorudbine_id(int detaljiPorudbine_id) {
		this.detaljiPorudbine_id = detaljiPorudbine_id;
	}

	public int getKolicina() {
		return this.kolicina;
	}

	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}

	public Narudzbine getNarudzbine() {
		return this.narudzbine;
	}

	public void setNarudzbine(Narudzbine narudzbine) {
		this.narudzbine = narudzbine;
	}

	public Pice getPice() {
		return this.pice;
	}

	public void setPice(Pice pice) {
		this.pice = pice;
	}

}