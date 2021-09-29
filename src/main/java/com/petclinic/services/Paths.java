package com.petclinic.services;

public class Paths {
    public static final String VETS = "/vets";
    public static final String VET = "$VETS/{vetId}";
    public static final String PETS = "/pets";
    public static final String PET = "$PETS/{id}";
    public static final String PET_TYPE = "/pettypes/{petTypeId}";
    public static final String OWNERS = "/owners";
    public static final String OWNER = "$OWNERS/{ownerId}";
    public static final String VISITS = "/visits";
    public static final String VISIT = "$VISITS/{visitId}";
}
