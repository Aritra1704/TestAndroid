package com.arpaul.testandroid.TestableClasses;

import android.content.Context;

import com.arpaul.testandroid.R;

public class ClassUnderTest {

    Context mContext;

    public ClassUnderTest(Context context) {
        mContext = context;
    }

    public String getHelloWorldString() {
        return mContext.getString(R.string.hello_world);
    }
}
