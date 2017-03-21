package com.jhb.ui.viewgroup;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.jhb.ui.R;

/**
 * 一个方便在多种状态切换的view，代码中使用
 */
public class CodeMultipleStatusView extends FrameLayout {
    public static final int STATUS_CONTENT = 0x00;
    public static final int STATUS_LOADING = 0x01;
    public static final int STATUS_EMPTY = 0x02;
    public static final int STATUS_ERROR = 0x03;
    public static final int STATUS_NO_NETWORK = 0x04;

    private static final int NULL_RESOURCE_ID = -1;

    private View mEmptyView;
    private View mErrorView;
    private View mLoadingView;
    private View mNoNetworkView;
    private View mContentView;
    private View mEmptyRetryView;
    private View mErrorRetryView;
    private View mNoNetworkRetryView;
    private int mEmptyViewResId;
    private int mErrorViewResId;
    private int mLoadingViewResId;
    private int mNoNetworkViewResId;
    private int mContentViewResId;
    private int mViewStatus;

    private LayoutInflater mInflater;
    private OnClickListener mOnRetryClickListener;
    private final ViewGroup.LayoutParams mLayoutParams = new ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

    public CodeMultipleStatusView(Context context) {
        this(context, null);
    }

    public CodeMultipleStatusView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CodeMultipleStatusView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        final TypedArray a =
                context.obtainStyledAttributes(attrs, R.styleable.ui_MultipleStatusView, defStyleAttr, 0);

        mEmptyViewResId =
                a.getResourceId(R.styleable.ui_MultipleStatusView_ui_emptyView, R.layout.ui_empty_view);
        mErrorViewResId =
                a.getResourceId(R.styleable.ui_MultipleStatusView_ui_errorView, R.layout.ui_error_view);
        mLoadingViewResId =
                a.getResourceId(R.styleable.ui_MultipleStatusView_ui_loadingView, R.layout.ui_loading_view);
        mNoNetworkViewResId = a.getResourceId(R.styleable.ui_MultipleStatusView_ui_noNetworkView,
                R.layout.ui_no_network_view);
        mContentViewResId = a.getResourceId(R.styleable.ui_MultipleStatusView_ui_contentView,
                NULL_RESOURCE_ID);
        a.recycle();

        mInflater = LayoutInflater.from(getContext());
    }

    /** 获取当前状态 */
    public int getViewStatus() {
        return mViewStatus;
    }

    /**
     * 设置重试点击事件
     * @param onRetryClickListener 重试点击事件
     */
    public void setOnRetryClickListener(OnClickListener onRetryClickListener) {
        this.mOnRetryClickListener = onRetryClickListener;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        //这里状态不为内容时，就不往下发事件
        switch (getViewStatus()) {
            case STATUS_EMPTY:
                return mEmptyRetryView.dispatchTouchEvent(ev);
            case STATUS_ERROR:
                return mErrorRetryView.dispatchTouchEvent(ev);
            case STATUS_NO_NETWORK:
                return mNoNetworkRetryView.dispatchTouchEvent(ev);
        }
        return super.dispatchTouchEvent(ev);
    }

    /** 显示空视图 */
    public final void showEmpty() {
        mViewStatus = STATUS_EMPTY;
        if (null == mEmptyView) {
            mEmptyView = mInflater.inflate(mEmptyViewResId, null);
            mEmptyRetryView = mEmptyView.findViewById(R.id.empty_retry_view);
            if (null != mOnRetryClickListener && null != mEmptyRetryView) {
                mEmptyRetryView.setOnClickListener(mOnRetryClickListener);
            }
            addView(mEmptyView, 0, mLayoutParams);
        }
        showViewByStatus(mViewStatus);
    }

    /** 显示错误视图 */
    public final void showError() {
        mViewStatus = STATUS_ERROR;
        if (null == mErrorView) {
            mErrorView = mInflater.inflate(mErrorViewResId, null);
            mErrorRetryView = mErrorView.findViewById(R.id.error_retry_view);
            if (null != mOnRetryClickListener && null != mErrorRetryView) {
                mErrorRetryView.setOnClickListener(mOnRetryClickListener);
            }
            addView(mErrorView, 0, mLayoutParams);
        }
        showViewByStatus(mViewStatus);
    }

    /** 显示加载中视图 */
    public final void showLoading() {
        mViewStatus = STATUS_LOADING;
        if (null == mLoadingView) {
            mLoadingView = mInflater.inflate(mLoadingViewResId, null);
            addView(mLoadingView, 0, mLayoutParams);
        }
        showViewByStatus(mViewStatus);
    }

    /** 显示无网络视图 */
    public final void showNoNetwork() {
        mViewStatus = STATUS_NO_NETWORK;
        if (null == mNoNetworkView) {
            mNoNetworkView = mInflater.inflate(mNoNetworkViewResId, null);
            mNoNetworkRetryView = mNoNetworkView.findViewById(R.id.no_network_retry_view);
            if (null != mOnRetryClickListener && null != mNoNetworkRetryView) {
                mNoNetworkRetryView.setOnClickListener(mOnRetryClickListener);
            }
            addView(mNoNetworkView, 0, mLayoutParams);
        }
        showViewByStatus(mViewStatus);
    }

    /** 显示内容视图 */
    public final void showContent() {
        mViewStatus = STATUS_CONTENT;
        if (null == mContentView) {
            if (mContentViewResId != NULL_RESOURCE_ID) {
                mContentView = mInflater.inflate(mContentViewResId, null);
                addView(mContentView, 0, mLayoutParams);
            } else {
                mContentView = findViewById(R.id.content_view);
            }
        }
        showViewByStatus(mViewStatus);
    }

    private void showViewByStatus(int viewStatus) {
        if (null != mLoadingView) {
            mLoadingView.setVisibility(viewStatus == STATUS_LOADING ? View.VISIBLE : View.GONE);
        }
        if (null != mEmptyView) {
            mEmptyView.setVisibility(viewStatus == STATUS_EMPTY ? View.VISIBLE : View.GONE);
        }
        if (null != mErrorView) {
            mErrorView.setVisibility(viewStatus == STATUS_ERROR ? View.VISIBLE : View.GONE);
        }
        if (null != mNoNetworkView) {
            mNoNetworkView.setVisibility(viewStatus == STATUS_NO_NETWORK ? View.VISIBLE : View.GONE);
        }
        if (null != mContentView) {
            mContentView.setVisibility(viewStatus == STATUS_CONTENT ? View.VISIBLE : View.GONE);
        }
    }

    public void setContentView(View contentView) {
        this.mContentView = contentView;
        addView(mContentView, 0, mLayoutParams);
    }
}
