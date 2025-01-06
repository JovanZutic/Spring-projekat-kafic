package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the stolovi database table.
 * 
 */
@Entity
@NamedQuery(name="Stolovi.findAll", query="SELECT s FROM Stolovi s")
public class Stolovi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sto_id")
	private int stoId;

	@Column(name="broj_stola")
	private int brojStola;

	private String status;

	//bi-directional many-to-one association to Narudzbine
	@OneToMany(mappedBy="stolovi")
	private List<Narudzbine> narudzbines;

	public Stolovi() {
	}

	public int getStoId() {
		return this.stoId;
	}

	public void setStoId(int stoId) {
		this.stoId = stoId;
	}

	public int getBrojStola() {
		return this.brojStola;
	}

	public void setBrojStola(int brojStola) {
		this.brojStola = brojStola;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Narudzbine> getNarudzbines() {
		return this.narudzbines;
	}

	public void setNarudzbines(List<Narudzbine> narudzbines) {
		this.narudzbines = narudzbines;
	}

	public Narudzbine addNarudzbine(Narudzbine narudzbine) {
		getNarudzbines().add(narudzbine);
		narudzbine.setStolovi(this);

		return narudzbine;
	}

	public Narudzbine removeNarudzbine(Narudzbine narudzbine) {
		getNarudzbines().remove(narudzbine);
		narudzbine.setStolovi(null);

		return narudzbine;
	}

}