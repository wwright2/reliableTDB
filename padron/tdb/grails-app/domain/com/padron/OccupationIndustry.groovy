package com.padron

enum OccupationIndustry {

    FinanceInsuranceRealEstate(1),
    Manufacturing(2),
    RetailTrade(3),
    TransportationPublicUtilities(4),
    AgricultureForestryFishing(5),
    ProfessionalBusinessServices(6),
    EducationHealthServices(7),
    Construction(8),
    Government(9),
    NaturalResourcesMining(10),
    InformationServices(11),
    WholesaleTrade(12),
    LeisureHospitality(13),
    OtherServices(14)

    final int value

    OccupationIndustry(int value) {
        this.value = value
    }
}