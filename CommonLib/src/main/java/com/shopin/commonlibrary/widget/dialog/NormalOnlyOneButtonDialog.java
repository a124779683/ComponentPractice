package com.shopin.commonlibrary.widget.dialog;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shopin.commonlibrary.R;


/**       只有一个按钮的普通dialog     “取消”或者“确定”  根据type类型判断   如果type=2  表示只有一个确定按钮   type=3“取消”和“确定”都有
 * Created by 张志强 on 2015/11/9.
 * 邮箱：zhangzhiqiang@zjsj1492.com
 */
public class NormalOnlyOneButtonDialog extends BaseDialog {
    private final String type;
    /**
     * container
     */
    private LinearLayout ll_container;
    /**
     * title
     */
    private TextView tv_title;
    /**
     * title underline
     */
    private View v_line_title;
    /**
     * content
     */
    private TextView tv_content;
    /**
     * left btn
     */
    private TextView tv_btn_left;
    /**
     * right btn
     */
    private TextView tv_btn_right;
    /**
     * vertical line between btns
     */
    private View v_line_vertical;
    /**
     * horizontal line above btns
     */
    private View v_line_horizontal;
    /**
     * title content(标题)
     */
    private String title = "温馨提示";
    /**
     * title textcolor(标题颜色)
     */
    private int titleTextColor = Color.parseColor("#61AEDC");
    /**
     * title textsize(标题字体大小,单位sp)
     */
    private float titleTextSize_PX =context.get().getResources().getDimensionPixelSize(R.dimen.ui_DIMEN_28_0PX);
    /**
     * enable title show(是否显示标题)
     */
    private boolean isTitleShow = true;
    /**
     * title underline color(标题下划线颜色)
     */
    private int titleLineColor = Color.parseColor("#61AEDC");
    /**
     * title underline height(标题下划线高度)
     */
    private float titleLineHeight_DP = 1f;
    /**
     * content text
     */
    private String content;
    /**
     * show gravity of content(正文内容显示位置)
     */
    private int contentGravity = Gravity.CENTER_VERTICAL;
    /**
     * content textcolor(正文字体颜色)
     */
    private int contentTextColor = Color.parseColor("#383838");
    /**
     * content textsize(正文字体大小)
     */
    private float contentTextSize_SP = context.get().getResources().getDimensionPixelSize(R.dimen.ui_DIMEN_28_0PX);
    /**
     * btn textcolor(按钮字体颜色)
     */
    private int btnLeftTextColor = Color.parseColor("#383838");
    private int btnRightTextColor = Color.parseColor("#383838");
    /**
     * btn textsize(按钮字体大小)
     */
    private float btnLeftTextSize_SP = context.get().getResources().getDimensionPixelSize(R.dimen.ui_DIMEN_26_0PX);
    private float btnRightTextSize_SP = context.get().getResources().getDimensionPixelSize(R.dimen.ui_DIMEN_26_0PX);
    /**
     * btn press color(按钮点击颜色)
     */
    private int btnColorPress = Color.parseColor("#E3E3E3");// #85D3EF,#ffcccccc,#E3E3E3
    /**
     * left btn text(左按钮内容)
     */
    private String btnLeftText = "确定";
    /**
     * right btn text(右按钮内容)
     */
    private String btnRightText = "取消";
    /**
     * corner radius,dp(圆角程度,单位dp)
     */
    private float cornerRadius_DP = 3;
    /**
     * background color(背景颜色)
     */
    private int bgColor = Color.parseColor("#ffffff");
    /**
     * btn divider line color(对话框之间的分割线颜色(水平+垂直))
     */
    private int dividerColor = Color.parseColor("#DADADE");
    /**
     * left btn click listener(左按钮接口)
     */
    private OnBtnLeftClick onBtnLeftClickL;
    /**
     * right btn click listener(右按钮接口)
     */
    private OnBtnRightClick onBtnRightClickL;

    public static final int STYLE_ONE = 0;
    public static final int STYLE_TWO = 1;
    private int style = STYLE_ONE;

    public NormalOnlyOneButtonDialog(Context context, String type) {
        super(context);
        this.type=type;
    }

    @Override
    public View onCreateView() {
        widthScale(0.88f);

        ll_container = new LinearLayout(context.get());
        ll_container.setOrientation(LinearLayout.VERTICAL);

        /** title */
        tv_title = new TextView(context.get());
        tv_title.setGravity(Gravity.CENTER);
        tv_title.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        ll_container.addView(tv_title);

        /** title underline */
        v_line_title = new View(context.get());
        ll_container.addView(v_line_title);

        /** content */
        tv_content = new TextView(context.get());
        tv_content.setGravity(Gravity.CENTER);
        tv_content.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        ll_container.addView(tv_content);

        v_line_horizontal = new View(context.get());
        v_line_horizontal.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 1));
        ll_container.addView(v_line_horizontal);

        /** btns */
        LinearLayout ll_btns = new LinearLayout(context.get());
        ll_btns.setOrientation(LinearLayout.HORIZONTAL);
        if ("3".equals(type)){
            tv_btn_left = new TextView(context.get());
            tv_btn_left.setGravity(Gravity.CENTER);
            tv_btn_left.setLayoutParams(new LinearLayout.LayoutParams(0, dp2px(45), 1));
            ll_btns.addView(tv_btn_left);
        }

        v_line_vertical = new View(context.get());
        v_line_vertical.setLayoutParams(new LinearLayout.LayoutParams(1, LinearLayout.LayoutParams.MATCH_PARENT));
        ll_btns.addView(v_line_vertical);

        tv_btn_right = new TextView(context.get());
        tv_btn_right.setGravity(Gravity.CENTER);
        tv_btn_right.setLayoutParams(new LinearLayout.LayoutParams(0, dp2px(45), 1));
        ll_btns.addView(tv_btn_right);

        ll_container.addView(ll_btns);

        return ll_container;
    }

    @Override
    public boolean setUiBeforShow() {
        float radius = dp2px(cornerRadius_DP);

        /** title */
        if (style == STYLE_ONE) {
            tv_title.setMinHeight(dp2px(48));
            tv_title.setGravity(Gravity.CENTER_VERTICAL);
            tv_title.setPadding(dp2px(15), dp2px(5), dp2px(0), dp2px(5));
            tv_title.setVisibility(isTitleShow ? View.VISIBLE : View.GONE);
        } else if (style == STYLE_TWO) {
            tv_title.setGravity(Gravity.CENTER);
            tv_title.setPadding(dp2px(0), dp2px(15), dp2px(0), dp2px(0));
            tv_title.setVisibility(isTitleShow ? View.VISIBLE : View.INVISIBLE);
        }

        tv_title.setText(TextUtils.isEmpty(title) ? "温馨提示" : title);
        tv_title.setTextColor(titleTextColor);
        tv_title.setTextSize(TypedValue.COMPLEX_UNIT_PX, titleTextSize_PX);

        /** title underline */
        v_line_title.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                dp2px(titleLineHeight_DP)));
        v_line_title.setBackgroundColor(titleLineColor);
        v_line_title.setVisibility(isTitleShow && style == STYLE_ONE ? View.VISIBLE : View.GONE);

        /** content */
        if (style == STYLE_ONE) {
            tv_content.setPadding(dp2px(15), dp2px(10), dp2px(15), dp2px(10));
            tv_content.setMinHeight(dp2px(100));
            tv_content.setGravity(contentGravity);
        } else if (style == STYLE_TWO) {
            tv_content.setPadding(dp2px(15), dp2px(7), dp2px(15), dp2px(20));
            tv_content.setMinHeight(dp2px(56));
            tv_content.setGravity(Gravity.CENTER);
        }

        tv_content.setText(content);
        tv_content.setTextColor(contentTextColor);
        tv_content.setTextSize(TypedValue.COMPLEX_UNIT_PX, contentTextSize_SP);

        /** btns */
        if ("3".equals(type)){
               tv_btn_left.setText(btnLeftText);
                 tv_btn_left.setTextColor(btnLeftTextColor);
               tv_btn_left.setTextSize(TypedValue.COMPLEX_UNIT_PX, btnLeftTextSize_SP);
        }

        tv_btn_right.setText(btnRightText);
        tv_btn_right.setTextColor(btnRightTextColor);
        tv_btn_right.setTextSize(TypedValue.COMPLEX_UNIT_PX, btnRightTextSize_SP);

        v_line_horizontal.setBackgroundColor(dividerColor);
        v_line_vertical.setBackgroundColor(dividerColor);

        /**set background color and corner radius */
        ll_container.setBackgroundDrawable(CornerUtils.cornerDrawable(bgColor, radius));
        tv_btn_right.setBackgroundDrawable(CornerUtils.btnSelector(radius, bgColor, btnColorPress, 1));
        if ("3".equals(type)){
               tv_btn_left.setBackgroundDrawable(CornerUtils.btnSelector(radius, bgColor, btnColorPress, 0));
        tv_btn_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onBtnLeftClickL != null) {
                    onBtnLeftClickL.onBtnLeftClick();
                         }
            }
        });
        }


        tv_btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onBtnRightClickL != null) {
                    onBtnRightClickL.onBtnRightClick();
                }
            }
        });

        return false;
    }

    // --->属性设置

    /**
     * set style(设置style)
     *
     * @param style
     * @return NormalDialog
     */
    public NormalOnlyOneButtonDialog style(int style) {
        this.style = style;
        return this;
    }

    /**
     * set title text(设置标题内容)
     *
     * @param title
     * @return NormalDialog
     */
    public NormalOnlyOneButtonDialog title(String title) {
        this.title = title;
        return this;
    }

    /**
     * set title textcolor(设置标题字体颜色)
     *
     * @param titleTextColor
     * @return NormalDialog
     */
    public NormalOnlyOneButtonDialog titleTextColor(int titleTextColor) {
        this.titleTextColor = titleTextColor;
        return this;
    }

    /**
     * set title textsize(设置标题字体大小)
     *
     * @param titleTextSize_PX
     * @return NormalDialog
     */
    public NormalOnlyOneButtonDialog titleTextSize(float titleTextSize_PX) {
        this.titleTextSize_PX = titleTextSize_PX;
        return this;
    }

    /**
     * set title underline color(设置标题下划线颜色)
     *
     * @param titleLineColor
     * @return NormalDialog
     */
    public NormalOnlyOneButtonDialog titleLineColor(int titleLineColor) {
        this.titleLineColor = titleLineColor;
        return this;
    }

    /**
     * set title underline height(设置标题下划线高度)
     *
     * @param titleLineHeight_DP
     * @return NormalDialog
     */
    public NormalOnlyOneButtonDialog titleLineHeight(float titleLineHeight_DP) {
        this.titleLineHeight_DP = titleLineHeight_DP;
        return this;
    }

    /**
     * enable title show(设置标题是否显示)
     *
     * @param isTitleShow
     * @return NormalDialog
     */
    public NormalOnlyOneButtonDialog isTitleShow(boolean isTitleShow) {
        this.isTitleShow = isTitleShow;
        return this;
    }

    /**
     * set content text(设置正文内容)
     *
     * @param content
     * @return NormalDialog
     */
    public NormalOnlyOneButtonDialog content(String content) {
        this.content = content;
        return this;
    }

    /**
     * set content gravity(设置正文内容,显示位置)
     *
     * @param contentGravity
     * @return NormalDialog
     */
    public NormalOnlyOneButtonDialog contentGravity(int contentGravity) {
        this.contentGravity = contentGravity;
        return this;
    }

    /**
     * set content textcolor(设置正文字体颜色)
     *
     * @param contentTextColor
     * @return NormalDialog
     */
    public NormalOnlyOneButtonDialog contentTextColor(int contentTextColor) {
        this.contentTextColor = contentTextColor;
        return this;
    }

    /**
     * set content textsize(设置正文字体大小,单位sp)
     *
     * @param contentTextSize_SP
     * @return NormalDialog
     */
    public NormalOnlyOneButtonDialog contentTextSize(float contentTextSize_SP) {
        this.contentTextSize_SP = contentTextSize_SP;
        return this;
    }


    /**
     * set btn text(设置按钮文字内容)
     *
     * @param btnLeftText
     * @param btnRightText
     * @return NormalDialog
     */
    public NormalOnlyOneButtonDialog btnText(String btnLeftText, String btnRightText) {
        this.btnLeftText = btnLeftText;
        this.btnRightText = btnRightText;
        return this;
    }

    /**
     * set btn textcolor(设置按钮字体颜色)
     *
     * @param btnLeftTextColor
     * @param btnRightTextColor
     * @return NormalDialog
     */
    public NormalOnlyOneButtonDialog btnTextColor(int btnLeftTextColor, int btnRightTextColor) {
        this.btnLeftTextColor = btnLeftTextColor;
        this.btnRightTextColor = btnRightTextColor;
        return this;
    }

    /**
     * set btn textsize(设置字体大小,单位sp,默认17f)
     *
     * @param btnLeftTextSize_SP
     * @param btnRightTextSize_SP
     * @return NormalDialog
     */
    public NormalOnlyOneButtonDialog btnTextSize(float btnLeftTextSize_SP, float btnRightTextSize_SP) {
        this.btnLeftTextSize_SP = btnLeftTextSize_SP;
        this.btnRightTextSize_SP = btnRightTextSize_SP;
        return this;
    }

    /**
     * set btn press color(设置按钮点击颜色)
     *
     * @param btnColorPress
     * @return NormalDialog
     */
    public NormalOnlyOneButtonDialog btnColorPress(int btnColorPress) {
        this.btnColorPress = btnColorPress;
        return this;
    }

    /**
     * set leftbtn click listener(设置左侧按钮监听事件)
     *
     * @param onBtnLeftClickL
     */
    public void setOnBtnLeftClick(OnBtnLeftClick onBtnLeftClickL) {
        this.onBtnLeftClickL = onBtnLeftClickL;
    }

    /**
     * set rightbtn click listener(设置右侧按钮监听事件)
     *
     * @param onBtnRightClickL
     */
    public void setOnBtnRightClick(OnBtnRightClick onBtnRightClickL) {
        this.onBtnRightClickL = onBtnRightClickL;
    }

    /**
     * set divider color between btns(设置btn分割线的颜色)
     *
     * @param dividerColor
     * @return NormalDialog
     */
    public NormalOnlyOneButtonDialog dividerColor(int dividerColor) {
        this.dividerColor = dividerColor;
        return this;
    }

    /**
     * set corner radius (设置圆角程度)
     *
     * @param cornerRadius_DP
     * @return NormalDialog
     */
    public NormalOnlyOneButtonDialog cornerRadius(float cornerRadius_DP) {
        this.cornerRadius_DP = cornerRadius_DP;
        return this;
    }

    /**
     * set backgroud color(设置背景色)
     *
     * @param bgColor
     * @return NormalDialog
     */
    public NormalOnlyOneButtonDialog bgColor(int bgColor) {
        this.bgColor = bgColor;
        return this;
    }

}