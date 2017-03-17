package com.shopin.commonlibrary.adapter;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2017/5/20.
 */
public class PriceTextWatcher<T extends PriceTextWatcher.UpdateEntityPrice> implements TextWatcher {

    private WeakReference<EditText> mEditText;
    private T t;

    private int numMax = 8;//默认可以输入8位小数

    public PriceTextWatcher(EditText editText) {
        mEditText = new WeakReference<>(editText);
    }

    public void setNumMax(int numMax) {
        if (numMax > 0)
            this.numMax = numMax;
    }

    public void setSyncEntity(T t) {
        this.t = t;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        //如果有小数点的情况下
        EditText editText = null;
        if ((editText = mEditText.get()) != null) {

            //如果有小数点的情况下
            if (s.toString().contains(".")) {

                if (s.length() - 1 - s.toString().indexOf(".") > 2) {
                    s = s.toString().subSequence(0,
                            s.toString().indexOf(".") + 3);
                    editText.setText(s);
                    editText.setSelection(s.length());
                }
            } else {
                if (s.toString().length() > numMax) {
                    s = s.toString().subSequence(0, numMax);
                    editText.setText(s);
                    editText.setSelection(s.length());
                }
            }

            //当是“.”开头的时候  直接输入为0.XX
            if (s.toString().trim().substring(0).equals(".")) {
                s = "0" + s;
                editText.setText(s);
                editText.setSelection(2);
            }
            //  如果是0开头的话   只能输入 0.XX
            if (s.toString().startsWith("0")
                    && s.toString().trim().length() > 1) {
                if (!s.toString().substring(1, 2).equals(".")) {
                    editText.setText(s.subSequence(0, 1));
                    editText.setSelection(1);
                    return;
                }
            }
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
//        String temp = s.toString();
//        if (!TextUtils.isEmpty(temp)) {
//            Double price = Double.valueOf(s.toString());
//            if (price > 0) {
//                if (t != null)
//                    t.setPrice(price);
//            }
//        }
    }


    public interface UpdateEntityPrice {
        public void setPrice(double price);
    }
}
