package com.shopin.commonlibrary.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * <pre>
 * <B>非与LIBBaseAdapter使用时,下列方法将会失效 </B>
 * 1.{@link #refresh()}
 * 2.{@link #isRecyleHolder()}
 * 3.{@link #getPosition()}
 * 4.{@link #getTag()}
 * 5.{@link #getItemViewType()}
 * <B>若主布局只有一个View时,外部不能调用{@link View#setTag(Object)} </B>
 * </pre>
 * @author lixi
 * @Description <LIBViewHolder>
 * @date 2017-5-19
 */
public class LIBViewHolder {

    private View mConvertView;// 主布局
    private LIBBaseAdapter adapter;// 主布局
    private Context context;//上下文
    private SparseArray<View> mCacheViews;// 缓存容器
    private int layoutId;// 布局ID

    private boolean isMarkRecycler;// 标记当前在Adapter中是否是重用的ViewHolder
    private Object tag;// 实体类缓存 只有在Adapter中才会缓存实体类
    private int position;// 在Adapter中的位置
    private boolean isRecyle;// 在Adapter中是否是重用的ViewHolder
    private int itemViewType; // 在Adapter中的布局类型
    private OnDatasetChangeListener listener;// Adapter中数据变更监听

    private LIBViewHolder(Context context, ViewGroup parentView, int layoutId, int position, boolean attachToRoot, int itemViewType) {
        this.context = context;
        this.itemViewType = itemViewType;
        this.layoutId = layoutId;
        mCacheViews = new SparseArray<View>();
        setConvertView(context, layoutId, parentView, attachToRoot);
    }

    /** 设置主布局,若为null */
    private void setConvertView(Context context, int layoutId, ViewGroup parentView, boolean attachToRoot) {
        if (layoutId > 0) {
            View convertView = LayoutInflater.from(context).inflate(layoutId, parentView, attachToRoot);
            setConvertView(convertView);
        }
    }

    /**
     * @return 是否已经设置的主布局
     */
    public final boolean hasAlreadySetConvertView() {
        return null != mConvertView;
    }

    /** 设置主布局,若为null，不会覆盖原有布局 */
    public final void setConvertView(View view) {
        if (null == view) {
            return;
        }
        if (null != mConvertView) {
            mCacheViews.clear();
            mConvertView = null;
        }
        mConvertView = view;
        mConvertView.setTag(this);
    }

    /**
     * 获得ViewHolder,BaseAdapter中使用 ,attachToRoot=<code>false</code>
     */
    public static LIBViewHolder getHolder(View convertView, ViewGroup parentView, int layoutId, int position, int itemViewType, boolean noRecycle) {
        return getHolder(convertView, parentView, layoutId, position, false, itemViewType, noRecycle);
    }

    /**
     * 获得ViewHolder,BaseAdapter中使用
     */
    public static LIBViewHolder getHolder(View convertView, ViewGroup parentView, int layoutId, int position, boolean attachToRoot, int itemViewType, boolean noRecycle) {
        LIBViewHolder holder = null;
        if (convertView == null || noRecycle) {
            holder = new LIBViewHolder(parentView.getContext(), parentView, layoutId, position, attachToRoot, itemViewType);
            holder.isRecyle = false;
            return holder;
        } else {
            holder = (LIBViewHolder) convertView.getTag();
            holder.position = position;
            holder.isRecyle = true;
            holder.itemViewType = itemViewType;
            return holder;
        }
    }

    /**
     * 获得ViewHolder,在某些情况下使用.
     * <p/>
     * <pre>
     * <B>注意:以下方法将会不工作</B>
     * {@link #refresh()} {@link #isRecyleHolder()}
     * {@link #getPosition()} {@link #getTag()} {@link #getItemViewType()}
     * </pre>
     */
    public static LIBViewHolder getHolder(Context context, ViewGroup parentView, int layoutId, boolean attachToRoot) {
        return new LIBViewHolder(context, parentView, layoutId, 0, attachToRoot, 0);
    }

    /** 获得当前在Adapter中的布局类型 */
    public int getItemViewType() {
        return itemViewType;
    }

    /** 设置在Adapter中缓存的实体类 */
    protected void setTag(Object tag) {
        this.tag = tag;
    }

    ;

    /** 获得在Adapter中缓存的实体类 */
    @SuppressWarnings("unchecked")
    public <T> T getTag() {
        return (T) tag;
    }

    /** 获得Resources资源 */
    public Resources getResources() {
        return mConvertView.getResources();
    }

    /** Adapter中数据变更监听 */
    protected static interface OnDatasetChangeListener {
        void onChange(LIBViewHolder holder);
    }

    /** 设置Adapter中数据变更监听 */
    protected void setListener(OnDatasetChangeListener listener) {
        this.listener = listener;
    }

    /** 标记当前的ViewHolder,在Adapter中是重用的 */
    protected void markRecyclerHolder() {
        if (isRecyle) {
            return;
        }
        isMarkRecycler = true;
    }

    /** 重置在Adapter中重用标记 */
    protected void resetRecyclerHolder() {
        isMarkRecycler = false;
    }

    /** R.layout.id */
    public int getLayoutID() {
        return layoutId;
    }

    /** 获得上下文Context */
    public Context getContext() {
        return context;
    }

    /** 在Adapter中是否是重用的ViewHolder，若不是重用的Item 在Refresh的时候 会标记为TRUE，Refresh后会重置标记 */
    public boolean isRecyleHolder() {
        return isMarkRecycler ? true : isRecyle;
    }

    /**
     * 刷新item,会回调{@link LIBBaseAdapter#convert(LIBViewHolder, Object, int, int)}
     * ,此时{@link #isRecyleHolder()}暂时标记为TRUE，Refresh后会重置该标记
     */
    public boolean refresh() {
        if (null != listener) {
            listener.onChange(this);
            return true;
        } else {
            return false;
        }
    }

    /** 获得当前在Adapter中的位置 */
    public int getPosition() {
        return position;
    }

    /** 获得当前的View */
    public View getConvertView() {
        return mConvertView;
    }

    /** 获得某个View */
    @SuppressWarnings("unchecked")
    public <T extends View> T getView(int id) {
        View view = mCacheViews.get(id);
        if (view == null) {
            view = mConvertView.findViewById(id);
        }
        return (T) view;
    }

    /** 获得某个View， 只有在初始化View 的时候才会对view设置监听事件 */
    public <T extends View> T getView(int id, OnClickListener clickListener) {
        return getView(id, clickListener, isRecyleHolder());
    }

    /** 获得某个View， 只有在初始化View 的时候才会对view设置监听事件 */
    public <T extends View> T getView(int id, OnClickListener clickListener, boolean isRecycleHolder) {
        T view = getView(id);
        if (isRecycleHolder == false) {
            view.setOnClickListener(clickListener);
            view.setClickable(clickListener != null);
        }
        return view;
    }

    /** 设置文本，必须是TextView */
    public TextView setText(int id, CharSequence sequence) {
        return setText(id, sequence, false);
    }

    /** 设置文本，必须是TextView */
    public TextView setText(int id, CharSequence sequence, boolean isAutoChangeVisibleAndGone) {
        TextView textView = getView(id);
        textView.setText(sequence);
        if (isAutoChangeVisibleAndGone) {
            textView.setVisibility(null == sequence || sequence.length() < 1 ? View.GONE : View.VISIBLE);
        }
        return textView;
    }

    /** 加载图片，必须是ImageView */
    public ImageView loadImage(int id, int defaultResId) {
        ImageView imageView = getView(id);
        imageView.setImageResource(defaultResId);
        return imageView;
    }

    ;

    /** 加载图片，必须是ImageView */
    public ImageView loadImage(int id, String url, int defaultResId) {
        return loadImage(id, url, defaultResId, 640);
    }

    ;

    /** 加载图片，必须是ImageView */
    public ImageView loadImage(int id, String url, int defaultResId, int width) {
        ImageView imageView = getView(id);
        //RKImageLoader.getInstance().loadImage(url, imageView, defaultResId, width);
        return imageView;
    }

    ;

    /** 设置View的可见性 */
    public LIBViewHolder setVisibility(int id, int visibility) {
        View view = getView(id);
        if (view.getVisibility() != visibility) {
            view.setVisibility(visibility);
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (null == o) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (null != tag && tag.equals(o)) {
            return true;
        }
        if (o instanceof Integer) {
            if (position == (Integer) o) {
                return true;
            }
        }
        return false;
    }

    public LIBBaseAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(LIBBaseAdapter adapter) {
        this.adapter = adapter;
    }

    @SuppressWarnings("unchecked")
    public static <T extends View> T get(View view, int id) {
        SparseArray<View> viewHolder = (SparseArray<View>) view.getTag();
        if (viewHolder == null) {
            viewHolder = new SparseArray<View>();
            view.setTag(viewHolder);
        }
        View childView = viewHolder.get(id);
        if (childView == null) {
            childView = view.findViewById(id);
            viewHolder.put(id, childView);
        }
        return (T) childView;
    }
}
