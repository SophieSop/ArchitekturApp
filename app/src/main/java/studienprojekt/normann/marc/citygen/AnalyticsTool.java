package studienprojekt.normann.marc.citygen;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import alice.tuprolog.Prolog;
import alice.tuprolog.SolveInfo;
import alice.tuprolog.Theory;
import alice.tuprolog.Var;

/**
 * Created by Marc Normann on 10.04.2018.
 * Added Prolog support and rule management by Jonas Wilczek on 18.01.2019
 */

public class AnalyticsTool  {
    private Prolog engine;

    AnalyticsTool(Context animationContext) {
        try{
            //Prolog
            AssetManager mngr = animationContext.getAssets();
            AssetFileDescriptor fileDescriptor = mngr.openFd("prologtest.pl");
            FileInputStream stream = fileDescriptor.createInputStream();
            Theory theory = new Theory(stream);
            engine = new Prolog();
            engine.setTheory(theory);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void setNewPrologTheory(String theory) {
        try {
            String theoryText = theory;
            engine.addTheory(new Theory(theoryText));
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    private boolean getPrologAnswer(String question){
        try {
            boolean answer = false;
            SolveInfo info = engine.solve(question);
            System.out.println("Query: " + info.getQuery().toString());
            List<String> solution_list = new ArrayList<String>();
            while (info.isSuccess()) {
                answer = true;
                List<Var> vars = info.getBindingVars();
                StringBuilder sb = new StringBuilder();
                for (Var var : vars) {
                    sb.append(var.getName());
                    sb.append(": ");
                    sb.append(info.getVarValue(var.getName()).toString());
                }
                if (sb.toString().equals("true"))
                    solution_list.add(info.toString());
                else
                    solution_list.add(sb.toString());
                if (engine.hasOpenAlternatives())
                    info = engine.solveNext();
                else
                    break;
            }
            for (int i = 0; i < solution_list.size(); i++) {
                if (i > 0) {
                    if (!solution_list.get(i).equals(solution_list.get(i - 1)))
                        System.out.println("Solution " + i + ": " + solution_list.get(i));
                }
                else if (i == 0) {
                    System.out.println("Solution " + i + ": " + solution_list.get(i));
                }
            }

            if (!info.isSuccess()) {
                System.out.println("solution: " + info.getQuery() +" - bindings: " + "no.");
                answer = false;
            }
            return answer;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    private void convertToolHashMapToPrologTheory(HashMap<String, HashMap<String, String>> tools){
        ArrayList<String> list = new ArrayList<>();
        for(HashMap.Entry<String, HashMap<String, String>> valueFirstMap : tools.entrySet()){
            for(HashMap.Entry<String, String> value : valueFirstMap.getValue().entrySet()){
                if (value.getValue() != null) {
                    if (value.getValue().equals("true"))
                        list.add(value.getKey());
                    else
                        list.add(value.getValue());
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s: list) {
            sb.append(s);
            sb.append("(ng1). \n ");
        }
        this.setNewPrologTheory(sb.toString());
    }

    HashMap<String, Boolean> analyse(HashMap<String, HashMap<String, String>> tools){
        HashMap<String, Boolean> prologSolutions = new HashMap<String, Boolean>();
        convertToolHashMapToPrologTheory(tools);
        String lastKeyTool="";
        for(HashMap.Entry<String, HashMap<String, String>> value : tools.entrySet()){
            String key = value.getKey();
            if (!key.equals(lastKeyTool)) {
                switch (key){
                    case "barriers":
                        ArrayList<String> prologRulesBarriers = new ArrayList<>();
                        prologRulesBarriers.add("barriersVisualCover(ng1).");
                        prologRulesBarriers.add("barriersKinkingPassage(ng1).");
                        for(String rule: prologRulesBarriers) {
                            if (getPrologAnswer(rule))
                                prologSolutions.put(rule, true);
                        } break;
                    case "building_structure":
                        ArrayList<String> prologRulesBuilding = new ArrayList<>();
                        prologRulesBuilding.add("trailer(ng1).");
                        prologRulesBuilding.add("useStock(ng1).");
                        for(String rule: prologRulesBuilding) {
                            if (getPrologAnswer(rule))
                                prologSolutions.put(rule, true);
                        } break;
                    case "dynamics_of_user_group":
                        ArrayList<String> prologRulesDynamicsOfUserGroup = new ArrayList<>();
                        //prologRulesDynamicsOfUserGroup.add("userGroupFlexibility(ng1).");
                        //prologRulesDynamicsOfUserGroup.add("privateRoom(ng1).");
                        for(String rule: prologRulesDynamicsOfUserGroup) {
                            if (getPrologAnswer(rule))
                                prologSolutions.put(rule, true);
                        } break;
                    case "infrastructure":
                        ArrayList<String> prologRulesInfrastructure = new ArrayList<>();
                        prologRulesInfrastructure.add("infrastructureStreets(ng1).");
                        prologRulesInfrastructure.add("infrastructurePaths(ng1).");
                        prologRulesInfrastructure.add("infrastructureBicyclePath(ng1).");
                        prologRulesInfrastructure.add("infrastructureWoodsAndSees(ng1).");
                        prologRulesInfrastructure.add("infrastructureBroadStreet(ng1).");
                        prologRulesInfrastructure.add("infrastructureAverageRoad(ng1).");
                        prologRulesInfrastructure.add("infrastructureSmallRoads(ng1).");
                        prologRulesInfrastructure.add("infrastructureWaterSupplyLocation(ng1).");
                        prologRulesInfrastructure.add("infrastructurePowerSupplyLocation(ng1).");
                        prologRulesInfrastructure.add("infrastructureTrafficNetwork(ng1).");
                        for(String rule: prologRulesInfrastructure) {
                            if (getPrologAnswer(rule))
                                prologSolutions.put(rule, true);
                        } break;
                    case "interference_usage_pattern":
                        ArrayList<String> prologRulesInterferenceUsagePattern = new ArrayList<>();
                        prologRulesInterferenceUsagePattern.add("interferenceUsagePatternSeparationLiving(ng1).");
                        prologRulesInterferenceUsagePattern.add("interferenceUsagePatternSeparationBusiness(ng1).");
                        for(String rule: prologRulesInterferenceUsagePattern) {
                            if (getPrologAnswer(rule))
                                prologSolutions.put(rule, true);
                        } break;
                    case "spots":
                        ArrayList<String> prologRulesSpots = new ArrayList<>();
                        prologRulesSpots.add("spots(ng1).");
                        for(String rule: prologRulesSpots) {
                            if (getPrologAnswer(rule))
                                prologSolutions.put(rule, true);
                        } break;
                    case "universal_space_concept":
                        ArrayList<String> prologRulesUniversalSpaceConcept = new ArrayList<>();
                        prologRulesUniversalSpaceConcept.add("universalSpaceConceptNoAnimalFarming(ng1).");
                        prologRulesUniversalSpaceConcept.add("universalSpaceConceptFreeSchool(ng1).");
                        prologRulesUniversalSpaceConcept.add("universalSpaceConceptSeminarCenter(ng1).");
                        prologRulesUniversalSpaceConcept.add("universalSpaceConceptFarmShop(ng1).");
                        prologRulesUniversalSpaceConcept.add("universalSpaceConceptWindmill(ng1).");
                        prologRulesUniversalSpaceConcept.add("universalSpaceConceptPhotovoltaicModule(ng1).");
                        prologRulesUniversalSpaceConcept.add("universalSpaceConceptCourtyard(ng1).");
                        prologRulesUniversalSpaceConcept.add("universalSpaceConceptStaircase(ng1).");
                        prologRulesUniversalSpaceConcept.add("universalSpaceConceptSpine(ng1).");
                        for(String rule: prologRulesUniversalSpaceConcept) {
                            int i = 0;
                            if (getPrologAnswer(rule))
                                prologSolutions.put(rule, true);
                        } break;
                }
                lastKeyTool = key;
            }
        }
        return prologSolutions;
    }
}
