package PARCIALES.P2.P220251C.ej1;

public class OutageReportTester {
    public static void main(String[] args) {
        // Se instancia un sistema para registrar los reclamos de suministro eléctrico de CABA
        OutageSystem outageSystem = new OutageSystem();

        // Agrega una subestación a partir del nombre del barrio y el nombre de la subestación
        // Si ya existe la subestación para ese barrio no hace nada
        outageSystem.addSubstation("Flores", "FABC");
        outageSystem.addSubstation("Almagro", "AAAA");
        outageSystem.addSubstation("Flores", "FXYZ");
        outageSystem.addSubstation("Colegiales", "WXYZ");

        // Retorna los barrios con al menos una subestación, en ORDEN ALFABETICO por barrio
        // Si no se agregó ninguna subestación retorna una colección vacía
        // Esperado:
        // Almagro
        // Colegiales
        // Flores
        for (String neighborhood : outageSystem.neighborhoods()) {
            System.out.println(neighborhood);
        }

        // Retorna las subestaciones de un barrio, en ORDEN DESCENDENTE por subestación
        // Si no se agregó ninguna subestación para ese barrio retorna una colección vacía
        // Para "Flores" esperado:
        // FXYZ
        // FABC
        for (String substation : outageSystem.subStations("Flores")) {
            System.out.println(substation);
        }

        // Registra un reclamo de suministro eléctrico a partir del barrio y la subestación
        // Si el barrio no existe o la subestación no existe para ese barrio se arroja un error
        outageSystem.reportOutage("Flores", "FABC", new OutageReport(123, "Foo"));
        outageSystem.reportOutage("Flores", "FABC", new OutageReport(456, "Bar"));
        outageSystem.reportOutage("Flores", "FXYZ", new OutageReport(789, "Abc"));
        outageSystem.reportOutage("Colegiales", "WXYZ", new OutageReport(999, "Xyz"));
        outageSystem.reportOutage("Almagro", "AAAA", new OutageReport(100, "Aaa"));
        outageSystem.reportOutage("Colegiales", "WXYZ", new OutageReport(999, "Xyz"));

        // Retorna los reclamos de una subestación de un barrio, en ORDEN DE REGISTRACION
        // de reclamo (los reclamos más ANTIGUOS aparecerán primero)
        // Si el barrio no existe o la subestación no existe para ese barrio se arroja un error
        // Para ("Flores","FABC") esperado:
        // Outage reported by Foo (Account 123)
        // Outage reported by Bar (Account 456)
        for (OutageReport outageReport : outageSystem.outages("Flores", "FABC")) {
            System.out.println(outageReport);
        }

        // Retorna los reclamos, en ORDEN ALFABETICO por barrio, luego en ORDEN DESCENDENTE
        // por subestación y finalmente por ORDEN DE REGISTRACION de reclamo
        // Si no se registró ningún reclamo retorna una colección vacía
        // Esperado (formato toString):
        // Outage reported by Aaa (Account 100)
        // Outage reported by Xyz (Account 999)
        // Outage reported by Xyz (Account 999)
        // Outage reported by Abc (Account 789)
        // Outage reported by Foo (Account 123)
        // Outage reported by Bar (Account 456)
        for (OutageReport outageReport : outageSystem.outages()) {
            System.out.println(outageReport);
        }

        // Retorna los reclamos, en ORDEN DESCENDENTE por barrio, luego en ORDEN ALFABETICO
        // por subestacion y finalmente por ORDEN INVERSO DE REGISTRACION de reclamo
        // Si no se registró ningún reclamo retorna una colección vacía
        // Esperado:
        // Outage reported by Bar (Account 456)
        // Outage reported by Foo (Account 123)
        // Outage reported by Abc (Account 789)
        // Outage reported by Xyz (Account 999)
        // Outage reported by Xyz (Account 999)
        // Outage reported by Aaa (Account 100)
        for (OutageReport outageReport : outageSystem.outagesReversed()) {
            System.out.println(outageReport);
        }

        try {
            outageSystem.reportOutage("San Nicolás", "SSSS", new OutageReport(123, "Abc"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage()); // Invalid Neighborhood
        }
        try {
            outageSystem.reportOutage("Flores", "SSSS", new OutageReport(123, "Abc"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage()); // Invalid Substation in Neighborhood
        }
    }
}