package com.example.mypraticeapplication.interfaces

import com.example.mypraticeapplication.model.pendingRequest.GetPendingRequestData

interface OnItemSelected<GetPendingRequestData> {
    fun onItemSelected(t: com.example.mypraticeapplication.model.pendingRequest.GetPendingRequestData?, position: Int)
}