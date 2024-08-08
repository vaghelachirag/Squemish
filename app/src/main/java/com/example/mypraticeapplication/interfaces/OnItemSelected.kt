package com.example.mypraticeapplication.interfaces

import com.example.mypraticeapplication.model.pendingRequest.GetPendingRequestData

interface OnItemSelected<T> {
    fun onItemSelected(t: T?, position: Int)
}