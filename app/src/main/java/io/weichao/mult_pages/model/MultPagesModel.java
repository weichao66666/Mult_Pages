package io.weichao.mult_pages.model;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import io.weichao.activity.BaseFragmentActivity;
import io.weichao.listener.BaseOnTouchListener;
import io.weichao.model.BaseModel;
import io.weichao.mult_pages.R;
import io.weichao.mult_pages.activity.MainActivity;
import io.weichao.mult_pages.adapter.MultPagesAdapter;
import io.weichao.util.ConstantUtil;
import io.weichao.view.MultPagesView;

/**
 * Created by Administrator on 2016/10/20.
 */

public class MultPagesModel extends BaseModel {
    public RelativeLayout view;

    private MainActivity mActivity;
    private MultPagesView mMultPagesView;
    private MultPagesAdapter mMultPagesAdapter;

    public MultPagesModel(MainActivity activity) {
        mActivity = activity;
        view = new RelativeLayout(activity);

        BaseOnTouchListener onTouchListener = new BaseOnTouchListener();
        onTouchListener.callback = this;
        onTouchListener.scrollDistanceWidthLimit = (int) (BaseFragmentActivity.width * ConstantUtil.ACTIVITY_SCROLL_DISTANCE_PERCENT);
        onTouchListener.scrollDistanceHeightLimit = (int) (BaseFragmentActivity.height * ConstantUtil.ACTIVITY_SCROLL_DISTANCE_PERCENT);

        RelativeLayout relativeLayout = (RelativeLayout) View.inflate(activity, R.layout.layout_model_mult_pages, null);
        mMultPagesView = (MultPagesView) relativeLayout.findViewById(R.id.view);
        mMultPagesView.setOnTouchListener(onTouchListener);
        mMultPagesAdapter = new MultPagesAdapter(activity);
        mMultPagesView.setAdapter(mMultPagesAdapter);
        view.addView(relativeLayout);
    }

    @Override
    public void onSingleTap() {
        Toast.makeText(mActivity, "index:" + mMultPagesView.getCurrentChildIndex(), Toast.LENGTH_SHORT).show();
    }
}
