package com.pxhero.gamesdktest.model;

import android.view.View;

/**
 * Created by pengxianheng on 2016/10/27.
 */
public class NavigateItemInfo {

    private int btnDrawableId;
    private NavigateItemType eItemType;
    private View.OnClickListener btnClickListener;


    public View.OnClickListener getBtnClickListener() {
        return btnClickListener;
    }

    public void setBtnClickAction(View.OnClickListener clickAction) {
        this.btnClickListener = clickAction;
    }

    public enum NavigateItemType {
        PERSONAL_CENTER("个人中心"),
        WELFARE_HALL("福利大厅"),
        CUSTOMER_SERVICE_CENTER("客服中心"),
        ACTIVITY_HALL("活动大厅"),
        INTELLIGENCE_STATION("情报站"),
        NEW_GAME_RECOMMENDED("新游力荐");

        private String des;
        private NavigateItemType(String des) {
            this.des = des;
        }

        public String getDes() {
            return  this.des;
        }
    }

    public NavigateItemInfo(int resourceId, NavigateItemType eItemType) {
        this.btnDrawableId = resourceId;
        this.eItemType = eItemType;
    }


    public int getBtnDrawableId() {
        return btnDrawableId;
    }

    public void setBtnDrawableId(int btnDrawableId) {
        this.btnDrawableId = btnDrawableId;
    }

    public NavigateItemType geteItemType() {
        return eItemType;
    }

    public void seteItemType(NavigateItemType eItemType) {
        this.eItemType = eItemType;
    }
}


