import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

public class SpeciesList {
	private final ArrayList<Species> speciesList;

	public SpeciesList() {
		this.speciesList = retrieveSpecies();
	}

	public ArrayList<Species> getSpeciesList() {
		return speciesList;
	}

	public Species getSpecies(int i){
		return speciesList.get(i);
	}

	public Optional<Species> getSpecies(String name){
		return speciesList.stream()
				.filter(s -> s.getName().equals(name))
				.findFirst();
	}

	public boolean addSpecies(Species species){
		if(DBInterface.add(species.toString())){
			speciesList.add(species);
			return true;
		}

		return false;
	}

	private ArrayList<Species> retrieveSpecies() {
		ArrayList<Species> speciesList = new ArrayList<>();

		for(Map.Entry<String, Map<String, String>> entry : DBInterface.select("species").entrySet()) {
			Map<String, String> speciesMap = entry.getValue();

			Species species = new Species(speciesMap.get("name"), speciesMap.get("info"), speciesMap.get("food"), Integer.parseInt(speciesMap.get("amount")));
			speciesList.add(species);
		}

		return speciesList;
	}

}
