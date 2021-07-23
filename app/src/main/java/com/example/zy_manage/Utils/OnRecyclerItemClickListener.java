package com.example.zy_manage.Utils;





import com.example.zy_manage.Entity.ShopEntity;

import java.util.List;

public interface OnRecyclerItemClickListener {
    //RecyclerView的点击事件，将信息回调给view
    void onItemClick(int Position, List<ShopEntity> dataList);
}