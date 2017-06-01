package com.bwie.fanliang.yuekaob;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fanliang on 2017/5/31.
 */
public class Adapters extends BaseAdapter{
    public Map<Integer,Boolean> isCheck = null;
    List<Bean.AppBean> geturl;
    Context context;
    public Adapters(List<Bean.AppBean> geturl, Context context) {
        this.geturl = geturl;
        this.context = context;
        isCheck = new HashMap<Integer,Boolean>();
        initMap();
    }
    private void initMap(){
        for (int i = 0; i < geturl.size(); i++) {
            isCheck.put(i, false);
        }
    }

    @Override
    public int getCount() {
        return geturl.size();
    }

    @Override
    public Object getItem(int i) {
        return geturl.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        InforHarder inforHarder;
        if(view == null){
            inforHarder = new InforHarder();
            view = View.inflate(context, R.layout.item, null);
            inforHarder.tv = (TextView) view.findViewById(R.id.iv);
            inforHarder.cb = (CheckBox) view.findViewById(R.id.cb);
            view.setTag(inforHarder);

        }else {
            inforHarder = (InforHarder) view.getTag();
        }
        inforHarder.tv.setText(geturl.get(i).getSecCate());

        inforHarder.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    isCheck.put(i, true);
                } else {
                    isCheck.put(i, false);
                }
            }
        });

        inforHarder.cb.setChecked(isCheck.get(i));

        return view;
    }

    class InforHarder {
        TextView tv;
        CheckBox cb;

    }
}
