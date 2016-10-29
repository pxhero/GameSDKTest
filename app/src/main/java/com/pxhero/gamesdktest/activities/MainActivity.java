package com.pxhero.gamesdktest.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.pxhero.gamesdktest.Adapteres.NavigateItmeAdapter;
import com.pxhero.gamesdktest.Adapteres.RankingListGameAdapter;
import com.pxhero.gamesdktest.R;
import com.pxhero.gamesdktest.model.GameInfo;
import com.pxhero.gamesdktest.model.NavigateItemInfo;
import com.pxhero.gamesdktest.model.RankingListGameItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ListView mRankingGameListView;
    private ArrayList<RankingListGameItem> mRankingItemList = new ArrayList<>();


    //headView 相关
    private ArrayList<NavigateItemInfo> navigateItemList = new ArrayList<>();
    private GridView navigateGridView;

    private LinearLayout mNewGameRecScrollLayout;
    private ArrayList<GameInfo> mNewGameRecItemList = new ArrayList<>();
    //headView 相关


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化游戏飙升榜listview
        mRankingGameListView = (ListView)findViewById(R.id.rankingGameListView);
        initRankingItemList();
        RankingListGameAdapter rankingListGameAdapter = new RankingListGameAdapter(this,R.layout.ranking_list_game_item,mRankingItemList);

        initListHeadView();
        mRankingGameListView.setAdapter(rankingListGameAdapter);
        mRankingGameListView.setVerticalScrollBarEnabled(false);
    }

    private  void initListHeadView() {
        //添加headview
        View headview= getLayoutInflater().inflate(R.layout.head_game_layout,null);

        navigateGridView = (GridView)headview.findViewById(R.id.navigateGridView);
        InitNavigateItemList();
        NavigateItmeAdapter navigateItmeAdapter = new NavigateItmeAdapter(MainActivity.this,R.layout.navigate_grid_item,navigateItemList);
        navigateGridView.setAdapter(navigateItmeAdapter);

        //初始化HorizontalScrollView
        mNewGameRecScrollLayout = (LinearLayout)headview.findViewById(R.id.newGameScroll);
        InitRecGameInfoList();
        InitRecGameScrollView();


        mRankingGameListView.addHeaderView(headview);
    }

    private void initRankingItemList() {
        for(int i=0; i<12;i++) {
            final GameInfo gameInfo = new GameInfo(R.drawable.temple_run,"神庙逃亡","说志","角色扮演/23M",1);
            gameInfo.setGameId(i+1);
            gameInfo.setGameName(gameInfo.getGameName()+ gameInfo.getGameId());
            gameInfo.setGameActivityDes("新版“一念乾坤”10月25日公测，重磅福利玩转诛仙");

            RankingListGameItem rankingListGameItem = new RankingListGameItem(gameInfo,new View.OnClickListener()
            {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this,"开始下载"+gameInfo.getGameName(),Toast.LENGTH_SHORT).show();
                }
            });


            mRankingItemList.add(rankingListGameItem);
        }
    }



    //生成新游力荐的list
    private void InitRecGameInfoList() {
        for(int i=0; i<10;i++) {
            GameInfo gameInfo1 = new GameInfo(R.drawable.flower_game,"诛仙","说志","角色扮演/23M",1);
            gameInfo1.setGameId(i+1);
            gameInfo1.setGameName(gameInfo1.getGameName()+ gameInfo1.getGameId());
            mNewGameRecItemList.add(gameInfo1);
        }
    }

    //生成HorizontalScrollView界面
    private void InitRecGameScrollView(){
        View itemView = null;
        ImageView imageView = null;
        TextView gamenameText = null;
        TextView gameTypeText = null;
        TextView gameDesText = null;
        boolean isFirstItem = true;
        for(GameInfo gameInfo : mNewGameRecItemList) {


            itemView = getLayoutInflater().inflate(R.layout.new_game_recommend_item,null);

            imageView = (ImageView)itemView.findViewById(R.id.newRecGameImage);
            imageView.setImageResource(gameInfo.getImageResourceId());

            gamenameText = (TextView)itemView.findViewById(R.id.newGameNameText);
            gamenameText.setText(gameInfo.getGameName());

            gameTypeText = (TextView)itemView.findViewById(R.id.newGameTypeText);
            gameTypeText.setText(gameInfo.getGameType());

            gameDesText = (TextView)itemView.findViewById(R.id.newGameDesText);
            gameDesText.setText(gameInfo.getGameDescription());

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            if(isFirstItem) {
                lp.setMargins(0, 0, 0, 0);
                isFirstItem = false;
            }
            else {
                int dpValue = 30; // margin in dips
                float d = this.getResources().getDisplayMetrics().density;
                int marginLeftInPixel = (int)(dpValue * d); // margin in pixels
                lp.setMargins(marginLeftInPixel, 0, 0, 0);
            }
            itemView.setLayoutParams(lp);

            mNewGameRecScrollLayout.addView(itemView);
        }
    }


    private  void InitNavigateItemList() {

        NavigateItemInfo navigateItemInfo1 = new NavigateItemInfo(R.drawable.personal_center,
                NavigateItemInfo.NavigateItemType.PERSONAL_CENTER);

        NavigateItemInfo navigateItemInfo2 = new NavigateItemInfo(R.drawable.walfare_hall,
                NavigateItemInfo.NavigateItemType.WELFARE_HALL);

        NavigateItemInfo navigateItemInfo3 = new NavigateItemInfo(R.drawable.customer_service_center,
                NavigateItemInfo.NavigateItemType.CUSTOMER_SERVICE_CENTER);
        NavigateItemInfo navigateItemInfo4 = new NavigateItemInfo(R.drawable.activity_hall,
                NavigateItemInfo.NavigateItemType.ACTIVITY_HALL);
        NavigateItemInfo navigateItemInfo5 = new NavigateItemInfo(R.drawable.intelligence_station,
                NavigateItemInfo.NavigateItemType.INTELLIGENCE_STATION);
        NavigateItemInfo navigateItemInfo6 = new NavigateItemInfo(R.drawable.new_game_recommend,
                NavigateItemInfo.NavigateItemType.NEW_GAME_RECOMMENDED);

        navigateItemList.add(navigateItemInfo1);
        navigateItemList.add(navigateItemInfo2);
        navigateItemList.add(navigateItemInfo3);
        navigateItemList.add(navigateItemInfo4);
        navigateItemList.add(navigateItemInfo5);
        navigateItemList.add(navigateItemInfo6);

        for(final NavigateItemInfo navigateItemInfo : navigateItemList) {
            navigateItemInfo.setBtnClickAction(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this,"点击了"+navigateItemInfo.geteItemType().getDes()+"按钮",Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}
