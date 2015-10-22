package com.aidar.service;

import com.aidar.model.Office;

public interface ProviderService {

    boolean hasDelivered(Office office, String name);

}
