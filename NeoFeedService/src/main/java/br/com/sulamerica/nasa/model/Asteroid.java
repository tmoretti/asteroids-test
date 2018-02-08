package br.com.sulamerica.nasa.model;

public class Asteroid {

	private String referenceId;
	
	private String name;
	
	private String kmPerHour;
	
	public Asteroid() {
		
	}

	/**
	 * @param referenceId
	 * @param name
	 * @param kmPerHour
	 */
	public Asteroid(String referenceId, String name, String kmPerHour) {
		super();
		this.referenceId = referenceId;
		this.name = name;
		this.kmPerHour = kmPerHour;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKmPerHour() {
		return kmPerHour;
	}

	public void setKmPerHour(String kmPerHour) {
		this.kmPerHour = kmPerHour;
	}
	
    @Override
    public String toString() {
        return String.format(
                "Asteroid [referenceId=%s, name=%s, kmPerHour=%s]",
                referenceId, name, kmPerHour);
    }
}
