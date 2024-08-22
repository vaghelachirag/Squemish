package com.example.mypraticeapplication.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;


import com.example.mypraticeapplication.widget.searchablespinner.SearchableListDialog;

import java.util.ArrayList;
import java.util.List;


public class InstantAutoComplete extends androidx.appcompat.widget.AppCompatAutoCompleteTextView  implements View.OnTouchListener, View.OnClickListener, SearchableListDialog.SearchableItem {
    private Context _context;
    private List _items;
    private ArrayAdapter _arrayAdapter;

    private SearchableListDialog _searchableListDialog;

    private boolean isClickOnlyOnce = false;

    public InstantAutoComplete(Context context) {
        super(context);
        this._context = context;
        init();
    }

    private void init() {
       Log.e("Init","Init");
        _items = new ArrayList();
        _searchableListDialog = SearchableListDialog.newInstance(_items);
        _searchableListDialog.setOnSearchableItemClickListener(this);
        setOnTouchListener(this);

        _arrayAdapter = (ArrayAdapter) getAdapter();

       setOnClickListener(this);
       setOnTouchListener(this);
    }

    public void setListAdapter(List<String> houseLocalityList){
      Log.e("Test","Test" + houseLocalityList.size());
        _items = houseLocalityList;
    }

    public InstantAutoComplete(Context arg0, AttributeSet arg1) {
        super(arg0, arg1);
        this._context = arg0;

        Log.e("Auto","Auto" + arg1.getAttributeValue(1));
        init();
    }

    public InstantAutoComplete(Context arg0, AttributeSet arg1, int arg2) {
        super(arg0, arg1, arg2);
        Log.e("Auto","Auto1");
    }

    @Override
    public boolean enoughToFilter() {
        return true;
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction,
                                  Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (focused && getFilter()!=null) {
            performFiltering(getText(), 0);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.e("Touch","Toch");
        if (_searchableListDialog.isAdded()) {
            return true;
        }
        if (event.getAction() == MotionEvent.ACTION_UP) {
            Log.e("Touch","Toch");
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        Log.e("Touch","Click");
        if (!_searchableListDialog.isAdded()) {
            isClickOnlyOnce = true;
            _searchableListDialog = SearchableListDialog.newInstance(_items);
            _searchableListDialog.setOnSearchableItemClickListener(this);
            _searchableListDialog.show(scanForActivity(_context).getFragmentManager(), "TAG");
        }
    }

    @Override
    public void onSearchableItemClicked(Object item, int position) {
        setText(item.toString());
    }

    @Override
    public void onDialogDismiss() {

    }


    private Activity scanForActivity(Context cont) {
        if (cont == null)
            return null;
        else if (cont instanceof Activity)
            return (Activity) cont;
        else if (cont instanceof ContextWrapper)
            return scanForActivity(((ContextWrapper) cont).getBaseContext());

        return null;
    }



}
