package com.SugarRisk.website.SugarRisk.ServiceLayer;

import com.SugarRisk.website.SugarRisk.ModelLayer.UserDataModel;

public interface ServiceInt {

    void addData(UserDataModel userDataModel);
    void removeData(Long id);
    String getName(Long id);
    String getSurname(Long id);
    int getAge(Long id);
    String getSex(Long id);
    float getBodyMass(Long id);
    float getWaist(Long id);
    String getAntiHyperTensive(Long id);
    String getBloodGlucose(Long id);
    int getRelativeDiabetes(Long id);
    int getEating(Long id);
    String getActivity(Long id);
    float getScore(Long id);
}
