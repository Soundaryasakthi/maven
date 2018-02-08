public class Countries {
    public Countries(String code,String name, String continent,String region,int population, String capital)
    {
        this.setCode(code);
        this.setName(name);
        this.setContinent(continent);
        this.setRegion(region);
        this.setPopulation(population);
        this.setCapital(capital);
    
    }
    public Countries() {}
    private String code;
    private String name;
    private String continent;
    private String region;
    private int population; 
    private String capital;
    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }
    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the continent
     */
    public String getContinent() {
        return continent;
    }
    /**
     * @param continent the continent to set
     */
    public void setContinent(String continent) {
        this.continent = continent;
    }
    /**
     * @return the region
     */
    public String getRegion() {
        return region;
    }
    /**
     * @param region the region to set
     */
    public void setRegion(String region) {
        this.region = region;
    }
    /**
     * @return the population
     */
    public int getPopulation() {
        return population;
    }
    /**
     * @param population the population to set
     */
    public void setPopulation(int population) {
        this.population = population;
    }
    /**
     * @return the capital
     */
    public String getCapital() {
        return capital;
    }
    /**
     * @param capital the capital to set
     */
    public void setCapital(String capital) {
        this.capital = capital;
    }
}