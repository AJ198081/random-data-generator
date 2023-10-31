package dev.aj.randomdatagenerator.entities;

import org.springframework.stereotype.Component;

@Component
public class StaticData {

    public static final String PREFIX = "{\n" +
            "  \"custodianId\": \"GUILDSUPER\",\n" +
            "  \"emailDetails\": ";

    public static final String SUFFIX = ", \"emailPreferences\": {\n" +
            "    \"sortBy\": \"emailDistributionTime\",\n" +
            "    \"stickyHeader\": true,\n" +
            "    \"stickyFooter\": true,\n" +
            "    \"pagination\": true,\n" +
            "    \"globalFiltering\": true,\n" +
            "    \"densityToggle\": true,\n" +
            "    \"columnResizing\": {\n" +
            "      \"mrtRowExpand\": 125,\n" +
            "      \"mrtRowActions\": 70,\n" +
            "      \"emailStatus\": 80,\n" +
            "      \"emailDescription\": 230,\n" +
            "      \"emailDestination\": 230,\n" +
            "      \"emailDistributionTime\": 110,\n" +
            "      \"employeePayrollId\": 170,\n" +
            "      \"employeeFirstName\": 150,\n" +
            "      \"employeeLastName\": 150,\n" +
            "      \"employeeDob\": 145,\n" +
            "      \"employeeEmailAddress\": 180,\n" +
            "      \"employerName\": 180,\n" +
            "      \"emailSubject\": 400,\n" +
            "      \"employerAbn\": 170,\n" +
            "      \"emailCcDestination\": 150\n" +
            "    },\n" +
            "    \"columnPinning\": {\n" +
            "      \"left\": [\n" +
            "        \"mrt-row-expand\",\n" +
            "        \"mrt-row-actions\"\n" +
            "      ],\n" +
            "      \"right\": [\n" +
            "        \"\"\n" +
            "      ]\n" +
            "    },\n" +
            "    \"columnFiltering\": true,\n" +
            "    \"columnOrdering\": true,\n" +
            "    \"columnOrder\": [\n" +
            "      \"mrt-row-expand\",\n" +
            "      \"mrt-row-actions\",\n" +
            "      \"emailStatus\",\n" +
            "      \"emailDescription\",\n" +
            "      \"emailDestination\",\n" +
            "      \"emailDistributionTime\",\n" +
            "      \"employeePayrollId\",\n" +
            "      \"employeeFirstName\",\n" +
            "      \"employeeLastName\",\n" +
            "      \"employeeDob\",\n" +
            "      \"employeeEmailAddress\",\n" +
            "      \"employerName\",\n" +
            "      \"emailSubject\",\n" +
            "      \"employerAbn\",\n" +
            "      \"emailCcDestination\"\n" +
            "    ],\n" +
            "    \"fullScreenToggle\": true,\n" +
            "    \"sorting\": [\n" +
            "      {\n" +
            "        \"id\": \"emailDistributionTime\",\n" +
            "        \"desc\": true\n" +
            "      }\n" +
            "    ],\n" +
            "    \"columnActions\": true,\n" +
            "    \"columnVisibility\": {\n" +
            "      \"mrtRowExpand\": true,\n" +
            "      \"mrtRowActions\": true,\n" +
            "      \"emailStatus\": true,\n" +
            "      \"emailDescription\": true,\n" +
            "      \"emailDestination\": true,\n" +
            "      \"emailDistributionTime\": true,\n" +
            "      \"employeePayrollId\": true,\n" +
            "      \"employeeFirstName\": true,\n" +
            "      \"employeeLastName\": true,\n" +
            "      \"employeeDob\": true,\n" +
            "      \"employeeEmailAddress\": true,\n" +
            "      \"employerName\": true,\n" +
            "      \"emailSubject\": true,\n" +
            "      \"employerAbn\": true,\n" +
            "      \"emailCcDestination\": true\n" +
            "    },\n" +
            "    \"fromDate\": null,\n" +
            "    \"toDate\": null\n" +
            "  }\n" +
            "}";
}
