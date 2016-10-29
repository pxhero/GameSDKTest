package com.pxhero.gamesdktest.Adapteres;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.pxhero.gamesdktest.R;
import com.pxhero.gamesdktest.model.RankingListGameItem;

import java.util.List;

/**
 * Created by pengxianheng on 2016/10/28.
 */
public class RankingListGameAdapter extends ArrayAdapter<RankingListGameItem>{

    private Context mContext;
    private int mResouceId;


    public RankingListGameAdapter(Context context, int resource, List<RankingListGameItem> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResouceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        RanklistViewHolder ranklistViewHolder = null;
        if(convertView!=null) {
            view = convertView;
            ranklistViewHolder =(RanklistViewHolder)view.getTag();
        }
        else{
            view = LayoutInflater.from(this.mContext).inflate(this.mResouceId,null);
            ranklistViewHolder = new RanklistViewHolder();
            ranklistViewHolder.mImageView = (ImageView)view.findViewById(R.id.ranking_list_gameImage);
            ranklistViewHolder.mGameNameTextView = (TextView)view.findViewById(R.id.ranking_list_game_name_text);
            ranklistViewHolder.mActivityDesTextView = (TextView)view.findViewById(R.id.ranking_list_activity_des_text);
            ranklistViewHolder.mGameDesTextView = (TextView)view.findViewById(R.id.ranking_list_game_des_text);
            ranklistViewHolder.mDownLoadBtn = (Button)view.findViewById(R.id.ranking_list_game_download_btn);
            view.setTag(ranklistViewHolder);
        }

        RankingListGameItem rankingListGameItem = getItem(position);
        ranklistViewHolder.mImageView.setImageResource(rankingListGameItem.getmGameInfo().getImageResourceId());
        ranklistViewHolder.mGameNameTextView.setText(rankingListGameItem.getmGameInfo().getGameName());
        ranklistViewHolder.mActivityDesTextView.setText(rankingListGameItem.getmGameInfo().getGameActivityDes());
        ranklistViewHolder.mGameDesTextView.setText(rankingListGameItem.getmGameInfo().getGameDescription());
        ranklistViewHolder.mDownLoadBtn.setOnClickListener(rankingListGameItem.getmBtnClickListener());

        return  view;
    }

   private class RanklistViewHolder {
        ImageView mImageView;
        TextView mGameNameTextView;
        TextView mActivityDesTextView;
        TextView mGameDesTextView;
        Button  mDownLoadBtn;
    }
}
