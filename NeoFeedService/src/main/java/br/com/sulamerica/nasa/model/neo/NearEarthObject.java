package br.com.sulamerica.nasa.model.neo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.sulamerica.nasa.model.Links;

public final class NearEarthObject {

    private Links links;
    @JsonProperty("neo_reference_id")
    private String neoReferenceid;
    private String name;
    @JsonProperty("nasa_jpl_url")
    private String nasaJplUrl;
    @JsonProperty("absolute_magnitude_h")
    private double absoluteMagnitudeH;
    @JsonProperty("estimated_diameter")
    private EstimatedDiameter estimatedDiameter;
    @JsonProperty("is_potentially_hazardous_asteroid")
    private boolean potentiallyHazardousAsteroid;
    @JsonProperty("close_approach_data")
    private List<CloseApproach> closeApproachData;
    @JsonProperty("orbital_data")
    private OrbitalData orbitalData;

    public Links getLinks() {
        return links;
    }

    public String getNeoReferenceid() {
        return neoReferenceid;
    }

    public String getName() {
        return name;
    }

    public String getNasaJplUrl() {
        return nasaJplUrl;
    }

    public double getAbsoluteMagnitudeH() {
        return absoluteMagnitudeH;
    }

    public EstimatedDiameter getEstimatedDiameter() {
        return estimatedDiameter;
    }

    public boolean isPotentiallyHazardousAsteroid() {
        return potentiallyHazardousAsteroid;
    }

    public List<CloseApproach> getCloseApproachData() {
        return closeApproachData;
    }

    public OrbitalData getOrbitalData() {
        return orbitalData;
    }

    public static final class MissDistance {

        private String astronomical;
        private String lunar;
        private String kilometers;
        private String miles;

        public String getAstronomical() {
            return astronomical;
        }

        public String getLunar() {
            return lunar;
        }

        public String getKilometers() {
            return kilometers;
        }

        public String getMiles() {
            return miles;
        }
    }

    public static final class CloseApproach {

        @JsonProperty("close_approach_date")
        private String closeApproachDate;
        @JsonProperty("epoch_date_close_approach")
        private long epochDateCloseApproach;
        @JsonProperty("relative_velocity")
        private RelativeVelocity relativeVelocity;
        @JsonProperty("miss_distance")
        private MissDistance missDistance;
        @JsonProperty("orbiting_body")
        private String orbitingBody;

        public String getCloseApproachDate() {
            return closeApproachDate;
        }

        public long getEpochDateCloseApproach() {
            return epochDateCloseApproach;
        }

        public RelativeVelocity getRelativeVelocity() {
            return relativeVelocity;
        }

        public MissDistance getMissDistance() {
            return missDistance;
        }

        public String getOrbitingBody() {
            return orbitingBody;
        }
    }

    public static final class EstimatedDiameter {

        private EstimatedDiameterUnit kilometers;
        private EstimatedDiameterUnit meters;
        private EstimatedDiameterUnit miles;
        private EstimatedDiameterUnit feet;

        public EstimatedDiameterUnit getKilometers() {
            return kilometers;
        }

        public EstimatedDiameterUnit getMeters() {
            return meters;
        }

        public EstimatedDiameterUnit getMiles() {
            return miles;
        }

        public EstimatedDiameterUnit getFeet() {
            return feet;
        }

        public static final class EstimatedDiameterUnit {

            @JsonProperty("estimated_diameter_min")
            private String estimatedDiameterMin;
            @JsonProperty("estimated_diameter_max")
            private String estimatedDiameterMax;

            public String getEstimatedDiameterMin() {
                return estimatedDiameterMin;
            }

            public String getEstimatedDiameterMax() {
                return estimatedDiameterMax;
            }
        }
    }

    public static final class OrbitalData {

        @JsonProperty("orbit_id")
        private String orbitId;
        @JsonProperty("orbit_determination_date")
        private String orbitDeterminationDate;
        @JsonProperty("orbit_uncertainty")
        private String orbitUncertainty;
        @JsonProperty("minimum_orbit_intersection")
        private String minimumOrbitIntersection;
        @JsonProperty("jupiter_tisserand_invariant")
        private String jupiterTisserandInvariant;
        @JsonProperty("epoch_osculation")
        private String epochOsculation;
        @JsonProperty("eccentricity")
        private String eccentricity;
        @JsonProperty("semi_major_axis")
        private String semiMajorAxis;
        private String inclination;
        @JsonProperty("ascending_node_longitude")
        private String ascendingNodeLongitude;
        @JsonProperty("orbital_period")
        private String orbitalPeriod;
        @JsonProperty("perihelion_distance")
        private String perihelionDistance;
        @JsonProperty("perihelion_argument")
        private String perihelionArgument;
        @JsonProperty("aphelion_distance")
        private String aphelionDistance;
        @JsonProperty("perihelion_time")
        private String perihelionTime;
        @JsonProperty("mean_anomaly")
        private String meanAnomaly;
        @JsonProperty("mean_motion")
        private String meanMotion;
        private String equinox;

        public String getOrbitId() {
            return orbitId;
        }

        public String getOrbitDeterminationDate() {
            return orbitDeterminationDate;
        }

        public String getOrbitUncertainty() {
            return orbitUncertainty;
        }

        public String getMinimumOrbitIntersection() {
            return minimumOrbitIntersection;
        }

        public String getJupiterTisserandInvariant() {
            return jupiterTisserandInvariant;
        }

        public String getEpochOsculation() {
            return epochOsculation;
        }

        public String getEccentricity() {
            return eccentricity;
        }

        public String getSemiMajorAxis() {
            return semiMajorAxis;
        }

        public String getInclination() {
            return inclination;
        }

        public String getAscendingNodeLongitude() {
            return ascendingNodeLongitude;
        }

        public String getOrbitalPeriod() {
            return orbitalPeriod;
        }

        public String getPerihelionDistance() {
            return perihelionDistance;
        }

        public String getPerihelionArgument() {
            return perihelionArgument;
        }

        public String getAphelionDistance() {
            return aphelionDistance;
        }

        public String getPerihelionTime() {
            return perihelionTime;
        }

        public String getMeanAnomaly() {
            return meanAnomaly;
        }

        public String getMeanMotion() {
            return meanMotion;
        }

        public String getEquinox() {
            return equinox;
        }
    }

    public static final class RelativeVelocity {

        @JsonProperty("kilometers_per_second")
        private String kilometersPerSecond;
        @JsonProperty("kilometers_per_hour")
        private String kilometersPerHour;
        @JsonProperty("miles_per_hour")
        private String milesPerHour;

        public String getKilometersPerSecond() {
            return kilometersPerSecond;
        }

        public String getKilometersPerHour() {
            return kilometersPerHour;
        }

        public String getMilesPerHour() {
            return milesPerHour;
        }
    }
}