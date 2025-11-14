package com.padron

enum AirbagDeployType {

    AirbagNotDeployed(1),
    AirbagDeployedFront(2),
    AirbagDeployedSide(3),
    AirbagDeployedOther(4)

    final int value

    AirbagDeployType(int value) {
        this.value = value
    }
}