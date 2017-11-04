package org.fath.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter Test Case Count...............: ");
        int testCaseCount = Integer.parseInt(in.readLine());

        for (int i = 0; i < testCaseCount; i++) {

            System.out.print("Enter City Count in ByteLand.......: ");
            int cityCount = Integer.parseInt(in.readLine());                // how many city is in the Byte land
            List<City> cityList = createCity(cityCount);                    // create cities with ids

            System.out.print("Enter Roads Between City's..........: ");
            String[] cityRoadArrayStr = in.readLine().split("\\s+");

            List<Integer> thisCitiesRoadMap = new ArrayList<>();
            for (String aRoad : cityRoadArrayStr) {
                thisCitiesRoadMap.add(Integer.parseInt(aRoad));
            }

            linkCitiesWithGivenRoad(cityList, thisCitiesRoadMap);

            calculateMinStepForUnification(cityList, 0);

        }


    }

    private static void calculateMinStepForUnification(List<City> cityList, int stepCount) throws CloneNotSupportedException {

        List<City> nextStepList = new ArrayList<>();

        clearCityUnifiedStatus(cityList);

        for (City city : cityList) {
            if (!city.isUnited()) {

                City willMergeCity = findMinLinkedAndNotUnitedCity(city);

                if (willMergeCity != null) {
                    linkSourceCitiesRoadsToTargetCity(willMergeCity, city);
                    city.setUnited(false);
                    nextStepList.add(city);
                    willMergeCity.setUnited(true);
                    city.setUnited(true);
                } else {
                    city.setUnited(false);
                    nextStepList.add(city);
                    city.setUnited(true);
                }
            }
        }


        if (nextStepList.size() == 1) {
            System.out.println("Min step for unification : " + stepCount + 1 + " Viva Byte Land, make ByteLand binary again !!");
        } else {
            calculateMinStepForUnification(nextStepList, stepCount + 1);
        }


    }

    private static void clearCityUnifiedStatus(List<City> cityList) {
        for (City city : cityList) {
            city.setUnited(false);
        }
    }


    private static void linkSourceCitiesRoadsToTargetCity(City sourceCity, City targetCity) {

        sourceCity.getRelatedCityList().remove(targetCity);
        targetCity.getRelatedCityList().remove(sourceCity);

        for (City city : sourceCity.getRelatedCityList()) {

            targetCity.getRelatedCityList().add(city);

            city.getRelatedCityList().remove(sourceCity);

        }

        sourceCity.setRelatedCityList(new ArrayList<City>());

    }

    private static City findMinLinkedAndNotUnitedCity(City city) {

        int minLinkCount = 601;

        City minLinkedCity = null;

        for (City tempCity : city.getRelatedCityList()) {
            if (!tempCity.isUnited()) {
                if (tempCity.getRelatedCityList().size() < minLinkCount) {
                    minLinkCount = tempCity.getRelatedCityList().size();
                    minLinkedCity = tempCity;
                }

            }

        }

        return minLinkedCity;


    }

    private static void linkCitiesWithGivenRoad(List<City> cityList, List<Integer> thisCitiesRoadMap) {
        for (int i = 0; i < thisCitiesRoadMap.size(); i++) {
            cityList.get(i + 1).getRelatedCityList().add(cityList.get(thisCitiesRoadMap.get(i)));
            cityList.get(thisCitiesRoadMap.get(i)).getRelatedCityList().add(cityList.get(i + 1));
        }
    }

    private static List<City> createCity(int cityCount) {
        List<City> list = new ArrayList<>();
        for (int i = 0; i < cityCount; i++) {
            list.add(new City(i));
        }
        return list;
    }

}
