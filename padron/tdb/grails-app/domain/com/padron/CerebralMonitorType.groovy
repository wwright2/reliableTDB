package com.padron

enum CerebralMonitorType {

    NotApplicable(0),  // Not applicable
    IntraventricularDrain(1),  // Intraventricular drain/catheter (e.g. ventriculostomy; external ventricular drain)
    IntraparenchymalPressureMonitor(2),  // Intraparenchymal pressure monitor (e.g. Camino bolt, subarachnoid bolt, intraparenchymal catheter)
    IntraparenchymalOxygenMonitor(3),  // Intraparenchymal oxygen monitor (e.g. Licox)
    JugularVenousBulb(4),  // Jugular venous bulb
    None(5)  // None

    final int value

    CerebralMonitorType(int value) {
        this.value = value
    }
}