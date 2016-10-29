package com.pxhero.gamesdktest.model;

import android.view.View;

/**
 * Created by pengxianheng on 2016/10/28.
 */
public class RankingListGameItem {
    private  GameInfo mGameInfo;
    private View.OnClickListener mBtnClickListener;

    public RankingListGameItem(GameInfo mGameInfo, View.OnClickListener mBtnClickListener) {
        this.mGameInfo = mGameInfo;
        this.mBtnClickListener = mBtnClickListener;
    }

    public GameInfo getmGameInfo() {
        return mGameInfo;
    }

    public void setmGameInfo(GameInfo mGameInfo) {
        this.mGameInfo = mGameInfo;
    }

    public View.OnClickListener getmBtnClickListener() {
        return mBtnClickListener;
    }

    public void setmBtnClickListener(View.OnClickListener mBtnClickListener) {
        this.mBtnClickListener = mBtnClickListener;
    }
}
