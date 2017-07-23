package ominext.android.vn.ladygirls.View;

import java.util.ArrayList;

import ominext.android.vn.ladygirls.Model.SchoolGirl;
import ominext.android.vn.ladygirls.Model.TopSchoolGirl;

/**
 * Created by MyPC on 11/07/2017.
 */

public interface MainView {
    void getListNuSinhSuccess(ArrayList<SchoolGirl> list);
    void getListTopSchoolGirlSuccess(ArrayList<TopSchoolGirl> list);
    void fail();
}
