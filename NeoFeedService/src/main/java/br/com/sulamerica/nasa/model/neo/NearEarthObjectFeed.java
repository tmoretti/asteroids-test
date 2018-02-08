package br.com.sulamerica.nasa.model.neo;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.sulamerica.nasa.model.Links;

public final class NearEarthObjectFeed {

    private Links links;
    @JsonProperty("element_count")
    private int elementCount;
    @JsonProperty("near_earth_objects")
    private Map<String, List<NearEarthObject>> nearEarthObjects;

    public Links getLinks() {
        return links;
    }

    public int getElementCount() {
        return elementCount;
    }

    public Map<String, List<NearEarthObject>> getNearEarthObjects() {
        return nearEarthObjects;
    }
}