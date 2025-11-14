package com.padron

enum Occupation {
    BusinessFinancialOperations(1),
    ArchitectureEngineering(2),
    CommunitySocialServices(3),
    EducationTrainingLibrary(4),
    HealthcarePractitionersTechnical(5),
    ProtectiveService(6),
    BuildingGroundsCleaningMaintenance(7),
    SalesRelated(8),
    FarmingFishingForestry(9),
    InstallationMaintenanceRepair(10),
    TransportationMaterialMoving(11),
    Management(12),
    ComputerMathematical(13),
    LifePhysicalSocialScience(14),
    Legal(15),
    ArtsDesignEntertainmentSportsMedia(16),
    HealthcareSupport(17),
    FoodPreparationServingRelated(18),
    PersonalCareService(19),
    OfficeAdministrativeSupport(20),
    ConstructionExtraction(21),
    Production(22),
    MilitarySpecific(23)

    final int value

    Occupation(int value) {
        this.value = value
    }
}