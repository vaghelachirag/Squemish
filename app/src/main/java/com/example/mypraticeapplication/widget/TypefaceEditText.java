package com.example.mypraticeapplication.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;

import com.example.mypraticeapplication.R;
import com.example.mypraticeapplication.fonts.FontUtils;
import com.google.android.material.textfield.TextInputEditText;


/**
 * CustomEditText
 * Use for set custom font from .xml file
 */
public class TypefaceEditText extends TextInputEditText {

    private DeleteEmptyListener mDeleteEmptyListener;


    public TypefaceEditText(Context context) {
        super(context);
    }

    public TypefaceEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        inIt(context, attrs);
    }

    public TypefaceEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Typeface face=Typeface.createFromAsset(context.getAssets(), "Poppins-Bold.ttf");
        this.setTypeface(face);
        inIt(context, attrs);
    }

    /**
     * Initialize and set all required param from this method
     * parsing custom style tags here
     *
     * @param context
     * @param attrs
     */
    private void inIt (Context context, AttributeSet attrs) {
        if (!isInEditMode()) {
            if (attrs != null) {
                TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TypefaceEditText);
                /*String fontName = a.getString(R.styleable.TypefaceEditText_custom_font);
                Typeface typeface = FontUtils.getInstance().getFont(context, fontName);
                if (typeface != null) {
                    setTypeface(typeface);
                }*/
                Typeface face=Typeface.createFromAsset(context.getAssets(), "roboto_regular.ttf");
                this.setTypeface(face);
            }
        }
    }

    public interface DeleteEmptyListener {
        void onDeleteEmpty();
    }

    private void listenForDeleteEmpty () {
        setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey (View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_DEL
                        && event.getAction() == KeyEvent.ACTION_DOWN
                        && mDeleteEmptyListener != null
                        && length() == 0) {
                    mDeleteEmptyListener.onDeleteEmpty();
                }
                return false;
            }
        });
    }

    @Override
    public InputConnection onCreateInputConnection (EditorInfo outAttrs) {
        return new SoftDeleteInputConnection(super.onCreateInputConnection(outAttrs), true);
    }

    private class SoftDeleteInputConnection extends InputConnectionWrapper {

        public SoftDeleteInputConnection (InputConnection target, boolean mutable) {
            super(target, mutable);
        }

        @Override
        public boolean deleteSurroundingText (int beforeLength, int afterLength) {
            // This method works on modern versions of Android with soft keyboard delete.
            if (getTextBeforeCursor(1, 0).length() == 0 && mDeleteEmptyListener != null) {
                mDeleteEmptyListener.onDeleteEmpty();
            }
            return super.deleteSurroundingText(beforeLength, afterLength);
        }
    }
}
