package com.dj.framework.base.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.dj.framework.base.presenter.BasePresenter;
import com.dj.framework.base.view.interfaces.IBaseView;

/**
 * 基础Fragment
 * @author wangjing
 * @param <V>
 * @param <T>
 */
public class BaseFragment<V extends IBaseView, T extends BasePresenter<V>> extends Fragment {
    protected T mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView((V) this);
        }
    }

    protected T createPresenter() {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
