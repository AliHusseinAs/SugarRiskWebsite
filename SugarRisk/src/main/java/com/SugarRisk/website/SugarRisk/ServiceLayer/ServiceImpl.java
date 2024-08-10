package com.SugarRisk.website.SugarRisk.ServiceLayer;

import com.SugarRisk.website.SugarRisk.ModelLayer.UserDataModel;
import com.SugarRisk.website.SugarRisk.RepositoryLayer.Repo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceImpl implements ServiceInt {

    private Repo repo;

    public ServiceImpl(Repo repo) {
        this.repo = repo;
    }

    @Override
    public void addData(UserDataModel userDataModel) {
        repo.save(userDataModel);
    }

    @Override
    public void removeData(Long id) {
        repo.deleteById(id);
    }

    @Override
    public String getName(Long id) {
        Optional<UserDataModel> userDataMode = repo.findById(id);
        return userDataMode.map(UserDataModel::getName).orElse(null);
    }

    @Override
    public String getSurname(Long id) {
        Optional<UserDataModel> userDataModel = repo.findById(id);
        return userDataModel.map(UserDataModel::getSurname).orElse(null);
    }

    @Override
    public int getAge(Long id) {
        Optional<UserDataModel> userDataModel = repo.findById(id);
        return userDataModel.map(UserDataModel::getAge).orElse(-1);
    }

    @Override
    public String getSex(Long id) {
        Optional<UserDataModel> userDataModel = repo.findById(id);
        return userDataModel.map(UserDataModel::getSex).orElse(null);
    }

    @Override
    public float getBodyMass(Long id) {
        Optional<UserDataModel> userDataModel = repo.findById(id);
        return userDataModel.map(UserDataModel::getBodyMass).orElse((float) -1);
    }

    @Override
    public float getWaist(Long id) {
        Optional<UserDataModel> userDataModel = repo.findById(id);
        return userDataModel.map(UserDataModel::getWaist).orElse((float) -1);
    }

    @Override
    public String getAntiHyperTensive(Long id) {
        Optional<UserDataModel> userDataModel = repo.findById(id);
        return userDataModel.map(UserDataModel::getAntiHybertensive).orElse(null);
    }

    @Override
    public String getBloodGlucose(Long id) {
        Optional<UserDataModel> userDataModel = repo.findById(id);
        return userDataModel.map(UserDataModel::getBloodGlucose).orElse(null);
    }

    @Override
    public int getRelativeDiabetes(Long id) {
        Optional<UserDataModel> userDataModel = repo.findById(id);
        return userDataModel.map(UserDataModel::getRelativeDiabetes).orElse(-1);
    }

    @Override
    public int getEating(Long id) {
        Optional<UserDataModel> userDataModel = repo.findById(id);
        return userDataModel.map(UserDataModel::getEating).orElse(-1);
    }

    @Override
    public String getActivity(Long id) {
        Optional<UserDataModel> userDataModel = repo.findById(id);
        return userDataModel.map(UserDataModel::getActivity).orElse(null);
    }

    @Override
    public float getScore(Long id) {
        int age = getAge(id);
        String activity = getActivity(id);
        float bodyMass = getBodyMass(id);
        float waist = getWaist(id);
        String hyberDrug = getAntiHyperTensive(id);
        String bloodG = getBloodGlucose(id);
        String sex = getSex(id);
        int eat = getEating(id);
        int relative = getRelativeDiabetes(id);
        float last = getScore(age, bodyMass, waist, sex, activity, hyberDrug, bloodG, eat, relative);
//        Optional<UserDataModel> userDataModel = repo.findById(Id);
//        int finalScore = userDataModel.map(UserDataModel :: getFinalScore).orElse(-1);
        return last;
    }

    // business logic

    public int pointAge(int age) {
        int point;
        if (age < 45) {
            return point = 0;
        } else if (age >= 45 && age <= 54) {
            return point = 2;
        } else if (age >= 55 && age <= 64) {
            return point = 3;
        } else if (age > 64) {
            return point = 4;
        }
        return -1;

    }

    public float BodyMass(float bodyMass) {
        int point;
        if (bodyMass < 25) {
            return point = 0;
        } else if (bodyMass >= 25 && bodyMass <= 30) {
            return point = 1;
        } else if (bodyMass > 30) {
            return point = 3;
        } else return -1;
    }

    public float Waist(float waist, String sex) {
        int point;
        if (sex.equals("female")) {
            if (waist < 80) {
                return point = 0;
            } else if (waist >= 80 && waist <= 88) {
                return point = 3;
            } else if (waist > 88) {
                return point = 4;
            }
        }
        if (sex.equals("male")) {
            if (waist < 94) {
                return point = 0;
            } else if (waist >= 94 && waist <= 102) {
                return point = 3;
            } else if (waist > 102) {
                return point = 4;
            }
        }
        return -1;
    }

    public int Activity(String active) {
        int point;
        if (active.equals("yes")) {
            return point = 0;
        } else if (active.equals("no")) {
            return point = 2;
        } else return -1;
    }

    public int healthyEat(int eat) {
        int point;
        if (eat == 1) {
            return point = 0;
        } else if (eat == 0) {
            return point = 1;
        } else return -1;
        // 1 means every day, 0 means not everyday
    }

    public int hyberDrug(String hyberDrug) {
        int point;
        if (hyberDrug.equals("yes")) {
            return point = 2;
        } else if (hyberDrug.equals("no")) {
            return point = 0;
        } else return -1;
    }

    public int bloodGlucose(String blood) {
        int point;
        if (blood.equals("yes")) {
            return point = 5;
        } else if (blood.equals("no")) {
            return point = 0;
        } else return -1;
    }

    public int relative(int relative)
    {
        int point;
        if (relative == 0) {
            return point = 0;
        } else if (relative == 1) {
            return point = 3;
        } else if (relative == 2) {
            return point = 5;
        } else return -1;
        // here 0 means no, 1 means not first degree relative, 2 means first degree relative
    }


    public float getScore(int age, float bodyMass, float waist, String sex, String active, String hyberDrug, String blood, int eat, int relative) {
        float result = pointAge(age) + BodyMass(bodyMass) + Waist(waist, sex)
                + Activity(active) + hyberDrug(hyberDrug) + bloodGlucose(blood) + healthyEat(eat) + relative(relative);
        return result;
    }



}