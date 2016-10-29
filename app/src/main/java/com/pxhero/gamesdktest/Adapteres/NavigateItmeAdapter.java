package com.pxhero.gamesdktest.Adapteres;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.pxhero.gamesdktest.R;
import com.pxhero.gamesdktest.model.NavigateItemInfo;

import java.util.List;

/**
 * Created by pengxianheng on 2016/10/27.
 */
public class NavigateItmeAdapter extends ArrayAdapter<NavigateItemInfo>{


    private int resourceId;
    private Context context;



    public NavigateItmeAdapter(Context context, int resource, List<NavigateItemInfo> objects) {
        super(context, resource, objects);
        this.resourceId = resource;
        this.context = context;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        ViewHolder viewHolder = null;

        if(convertView != null) {
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();
        }
        else {
            view = LayoutInflater.from(this.context).inflate(this.resourceId,null);
            viewHolder = new ViewHolder();
            viewHolder.btnItem = (Button)view.findViewById(R.id.navigate_item_btn);
            viewHolder.textDes = (TextView)view.findViewById(R.id.navigate_item_des);
            view.setTag(viewHolder);
        }

        NavigateItemInfo navigateItemInfo = getItem(position);
        viewHolder.textDes.setText(navigateItemInfo.geteItemType().getDes());

        Resources resources = this.context.getResources();
        Drawable btnDrawable = resources.getDrawable(navigateItemInfo.getBtnDrawableId());
        viewHolder.btnItem.setBackground(btnDrawable);
        if(navigateItemInfo.getBtnClickListener()!=null) {
            viewHolder.btnItem.setOnClickListener(navigateItemInfo.getBtnClickListener());
        }
        return  view;
    }

    class ViewHolder {
        Button btnItem;
        TextView textDes;
    }


}
