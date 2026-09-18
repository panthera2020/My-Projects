public class Nigeria {
    
    public String getGeoPoliticalZone(String state) {
        for(GeoPoliticalZone zone : GeoPoliticalZone.values()) {
            for(String value : zone.getStates()) {
                if(value.equalsIgnoreCase(state)) { return zone.toString(); }
            }
        }
        throw new IllegalArgumentException(state + " is not a valid state");
    }
}
