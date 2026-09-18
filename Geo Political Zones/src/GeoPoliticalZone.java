public enum GeoPoliticalZone {
    NORTHCENTRAL("BENUE","KOGI","FCT","KWARA","NASARAWA","NIGER","PLATEAU"),
    NORTHEAST("ADAMAWA","BAUCHI","BORNO","GOMBE","TARABA","YOBE"),
    NORTHWEST("SOKOTO","ZAMFARA","KATSINA","KEBBI","JIGAWA","KADUNA","KANO"),
    SOUTHEAST("ABIA","ANAMBRA","EBONYI","ENUGU","IMO"),
    SOUTHWEST("EKITI","LAGOS","OGUN","ONDO","OSUN","OYO"),
    SOUTHSOUTH("AKWA IBOM","BAYELSA","CROSS RIVER","DELTA","EDO","RIVERS");

    private final String[] states;

    GeoPoliticalZone(String... states) {
        this.states = states;
    }

    public String[] getStates() {
        return states;
    }
}
